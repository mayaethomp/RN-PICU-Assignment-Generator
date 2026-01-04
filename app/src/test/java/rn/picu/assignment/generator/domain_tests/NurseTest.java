package rn.picu.assignment.generator.domain_tests;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import rn.picu.assignment.generator.domain.Nurse;
import rn.picu.assignment.generator.domain.UnitType;

public class NurseTest {

  @Test
  @DisplayName("Constructor invariants")
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

}
