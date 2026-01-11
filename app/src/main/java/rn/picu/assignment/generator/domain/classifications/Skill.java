package rn.picu.assignment.generator.domain.classifications;

/**
 * Represents skills that can be acquired by the nurse through
 * training and/or certification and are required to be assigned to
 * some patients.
 */
public enum Skill {
  /**
   * Continuous veno-venous hemofiltration, also called CVVH, is a
   * form of continuous renal (or kidney) replacement therapy that
   * is like dialysis (also called CRRT)
   */
  CVVH,

  /**
   * Chemotherapy; requires certification
   */
  CHEMO,

  /**
   * The Carpediem™ system; intended for continuous renal
   * replacement therapy for pediatric patients weighing
   * between 2.5 and 10 kilograms.
   */
  CARPEDIEM,

  /**
   * Charge nurse; oversees operations of the nursing unit during a
   * shift and assigns nurses to patients for the following shift
   */
  CHARGE
}
