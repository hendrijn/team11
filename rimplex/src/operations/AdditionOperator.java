package operations;

/**
 * Class that includes operations to compute the sum of two complex, real, or imaginary numbers.
 * 
 * @author team 11 - pgleb and may4sa
 * @version Sprint 3
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
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    Double leftRegNumDouble = 0.0;
    try
    {
      leftRegNumDouble = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    Double rightImagNumDouble = 0.0;
    try
    {
      rightImagNumDouble = Double.parseDouble(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    Double rightRegNumDouble = 0.0;
    try
    {
      rightRegNumDouble = Double.parseDouble(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    Double finalRegTotal = leftRegNumDouble + rightRegNumDouble;
    Double finalImagTotal = leftImagNumDouble + rightImagNumDouble;

    String formattedRegTotal = String.format(Strings.FORM, finalRegTotal);
    String formattedImagTotal = String.format(Strings.FORM, finalImagTotal);

    String result = formattedRegTotal + Strings.PLUS + formattedImagTotal + Strings.I;

    // If the result ends up with +-, revert to the proper -
    if (result.contains(Strings.PLUS_MINUS))
    {
      result = result.substring(0, result.indexOf(Strings.PLUS)) + Strings.MINUS
          + result.substring(result.indexOf(Strings.PLUS) + 2);
    }
    return result;
  }
}
