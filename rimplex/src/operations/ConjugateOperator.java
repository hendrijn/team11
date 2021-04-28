package operations;

/**
 * class for computing the conjugate of a complex/imaginary number. Used for the inverse and
 * division.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
public class ConjugateOperator
{
  /**
   * computes the conjugate of a complex/imaginary operand.
   * 
   * @param operand
   *          the operand to compute the conjugate of.
   * @return the conjugate.
   * @throws IllegalArgumentException
   *           if the operand is null, empty, or invalid.
   */
  public String conjugate(final String operand) throws IllegalArgumentException
  {
    // error checking
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.NO_OPERAND));
    }

    // operand w/o spaces and parens
    String alteredOp = ((operand.replaceAll(Strings.SPACE, "")).replace(Strings.OPEN_PAREN, ""))
        .replace(Strings.CLOSED_PAREN, "");

    // error checking for empty and bad operands
    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.NO_OPERAND));
    }

    if ((alteredOp.indexOf(Strings.I, alteredOp.indexOf(Strings.I) + 1) != -1))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    if ((alteredOp.replace(Strings.I, "")).matches(".*[a-zA-Z]+.*"))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    String result = "";

    // type checking
    boolean complex = TempContext.isComplex(alteredOp);
    boolean imaginary = TempContext.isImaginary(alteredOp);

    if (complex)
    {
      int negMin = alteredOp.indexOf(Strings.MINUS);
      int min = alteredOp.indexOf(Strings.MINUS, negMin + 1);

      if (alteredOp.contains(Strings.PLUS))
      {
        result = alteredOp.substring(0, alteredOp.indexOf(Strings.PLUS)) + Strings.MINUS
            + alteredOp.substring(alteredOp.indexOf(Strings.PLUS) + 1);
      }
      else
      {
        if (min != -1)
        {
          result = alteredOp.substring(0, min) + Strings.PLUS + alteredOp.substring(min + 1);
        }
        else
        {
          result = alteredOp.substring(0, negMin) + Strings.PLUS + alteredOp.substring(negMin + 1);
        }
      }
    }

    if (imaginary)
    {
      if (alteredOp.charAt(0) == '-')
      {
        result = alteredOp.substring(1);
      }
      else
      {
        result = Strings.MINUS + alteredOp;
      }
    }
    return result;
  }
}
