package rn.picu.assignment.generator.domain;

import java.time.LocalDate;
import java.util.Set;

public class Nurse {
  private final int id;
  private final String name;
  private final LocalDate unitStartDate; 
  private final UnitType homeUnit;

  private final Set<Skill> skills;
  private final Set<Restriction> restrictions;

  

  public Nurse (String name,
                int id, 
                LocalDate unitStartDate, 
                UnitType homeUnit,
                Set<Skill> skills,
                Set<Restriction> restrictions
  ) {
    this.name = name;
    this.id = id;
    this.unitStartDate = unitStartDate; 
    this.homeUnit = homeUnit;
    this.skills = Set.copyOf(skills);
    this.restrictions = Set.copyOf(restrictions);
  }


}
