package operations;

/**
 * class for computing the multiplicative inverse of an operand.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class InverseOperator
{
  /**
   * Takes in a number, and returns its multiplicative inverse.
   * 
   * @param operand
   *          The number to be inverted.
   * @return Its inverse
   * @throws IllegalArgumentException
   *           if invalid operands are provided.
   */
  public String invert(final String operand) throws IllegalArgumentException
  {
    // error checking for null/emoty
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    String alteredOp = ((operand.replaceAll(Strings.SPACE, "")).replace(Strings.OPEN_PAREN, ""))
        .replace(Strings.CLOSED_PAREN, "");

    // error checking for invalid
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    double finalOperand = 0;
    if (!operand.contains(Strings.I))
    {
      try
      {
        finalOperand = Double
            .parseDouble((((alteredOp.replace(Strings.I, "")).replace(Strings.PLUS, ""))
                .replaceAll(Strings.MINUS, "")));
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
      }
      double finalReturnOperand = (1 / finalOperand);

      return String.format(Strings.FORM, finalReturnOperand) + "+0.00i";
    }

    TempContext multiContext = new TempContext(new MultiplicationOperator());
    TempContext divContext = new TempContext(new DivisionOperator());
    ConjugateOperator cjOperator = new ConjugateOperator();

    String conjugate = cjOperator.conjugate(alteredOp);
    String denominator = multiContext.evaluate(alteredOp, conjugate);
    String finalResult = divContext.evaluate(conjugate, denominator);

    return finalResult;
  }
}
