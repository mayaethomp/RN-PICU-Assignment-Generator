package rn.picu.assignment.generator.domain_tests;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import rn.picu.assignment.generator.domain.Nurse;
import rn.picu.assignment.generator.domain.Skill;
import rn.picu.assignment.generator.domain.UnitType;

public class NurseTest {

  @Test
  @DisplayName("Nurse returns expected name")
  void experiencedPicuNurseHasExpectedName() {
    Nurse nurse = NurseTestData.experiencedPICUNurse();
    assertEquals("Colleene PICU", nurse.getName());
  }

  @Test
  @DisplayName("Nurses with same ID are equal")
  void nursesWithSameIdAreEqual() {
    Nurse a = NurseTestData.experiencedPICUNurse();

    Nurse b = new Nurse(
        "Different Name",
        a.getId(),
        a.getUnitStartDate(),
        a.getHomeUnit(),
        a.getSkills(),
        a.getRestrictions());

    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());
  }

  @Test
  @DisplayName("Constructor rejects null name")
  void constructorRejectsNullName() {
    try {
      new Nurse(
          null,
          UUID.randomUUID(),
          LocalDate.now(),
          UnitType.PICU,
          Set.of(),
          Set.of());
      fail("Expected NullPointerException");
    } catch (NullPointerException ignored) {
      // pass
    }
  }

  @Test
  @DisplayName("Skills collection is immutable")
  void modifyingReturnedSkillsDoesNotAffectNurse() {
    Nurse nurse = NurseTestData.experiencedPICUNurse();

    assertThrows(UnsupportedOperationException.class, () -> nurse.getSkills().add(Skill.CVVH));
  }

}
