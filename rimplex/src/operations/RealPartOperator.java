package operations;

import gui.NewMainInterface;

/**
 * Class for picking out the real part of a complex (or real/imaginary) number.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
public class RealPartOperator
{
  // attributes
  private final String FORM = "%.2f";

  /**
   * Isolates the real part of the given operand.
   * 
   * @param operand
   *          a real, imaginary, or complex number.
   * @return the real part of the operand.
   */
  public String evaluate(final String operand)
  {
    // error checking for null/empty operand
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException("Please enter an operand");
    }

    // removes spaces and parens
    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    String result = "";

    // checks for only paren operand
    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NO_OPERAND"));
    }

    // error checking for multiple i's
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("VALID_OR_SIMPLIFY"));
    }

    // error chekcing for random Strings
    try
    {
      Double.parseDouble(((alteredOp.replace("i", "")).replace("+", "")).replaceAll("-", ""));
    }
    catch (NumberFormatException nfe)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("VALID_OR_SIMPLIFY"));
    }

    // decides the number type of the operand
    boolean isComplex = TempContext.isComplex(alteredOp);
    boolean isImaginary = TempContext.isImaginary(alteredOp);
    boolean isReal = TempContext.isReal(alteredOp);

    // vars to differentiate between a complex num with two '-' and one '-'
    int negativeMinus = alteredOp.indexOf('-');
    int minus = alteredOp.indexOf('-', negativeMinus + 1);

    if (isComplex)
    {
      // operand with form -x-yi
      if (alteredOp.contains("-") && minus != -1)
      {
        result = String.format(FORM, Double.parseDouble(alteredOp.substring(0, minus)));
      }
      // operand with form x+yi or -x+yi
      else if (alteredOp.contains("+"))
      {
        result = String.format(FORM,
            Double.parseDouble(alteredOp.substring(0, alteredOp.indexOf('+'))));
      }
      // operand with from x-yi
      else
      {
        result = String.format(FORM, Double.parseDouble(alteredOp.substring(0, negativeMinus)));
      }
    }

    if (isImaginary)
    {
      // return 0 since there is no real part to a imaginary num
      result = String.format(FORM, 0.0);
    }

    if (isReal)
    {
      // return the orig operand as decimal
      result = String.format(FORM, Double.parseDouble(alteredOp));
    }
    return result;
  }
}
