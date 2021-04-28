package operations;

/**
 * class for computing multiplication of complex, real, and imaginary numbers.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class MultiplicationOperator implements Operator
{
  private final int iSquared = -1;

  /**
   * This evaluates two operands using multiplication!
   * 
   * @param leftOperand
   *          The left operand to be evaluated.
   * @param rightOperand
   *          The right operand to be evaluated.
   * @return a string of the two operands multiplied together.
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

    // Integer processing/invalid error checking
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

    double fOILFirst = leftRegNumDouble * rightRegNumDouble;
    double fOILOuters = leftRegNumDouble * rightImagNumDouble;
    double fOILInners = leftImagNumDouble * rightRegNumDouble;
    double fOILLasts = leftImagNumDouble * rightImagNumDouble * iSquared;

    double finalRegTotal = fOILFirst + fOILLasts;
    double finalImagTotal = fOILOuters + fOILInners;

    String result = String.format(Strings.FORM, finalRegTotal) + Strings.PLUS
        + String.format(Strings.FORM, finalImagTotal) + Strings.I;

    // format to fix +- occurrence
    if (result.contains(Strings.PLUS_MINUS))
    {
      result = result.substring(0, result.indexOf(Strings.PLUS)) + Strings.MINUS
          + result.substring(result.indexOf(Strings.PLUS) + 2);
    }
    return result;
  }
}
