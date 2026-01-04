package rn.picu.assignment.generator.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * 
 */

public class Nurse {
  private final UUID id;
  private final String name;
  private final LocalDate unitStartDate; 
  private final UnitType homeUnit;

  private final Set<Skill> skills;
  private final Set<Restriction> restrictions;
  

  public Nurse (String name,
                UUID id, 
                LocalDate unitStartDate, 
                UnitType homeUnit,
                Set<Skill> skills,
                Set<Restriction> restrictions
  ) {
    this.name = Objects.requireNonNull(name);
    this.id = Objects.requireNonNull(id);
    this.unitStartDate = Objects.requireNonNull(unitStartDate); 
    this.homeUnit = homeUnit;
    this.skills = Set.copyOf(skills);
    this.restrictions = Set.copyOf(restrictions);
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

  public LocalDate getStartDate() {
    return unitStartDate;
  }

  public Set<Skill> getSkills() {
    return skills;
  }

  public Set<Restriction> getRestrictions() {
    return restrictions;
  }

  @Override
  public String toString() {
    return "RN: " + name + ", " + homeUnit + " | Employee ID: " + id + " |  Skills: " + skills + " | Restrictions: " + restrictions;
  }


}
