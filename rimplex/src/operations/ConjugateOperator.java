package operations;

import gui.NewMainInterface;

/**
 * class for computing the conjugate of a complex/imaginary number. Used for the inverse and
 * division.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
public class ConjugateOperator
{
  private final String noOp = "NO_OPERAND";
  private final String invalid = "NOT_VALID_OPERAND";
  private final String i = "i";
  private final String minus = "-";
  private final String plus = "+";
  private NewMainInterface ui = NewMainInterface.getInstance();
      
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
      throw new IllegalArgumentException(ui.getStrings().getString(noOp));
    }

    // operand w/o spaces and parens
    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    // error checking for empty and bad operands
    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(ui.getStrings().getString(noOp));
    }

    if ((alteredOp.indexOf(i, alteredOp.indexOf(i) + 1) != -1))
    {
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    if ((alteredOp.replace(i, "")).matches(".*[a-zA-Z]+.*"))
    {
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    String result = "";

    // type checking
    boolean complex = TempContext.isComplex(alteredOp);
    boolean imaginary = TempContext.isImaginary(alteredOp);

    if (complex)
    {
      int negMin = alteredOp.indexOf(minus);
      int min = alteredOp.indexOf(minus, negMin + 1);

      if (alteredOp.contains(plus))
      {
        result = alteredOp.substring(0, alteredOp.indexOf(plus)) + minus
            + alteredOp.substring(alteredOp.indexOf(plus) + 1);
      }
      else
      {
        if (min != -1)
        {
          result = alteredOp.substring(0, min) + plus + alteredOp.substring(min + 1);
        }
        else
        {
          result = alteredOp.substring(0, negMin) + plus + alteredOp.substring(negMin + 1);
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
        result = minus + alteredOp;
      }
    }
    return result;
  }
}
