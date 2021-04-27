package operations;

import gui.NewMainInterface;

/**
 * class for computing multiplication of complex, real, and imaginary numbers.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class MultiplicationOperator implements Operator
{

  // attributes
  private final int iSquared = -1;
  private final String invalid = "NOT_VALID_OPERAND";
  private final String plus = "+";
  private final String form = "%.2f";
  private NewMainInterface ui = NewMainInterface.getInstance();

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
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    Double leftRegNumDouble = 0.0;
    try
    {
      leftRegNumDouble = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    Double rightImagNumDouble = 0.0;
    try
    {
      rightImagNumDouble = Double.parseDouble(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    Double rightRegNumDouble = 0.0;
    try
    {
      rightRegNumDouble = Double.parseDouble(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    double fOILFirst = leftRegNumDouble * rightRegNumDouble;
    double fOILOuters = leftRegNumDouble * rightImagNumDouble;
    double fOILInners = leftImagNumDouble * rightRegNumDouble;
    double fOILLasts = leftImagNumDouble * rightImagNumDouble * iSquared;

    double finalRegTotal = fOILFirst + fOILLasts;
    double finalImagTotal = fOILOuters + fOILInners;

    String result = String.format(form, finalRegTotal) + plus + String.format(form, finalImagTotal)
        + "i";

    // format to fix +- occurrence
    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf(plus)) + "-"
          + result.substring(result.indexOf(plus) + 2);
    }
    return result;
  }
}
