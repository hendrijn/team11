package operations;

import gui.NewMainInterface;

/**
 * class for computing the multiplicative inverse of an operand.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
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
  public String invert(final String operand)
  {

    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("VALID_OR_SIMPLIFY"));
    }

    double finalOperand = 0;

    if (!operand.contains("i"))
    {
      try
      {
        finalOperand = Double
            .parseDouble((((alteredOp.replace("i", "")).replace("+", "")).replaceAll("-", "")));
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

    String conjugate = cjOperator.conjugate(alteredOp);

    String denominator = multiContext.evaluate(alteredOp, conjugate);
    ;

    String finalResult = divContext.evaluate(conjugate, denominator);
    ;

    return finalResult;
  }

}
