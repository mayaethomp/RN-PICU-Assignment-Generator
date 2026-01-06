package rn.picu.assignment.generator.domain;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a patient that is admitted to the unit and requiring a nurse
 * assignment.
 * 
 * <p>
 * A {@code Patient} represents a patient on the unit who needs
 * a nurse assigned to care for them. This class stores
 * identity information and scheduling-relevant attributes
 * such as skills required to care for the patient.
 * </p>
 * 
 * <p>
 * A {@code Patient} has a unique identifier ({@link UUID}).
 * The patient does not have a recorded name due to HIPAA laws.
 */

public class Patient {
  private final UUID id;
  private final int roomNumber;

  /**
   * Specialized skills that are required for the nurse to have to care for the
   * patient
   */
  private final Set<Skill> requiredSkills;

  /**
   * Constructs a new {@code Patient}
   * 
   * @param id         the non-null id number assigned to the patient
   * @param roomNumber the positive room number the patient is in
   * @param skills     skills the patient requires of the nurse assigned
   */

  public Patient(UUID id, int roomNumber, Set<Skill> skills) {
    this.id = Objects.requireNonNull(id);

    if (roomNumber <= 0 || roomNumber >= 26) {
      throw new IllegalArgumentException("roomNumber must be positive and up to 25");
    }
    this.roomNumber = Objects.requireNonNull(roomNumber);

    this.requiredSkills = Set.copyOf(Objects.requireNonNull(skills, "skills must not be null"));
  }

  public UUID getId() {
    return id;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  /**
   * Returns the skills required by the nurse to care for the patient
   * 
   * @return skills the patient requires of the nurse assigned
   */
  public Set<Skill> getRequiredSkills() {
    return requiredSkills;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Patient))
      return false;
    Patient other = (Patient) o;
    return id.equals(other.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

}
