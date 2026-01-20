package rn.picu.assignment.generator.domain.classifications;

/**
 * Represents care complexities that are relevant to a patient and may limit the nurses that
 * can be assigned.
 */
public enum CareComplexity {
  FEMALE_CAREGIVERS_ONLY,
  PATIENT_BEHAVIORAL,
  FAMILY_BEHAVIORAL,
  /**
   * Patients requiring to be assigned 1:1 with a nurse.
   */
  ONE_TO_ONE,
  /**
   * End of life.
   */
  EOL,
  SELF_HARM,

  /**
   * Hospital holds designates a minor patient unable to be visited or discharged by a parent expected of abuse or neglect
   */
  HOSPITAL_HOLD,
  ISOLATION
}
