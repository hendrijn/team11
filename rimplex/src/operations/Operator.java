package operations;

/**
 * An operator is a class the performs mathematical computation taking two complex, real, or
 * imaginary numbers and will return the mathematically correct calculation of them.
 * 
 * @author team11 (Patrick Glebus)
 * @version Sprint 3
 */

public interface Operator
{
  /**
   * Evaluates the result between two (complex) numbers.
   * 
   * @param leftOperand
   *          The left operand the operation is to be performed on.
   * @param rightOperand
   *          The right operand the operation is to be performed on in conjunction with the left
   *          operand.
   * @return The result of the performing the evaluation on the two operands.
   * @throws IllegalArgumentException
   *           if either of the operands are null, empty, or invalid.
   */
  public abstract String evaluate(final String leftOperand, final String rightOperand)
      throws IllegalArgumentException;
}
