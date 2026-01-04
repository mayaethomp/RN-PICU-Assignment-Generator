package rn.picu.assignment.generator.domain;

/**
 * Represents assignment restrictions that limit which patient populations
 * a nurse may be assigned to.
 */
public enum Restriction {

  /**
   * Nurse may not be assigned to patients requiring CVVH.
   */
  NO_CVVH,

  /**
   * Nurse may not be assigned to patients receiving chemotherapy.
   */
  NO_CHEMO,

  /**
   * Nurse may not be assigned to patients weighing less than 30 kilograms.
   */
  LESS_THAN_30KG,

  /**
   * Nurse may not be assigned to patients requiring certain isolation precautions.
   */
  ISOLATION,

  /**
   * Nurse may not be assigned to patients receiving radiation therapy.
   */
  RADIATION, 
  
  /**
   * Nurse may not be assigned to be resource nurse.
   */
  NO_TL
}
