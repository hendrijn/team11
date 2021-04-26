package operations;

import gui.NewMainInterface;

/**
 * Addition Operator Class.
 * 
 * @author team 11 - pgleb and may4sa
 * @version Sprint 2
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

    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    String rightRegularNumber = decomposedOperands[2];
    String rightImaginaryNumber = decomposedOperands[3];

    // Integer processing
    Double leftImagNumDouble = 0.0;
    try
    {
      leftImagNumDouble = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    Double leftRegNumDouble = 0.0;
    try
    {
      leftRegNumDouble = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    Double rightImagNumDouble = 0.0;
    try
    {
      rightImagNumDouble = Double.parseDouble(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    Double rightRegNumDouble = 0.0;
    try
    {
      rightRegNumDouble = Double.parseDouble(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    Double finalRegTotal = leftRegNumDouble + rightRegNumDouble;
    Double finalImagTotal = leftImagNumDouble + rightImagNumDouble;

    String formattedRegTotal = String.format("%.2f", finalRegTotal);
    String formattedImagTotal = String.format("%.2f", finalImagTotal);

    String result = formattedRegTotal + "+" + formattedImagTotal + "i";

    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf("+")) + "-"
          + result.substring(result.indexOf("+") + 2);
    }
    return result;
  }
}
