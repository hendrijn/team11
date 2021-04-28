package operations;

/**
 * Class for picking out the imaginary part of a complex (or real/imaginary) number.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
public class ImaginaryPartOperator
{
  /**
   * Isolates the imaginary part of the given operand.
   * 
   * @param operand
   *          a real, imaginary, or complex number.
   * @return the imaginary part of the operand.
   * @throws IllegalArgumentException
   *           if the operand is null, empty, or invalid.
   */
  public String evaluate(final String operand) throws IllegalArgumentException
  {
    // error checking for null/empty operand
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.NO_OPERAND));
    }

    String alteredOp = ((operand.replaceAll(Strings.SPACE, "")).replace(Strings.OPEN_PAREN, ""))
        .replace(Strings.CLOSED_PAREN, "");
    String result = "";

    // error checkng for invalid operand
    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.NO_OPERAND));
    }

    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    try
    {
      Double.parseDouble(((alteredOp.replace(Strings.I, "")).replace(Strings.PLUS, ""))
          .replaceAll(Strings.MINUS, "").replace(".", ""));
    }
    catch (NumberFormatException nfe)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    boolean isComplex = TempContext.isComplex(alteredOp);
    boolean isImaginary = TempContext.isImaginary(alteredOp);
    boolean isReal = TempContext.isReal(alteredOp);

    int negativeMinus = alteredOp.indexOf('-');
    int minus = alteredOp.indexOf('-', negativeMinus + 1);

    if (isComplex)
    {
      // operand with form -x-yi
      if (alteredOp.contains(Strings.MINUS) && minus != -1)
      {
        result = String.format(Strings.FORM,
            Double.parseDouble(alteredOp.substring(minus, alteredOp.indexOf('i')))) + Strings.I;
      }
      // operand with form x+yi or -x+yi
      else if (alteredOp.contains(Strings.PLUS))
      {
        result = String.format(Strings.FORM,
            Double.parseDouble(
                alteredOp.substring(alteredOp.indexOf('+') + 1, alteredOp.indexOf('i'))))
            + Strings.I;
      }
      // operand with from x-yi
      else
      {
        result = String.format(Strings.FORM,
            Double.parseDouble(alteredOp.substring(negativeMinus, alteredOp.indexOf('i'))))
            + Strings.I;
      }
    }

    if (isImaginary)
    {
      result = String.format(Strings.FORM,
          Double.parseDouble(alteredOp.substring(0, alteredOp.indexOf('i')))) + Strings.I;
    }

    if (isReal)
    {
      result = String.format(Strings.FORM, 0.0) + Strings.I;
    }
    return result;
  }
}
