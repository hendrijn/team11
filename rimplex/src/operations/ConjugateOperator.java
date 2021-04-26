package operations;

import gui.NewMainInterface;

/**
 * class for computing the conjugate of a complex/imaginary number. Used for the inverse and
 * division.
 * 
 * @author may4sa - team 11
 * @version Sprint 2
 */
public class ConjugateOperator
{
  /**
   * computes the conjugate of a complex/imaginary operand.
   * 
   * @param operand
   *          the operand to compute the conjugate of.
   * @return the conjugate.
   */
  public String conjugate(String operand)
  {
    // error checking
    // no error checking needs to be done for whether the
    // operand is complex/imaginary or not because this is used internally
    // for division and the inverse
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NO_OPERAND"));
    }

    // operand w/o spaces and parens
    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    // error checking for empty and bad operands
    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NO_OPERAND"));
    }

    if ((alteredOp.indexOf("i", alteredOp.indexOf("i") + 1) != -1))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    if ((alteredOp.replace("i", "")).matches(".*[a-zA-Z]+.*"))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    String result = "";

    // type checking
    boolean complex = TempContext.isComplex(alteredOp);
    boolean imaginary = TempContext.isImaginary(alteredOp);

    // conjugate for complex
    if (complex)
    {
      int negMin = alteredOp.indexOf("-");
      int min = alteredOp.indexOf("-", negMin + 1);

      if (alteredOp.contains("+"))
      {
        result = alteredOp.substring(0, alteredOp.indexOf("+")) + "-"
            + alteredOp.substring(alteredOp.indexOf("+") + 1);
      }
      else
      {
        if (min != -1)
        {
          result = alteredOp.substring(0, min) + "+" + alteredOp.substring(min + 1);
        }
        else
        {
          result = alteredOp.substring(0, negMin) + "+" + alteredOp.substring(negMin + 1);
        }
      }
    }

    // conjugate for imginary
    if (imaginary)
    {
      if (alteredOp.charAt(0) == '-')
      {
        result = alteredOp.substring(1);
      }
      else
      {
        result = "-" + alteredOp;
      }
    }
    return result;
  }
}
