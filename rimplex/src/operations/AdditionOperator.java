package operations;

import gui.NewMainInterface;

/**
 * Class that includes operations to compute the sum of two complex, real, or imaginary numbers.
 * 
 * @author team 11 - pgleb and may4sa
 * @version Sprint 3
 */
public class AdditionOperator implements Operator
{
  private final String invalid = "NOT_VALID_OPERAND";
  private final String form = "%.2f";
  private final String plus = "+";

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
  public String evaluate(final String leftOperand, final String rightOperand)
      throws IllegalArgumentException
  {

    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(leftOperand, rightOperand);
    }
    catch (IllegalArgumentException e1)
    {
      throw new IllegalArgumentException(e1.getMessage());
    }

    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    String rightRegularNumber = decomposedOperands[2];
    String rightImaginaryNumber = decomposedOperands[3];

    // Process the parts of operands as doubles.
    Double leftImagNumDouble = 0.0;
    try
    {
      leftImagNumDouble = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(invalid));
    }

    Double leftRegNumDouble = 0.0;
    try
    {
      leftRegNumDouble = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(invalid));
    }

    Double rightImagNumDouble = 0.0;
    try
    {
      rightImagNumDouble = Double.parseDouble(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(invalid));
    }

    Double rightRegNumDouble = 0.0;
    try
    {
      rightRegNumDouble = Double.parseDouble(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(invalid));
    }

    Double finalRegTotal = leftRegNumDouble + rightRegNumDouble;
    Double finalImagTotal = leftImagNumDouble + rightImagNumDouble;

    String formattedRegTotal = String.format(form, finalRegTotal);
    String formattedImagTotal = String.format(form, finalImagTotal);

    String result = formattedRegTotal + plus + formattedImagTotal + "i";

    // If the result ends up with +-, revert to the proper -
    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf(plus)) + "-"
          + result.substring(result.indexOf(plus) + 2);
    }
    return result;
  }
}
