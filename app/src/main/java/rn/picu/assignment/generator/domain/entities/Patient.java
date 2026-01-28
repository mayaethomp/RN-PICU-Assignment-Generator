package rn.picu.assignment.generator.domain.entities;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import rn.picu.assignment.generator.domain.classifications.Skill;

/**
 * Represents a patient that is admitted to the unit and requiring a patient
 * assignment.
 * 
 * <p>
 * A {@code Patient} represents a patient on the unit who needs
 * a patient assigned to care for them. This class stores
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
  private final BedLocation location;

  /**
   * Specialized skills that are required for the patient to have to care for the
   * patient
   */
  private final Set<Skill> requiredSkills;

  /**
   * Constructs a new {@code Patient}
   * 
   * @param id         the non-null id number assigned to the patient
   * @param location the positive room number the patient is in
   * @param skills     skills the patient requires of the patient assigned
   */

  public Patient(UUID id, BedLocation location, Set<Skill> skills) {
    this.id = Objects.requireNonNull(id);
    this.location = Objects.requireNonNull(location);
    this.requiredSkills = Set.copyOf(Objects.requireNonNull(skills, "skills must not be null"));
  }

  public UUID getId() {
    return id;
  }

  public BedLocation getlocation() {
    return location;
  }

  /**
   * Returns the skills required by the nurse to care for the patient
   * 
   * @return skills the patient requires of the patient assigned
   */
  public Set<Skill> getRequiredSkills() {
    return requiredSkills;
  }

  /**
   * Indicates whether some other object is "equal to" this patient.
   *
   * <p>
   * Two {@code Patient} objects are considered equal if and only if they have the
   * same unique identifier ({@link UUID}), regardless of other fields such as
   * skills
   * </p>
   *
   * <p>
   * This definition reflects the patient as a domain entity whose identity is
   * defined solely by their assigned {@code UUID}.
   * </p>
   *
   * @param obj the reference object with which to compare
   * @return {@code true} if this object is equal to the {@code obj} argument;
   *         {@code false} otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Patient))
      return false;
    Patient other = (Patient) o;
    return id.equals(other.id);
  }

  /**
   * Returns a hash code value for this patient.
   *
   * <p>
   * The hash code is derived solely from the patient's unique identifier
   * ({@link UUID})
   * to remain consistent with the {@link #equals(Object)} implementation.
   * </p>
   *
   * <p>
   * This ensures correct behavior when {@code Patient} objects are used in
   * hash-based
   * collections such as {@link java.util.HashSet} or {@link java.util.HashMap}.
   * </p>
   *
   * @return a hash code value for this patient
   */
  @Override
  public int hashCode() {
    return id.hashCode();
  }

}
