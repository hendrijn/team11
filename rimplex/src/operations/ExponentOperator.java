package operations;

import gui.NewMainInterface;

/**
 * Class for evaluating operands raised to the exponential.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class ExponentOperator
{

  // attributes
  final private String BLANK_OPERAND = "0";

  /**
   * Evaluates an operand raised to a power.
   * 
   * @param operand
   *          the base of the exponential equation.
   * @param power
   *          the exponent to raise the base to.
   * @return the solution to the given base raised to the given power.
   */
  public String exponentation(String operand, String power)
  {
    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(operand, BLANK_OPERAND);
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    int powerOf = 0;
    try
    {
      powerOf = Integer.parseInt(power);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("BASE"));
    }

    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    double dblRegNum = 0.0;
    double dblImagNum = 0.0;
    double finalResult = 0.0;

    //Processing the parts of the operand as doubles
    try
    {
      dblRegNum = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e1)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    try
    {
      dblImagNum = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e2)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    if (dblImagNum == 0.00)
    {
      finalResult = Math.pow(dblRegNum, powerOf);
      return String.valueOf(finalResult) + "+00.0i";
    }

    String runningOperand = operand;
    String finalOperand = "";
    TempContext multiOp = new TempContext(new MultiplicationOperator());

    for (int i = 1; i < powerOf; i++)
    {
      finalOperand = multiOp.evaluate(operand, runningOperand);
      runningOperand = finalOperand;
    }

    //If negative zero is in the string, change it to 0.00
    if (finalOperand.substring(0, 4).equals("-0.0"))
    {
      finalOperand = "0.00" + finalOperand.substring(5);
    }
    return finalOperand;
  }
}
