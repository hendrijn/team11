package operations;

/**
 * An operator is either addition or subtraction, that will take two complex numbers and return the
 * mathematically correct calculation of them.
 * 
 * @author team11 (Patrick Glebus)
 * @version Sprint 2
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
   */

  public abstract String evaluate(String leftOperand, String rightOperand);

}
