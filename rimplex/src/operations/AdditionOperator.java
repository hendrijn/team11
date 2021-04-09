package operations;

/**
 * Addition Operator Class.
 * 
 * @author team 11 - pgleb and may4sa
 * @version Sprint 1
 */
public class AdditionOperator implements Operator
{

  /**
   * Evaluates an addition of two operands.
   * 
   * @param leftOperand
   *          the operand that the rightOperand will be added to.
   * @param rightOperand
   *          the operand that will be added to the leftOperand.
   * @return the sum of the two operands.
   * @throws IllegalArgumentException
   *           thrown if operands are null or empty.
   */
  @Override
  public String evaluate(String leftOperand, String rightOperand)
  {

    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(leftOperand, rightOperand);
    }
    catch (Exception e1)
    {
      throw new IllegalArgumentException(e1.getMessage());
    }
    
    String leftRegularNumber     = decomposedOperands[0];
    String leftImaginaryNumber   = decomposedOperands[1];
    String rightRegularNumber    = decomposedOperands[2];
    String rightImaginaryNumber  = decomposedOperands[3];
    
    // Integer processing
    long leftImagNumLong = 0;
    try
    {
      leftImagNumLong = Long.parseLong(leftImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException("Not a valid operand.");
    }

    long leftRegNumLong = 0;
    try
    {
      leftRegNumLong = Long.parseLong(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    long rightImagNumLong = 0;
    try
    {
      rightImagNumLong = Long.parseLong(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    long rightRegNumLong = 0;
    try
    {
      rightRegNumLong = Long.parseLong(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    long finalRegTotal = leftRegNumLong + rightRegNumLong;
    long finalImagTotal = leftImagNumLong + rightImagNumLong;

    String result = finalRegTotal + "+" + finalImagTotal + "i";

    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf("+")) + "-"
          + result.substring(result.indexOf("+") + 2);
    }
    return result;
  }
}
