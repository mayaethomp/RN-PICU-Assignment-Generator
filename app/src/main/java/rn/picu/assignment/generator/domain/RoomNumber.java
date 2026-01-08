package rn.picu.assignment.generator.domain;

import java.util.Set;

/**
 * Represents a room on the PICU unit.
 *
 * <p>Valid rooms are 1–25, excluding 9 and 19, based on the physical unit layout.
 * A {@code RoomNumber} is immutable and always valid once created.</p>
 */
public record RoomNumber(int value) {

  private static final Set<Integer> VALID_ROOMS = Set.of(
      1, 2, 3, 4, // STATION 1
      5, 6, 7, 8, 10, // STATION 2
      11, 12, 13, 14, // STATION 3
      15, 16, 17, // STATION 5
      18, 20, 21, // STATION 6
      22, 23, 24, 25 // STATION 7
  );

  /**
 * Creates a {@code RoomNumber}.
 *
 * @param value the numeric room identifier
 * @throws IllegalArgumentException if the room number is not valid on the unit
 */

  public RoomNumber {
    if (!VALID_ROOMS.contains(value)) {
      throw new IllegalArgumentException("Invalid room number: " + value);
    }
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
