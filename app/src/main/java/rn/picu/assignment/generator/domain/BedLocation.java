package rn.picu.assignment.generator.domain;

public record BedLocation(RoomNumber room, BedSide bedSide) {

  /**
 * Represents the physical bed location of a patient on the PICU unit.
 *
 * <p>A {@code BedLocation} consists of a validated room number and,
 * for shared rooms, a required bed side. Shared rooms on the unit
 * (rooms 1 and 24) contain two beds, identified as side {@link BedSide#A}
 * or {@link BedSide#B}. All other rooms are single-bed rooms and
 * must not specify a bed side.</p>
 *
 * <p>This record enforces the following invariants:
 * <ul>
 *   <li>Room numbers must be valid for the unit</li>
 *   <li>Shared rooms (1 and 24) require a bed side</li>
 *   <li>Non-shared rooms must not specify a bed side</li>
 * </ul>
 * </p>
 *
 * <p>{@code BedLocation} is a value object and is immutable.</p>
 */

  public BedLocation {
    if (room == null) {
      throw new IllegalArgumentException("room must not be null");
    }

    boolean isSharedRoom = room.value() == 1 || room.value() == 24;

    if (isSharedRoom && bedSide == null) {
      throw new IllegalArgumentException(
          "Shared rooms (1 and 24) require a bed side (A or B)");
    }

    if (!isSharedRoom && bedSide != null) {
      throw new IllegalArgumentException(
          "Non-shared rooms must not specify a bed side");
    }
  }

  /**
   * Creates a {@link BedLocation} for a non-shared room.
   *
   * <p>
   * This factory method validates the room number and returns a
   * {@code BedLocation} without a bed side. It should be used for
   * rooms that are not shared (i.e., all rooms except 1 and 24).
   * </p>
   *
   * @param roomNumber the room number on the unit
   * @return a {@code BedLocation} without a bed side
   * @throws IllegalArgumentException if the room number is invalid
   */
  public static BedLocation of(int roomNumber) { // Single bed rooms
    return new BedLocation(new RoomNumber(roomNumber), null);
  }

  /**
   * Creates a {@link BedLocation} for a shared room.
   *
   * <p>
   * This factory method validates the room number and bed side and returns
   * a {@code BedLocation} that includes a required bed side. It should be used
   * for shared rooms on the unit (rooms 1 and 24).
   * </p>
   *
   * @param roomNumber the room number on the unit
   * @param bedSide    the bed side within the shared room (A or B)
   * @return a {@code BedLocation} with the specified bed side
   * @throws IllegalArgumentException if the room number is invalid or if the
   *                                  bed side is not appropriate for the given
   *                                  room
   */
  public static BedLocation of(int roomNumber, BedSide bedSide) { // Shared rooms
    return new BedLocation(new RoomNumber(roomNumber), bedSide);
  }
}
