package operations;

import gui.NewMainInterface;

/**
 * class for computing the multiplicative inverse of an operand.
 * 
 * @author pgleb - team 11
 * @version Sprint 2
 */
public class InverseOperator
{

  /**
   * Blank Constructor to use for invert.
   */
  public InverseOperator()
  {

  }

  /**
   * Takes in a number, and returns its mulitplicative inverse.
   * 
   * @param operand
   *          The number to be inverted.
   * @return Its inverse
   * @throws An
   *           IllegalArgumentExcpetion if invalid operands are provided.
   */
  public String invert(String operand)
  {

    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    if (!operand.contains("i"))
    {
      double finalOperand = 0;
      try
      {
        finalOperand = Double.parseDouble(operand);
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
      }

      double finalReturnOperand = (1 / finalOperand);

      return String.valueOf(finalReturnOperand) + "+0.00i";
    }

    TempContext multiContext = new TempContext(new MultiplicationOperator());
    TempContext divContext = new TempContext(new DivisionOperator());
    ConjugateOperator cjOperator = new ConjugateOperator();

    String conjugate = "";
    try
    {
      conjugate = cjOperator.conjugate(operand);
    }
    catch (IllegalArgumentException e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }
    String denominator = "";
    try
    {
      denominator = multiContext.evaluate(operand, conjugate);
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }
    String finalResult = "";
    try
    {
      finalResult = divContext.evaluate(conjugate, denominator);
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    return finalResult;
  }

}
