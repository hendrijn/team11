package operations;

/**
 * Class for evaluating operands raised to the exponential.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class ExponentOperator
{
  /**
   * Evaluates an operand raised to a power.
   * 
   * @param operand
   *          the base of the exponential equation.
   * @param power
   *          the exponent to raise the base to.
   * @return the solution to the given base raised to the given power.
   * @throws IllegalArgumentException
   *           if the operand or power are null, empty, or invalid.
   */
  public String exponentation(final String operand, final String power)
      throws IllegalArgumentException
  {
    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(operand, Strings.NO_OPERAND);
    }
    catch (IllegalArgumentException e)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    int powerOf = 0;
    try
    {
      powerOf = Integer.parseInt(power);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString("BASE"));
    }

    // If to the zero power, return 1. Done here to save work
    if (powerOf == 0)
    {
      return Strings.ZERO_BASE;
    }

    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    double dblRegNum = 0.0;
    double dblImagNum = 0.0;
    double finalResult = 0.0;
    String finalOperand = "";

    // Processing the parts of the operand as doubles
    try
    {
      dblRegNum = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e1)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    try
    {
      dblImagNum = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e2)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    if (dblImagNum == 0.00)
    {
      finalResult = Math.pow(dblRegNum, powerOf);
      finalOperand = String.format("%.2f+0.00i", finalResult);
    }
    else
    {
      String runningOperand = operand;
      TempContext multiOp = new TempContext(new MultiplicationOperator());

      if (powerOf == 1)
      {
        finalOperand = String.format("%.2f+%.2fi", dblRegNum, dblImagNum);
      }

      // iterative multiplication
      for (int i = 1; i < powerOf; i++)
      {
        finalOperand = multiOp.evaluate(operand, runningOperand);
        runningOperand = finalOperand;
      }

    }
    return finalOperand;
  }
}
