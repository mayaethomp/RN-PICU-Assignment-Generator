package rn.picu.assignment.generator.domain_tests;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import rn.picu.assignment.generator.domain.classifications.Restriction;
import rn.picu.assignment.generator.domain.classifications.Skill;
import rn.picu.assignment.generator.domain.classifications.UnitType;
import rn.picu.assignment.generator.domain.entities.Nurse;

class NurseTestData {

    static Nurse experiencedPICUNurse() {
      return new Nurse(
        "Colleene PICU",
        UUID.fromString("11111111-1111-1111-1111-111111111111"),
        LocalDate.now().minusYears(5),
        UnitType.PICU,
        Set.of(Skill.CVVH, Skill.CHEMO, Skill.CHARGE, Skill.CARPEDIEM),
        Set.of()
      );
    }

    static Nurse newGradPicuNurse() {
    return new Nurse(
        "Jamie NewGrad",
        UUID.fromString("22222222-2222-2222-2222-222222222222"),
        LocalDate.now().minusMonths(3),
        UnitType.PICU,
        Set.of(),
        Set.of(Restriction.NO_CVVH, Restriction.NO_CHEMO)
    );
  }

  static Nurse nicuFloatNurse() {
    return new Nurse(
        "Taylor NICU",
        UUID.fromString("33333333-3333-3333-3333-333333333333"),
        LocalDate.now().minusYears(2),
        UnitType.NICCU,
        Set.of(Skill.CARPEDIEM),
        Set.of(Restriction.LESS_THAN_30KG, Restriction.NO_TL)
    );
  }

  static Nurse chemoRestrictedNurse() {
    return new Nurse(
        "Morgan Chemo",
        UUID.fromString("44444444-4444-4444-4444-444444444444"),
        LocalDate.now().minusYears(4),
        UnitType.PICU,
        Set.of(Skill.CVVH),
        Set.of(Restriction.NO_CHEMO)
    );
  }

  static Nurse precepteeNurse() {
    return new Nurse(
        "Riley Preceptee",
        UUID.fromString("55555555-5555-5555-5555-555555555555"),
        LocalDate.now().minusMonths(1),
        UnitType.PICU,
        Set.of(),
        Set.of(Restriction.NO_CVVH, Restriction.NO_CHEMO, Restriction.NO_TL)
    );
  }
}