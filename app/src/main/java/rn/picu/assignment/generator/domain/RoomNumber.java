package rn.picu.assignment.generator.domain;

import java.util.Set;

public record RoomNumber(int value) {

  private static final Set<Integer> VALID_ROOMS = Set.of(
      1, 2, 3, 4, // STATION 1
      5, 6, 7, 8, 10, // STATION 2
      11, 12, 13, 14, // STATION 3
      15, 16, 17, // STATION 5
      18, 20, 21, // STATION 6
      22, 23, 24, 25 // STATION 7
  );

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
