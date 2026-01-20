package rn.picu.assignment.generator.io;

import java.util.List;

import rn.picu.assignment.generator.domain.classifications.Restriction;
import rn.picu.assignment.generator.domain.classifications.Skill;
import rn.picu.assignment.generator.domain.classifications.UnitType;
import rn.picu.assignment.generator.domain.entities.Nurse;

public class NurseEntry {
  private Nurse nurse;
  private List<Skill> skills;
  private List<Restriction> restrictions;
  private UnitType homeUnit;

  public NurseEntry(Nurse nurse, List<Skill> skills, List<Restriction> restrictions, UnitType homeUnit) {
    
  }
}
