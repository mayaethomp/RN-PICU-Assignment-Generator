package rn.picu.assignment.generator.domain.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import rn.picu.assignment.generator.domain.classifications.Restriction;
import rn.picu.assignment.generator.domain.classifications.Skill;
import rn.picu.assignment.generator.domain.classifications.UnitType;

/**
 * Represents a nurse to be assigned to a patient
 * 
 * <p>
 * A {@code Nurse} represents a member of the nursing staff available for assignment. This class stores
 * identity and scheduling-relevant attributes (e.g., start date, home unit, skills, and
 * restrictions) used by the assignment engine.
 * </p>
 * 
 * <p>
 * A {@code Nurse} has a unique identifier ({@link UUID}) and a recorded name. Assignment
 * eligibility and pairing decisions consider attributes such as unit start date (experience),
 * home unit, skills, restrictions, and other shift-specific constraints.
 * </p>
 */

public class Nurse {

  private final UUID id;
  private final String name;
  private final LocalDate unitStartDate;
  private final UnitType homeUnit;

  /**
   * Specialized skills acquired through training or certification
   * that affect assignment eligibility.
   */
  private final Set<Skill> skills;

  /**
   * Constraints that limit which patient populations
   * this nurse may be assigned to.
   */
  private final Set<Restriction> restrictions;

  /**
   * Constructs a new {@code Nurse}
   * 
   * @param name          the non-null name of the nurse
   * @param id            the non-null id number assigned to the nurse
   * @param unitStartDate the date of hire
   * @param homeUnit      the unit the nurse was hired to work on
   * @param skills        skills the nurse has acquired
   * @param restrictions  the nurse's patient population restrictions
   */
  public Nurse(String name,
      UUID id,
      LocalDate unitStartDate,
      UnitType homeUnit,
      Set<Skill> skills,
      Set<Restriction> restrictions) {
    this.name = Objects.requireNonNull(name);
    this.id = Objects.requireNonNull(id);
    this.unitStartDate = Objects.requireNonNull(unitStartDate);
    this.homeUnit = Objects.requireNonNull(homeUnit);
    this.skills = Set.copyOf(Objects.requireNonNull(skills));
    this.restrictions = Set.copyOf(Objects.requireNonNull(restrictions));
  }

  public String getName() {
    return name;
  }

  public UUID getId() {
    return id;
  }

  public UnitType getHomeUnit() {
    return homeUnit;
  }

  public LocalDate getUnitStartDate() {
    return unitStartDate;
  }

  /**
   * Returns the nurse's acquired skills.
   *
   * @return the nurse's acquired skills
   */
  public Set<Skill> getSkills() {
    return skills;
  }

  /**
   * Returns the nurse's patient population restrictions.
   *
   * @return the nurse's patient population restrictions
   */
  public Set<Restriction> getRestrictions() {
    return restrictions;
  }

  /**
   * @return the nurse's identifying information for debugging
   */
  @Override
  public String toString() {
    return "Nurse{name='%s', unit=%s, id=%s}".formatted(name, homeUnit, id);
  }

  /**
   * Indicates whether some other object is "equal to" this nurse.
   *
   * <p>
   * Two {@code Nurse} objects are considered equal if and only if they have the
   * same unique identifier ({@link UUID}), regardless of other fields such as
   * name,
   * skills,
   * or restrictions.
   * </p>
   *
   * <p>
   * This definition reflects the nurse as a domain entity whose identity is
   * defined solely by their assigned {@code UUID}.
   * </p>
   *
   * @param obj the reference object with which to compare
   * @return {@code true} if this object is equal to the {@code obj} argument;
   *         {@code false} otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Nurse))
      return false;
    Nurse nurse = (Nurse) obj;
    return id.equals(nurse.id);
  }

  /**
   * Returns a hash code value for this nurse.
   *
   * <p>
   * The hash code is derived solely from the nurse's unique identifier
   * ({@link UUID})
   * to remain consistent with the {@link #equals(Object)} implementation.
   * </p>
   *
   * <p>
   * This ensures correct behavior when {@code Nurse} objects are used in
   * hash-based
   * collections such as {@link java.util.HashSet} or {@link java.util.HashMap}.
   * </p>
   *
   * @return a hash code value for this nurse
   */
  @Override
  public int hashCode() {
    return id.hashCode();
  }

}
