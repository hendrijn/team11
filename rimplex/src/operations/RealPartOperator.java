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
  private final String form = "%.2f";
  private final String invalid = "VALID_OR_SIMPLIFY";
  private final String plus = "+";
  private final String minusSign = "-";

  /**
   * Isolates the real part of the given operand.
   * 
   * @param operand
   *          a real, imaginary, or complex number.
   * @return the real part of the operand.
   * @throws IllegalArgumentException
   *           if the operand is null, empty, or invalid.
   */
  public String evaluate(final String operand) throws IllegalArgumentException
  {
    // error checking for null/empty operand
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException("Please enter an operand");
    }

    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    String result = "";

    // error checking invalid
    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NO_OPERAND"));
    }

    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(invalid));
    }

    try
    {
      Double
          .parseDouble(((alteredOp.replace("i", "")).replace(plus, "")).replaceAll(minusSign, ""));
    }
    catch (NumberFormatException nfe)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(invalid));
    }

    boolean isComplex = TempContext.isComplex(alteredOp);
    boolean isImaginary = TempContext.isImaginary(alteredOp);
    boolean isReal = TempContext.isReal(alteredOp);
    int negativeMinus = alteredOp.indexOf('-');
    int minus = alteredOp.indexOf('-', negativeMinus + 1);

    if (isComplex)
    {
      // operand with form -x-yi
      if (alteredOp.contains(minusSign) && minus != -1)
      {
        result = String.format(form, Double.parseDouble(alteredOp.substring(0, minus)));
      }
      // operand with form x+yi or -x+yi
      else if (alteredOp.contains(plus))
      {
        result = String.format(form,
            Double.parseDouble(alteredOp.substring(0, alteredOp.indexOf('+'))));
      }
      // operand with from x-yi
      else
      {
        result = String.format(form, Double.parseDouble(alteredOp.substring(0, negativeMinus)));
      }
    }

    if (isImaginary)
    {
      result = String.format(form, 0.0);
    }

    if (isReal)
    {
      result = String.format(form, Double.parseDouble(alteredOp));
    }
    return result;
  }
}
