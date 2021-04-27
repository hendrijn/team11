package operations;

import gui.NewMainInterface;

/**
 * class for changing the sign of an operand from its current sign to the opposite. ex: if currently
 * -7 changes to 7 and vice versa.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
public class SignChangeOperator
{
  private static final String NO_OPERAND = "NO_OPERAND";
  private static final String OPEN_PAREN = "(";
  private static final String CLOSED_PAREN = ")";
  private static final String INVALID = "VALID_OR_SIMPLIFY";
  private static final String MINUS = "-";

  /**
   * changes the sign of an operand.
   * 
   * @param operand
   *          the operand to change.
   * @return the String of the sign changed operand.
   * 
   * @throws IllegalArgumentException
   *           if the operand is empty, null, or invalid .
   */
  public static String changeSign(final String operand) throws IllegalArgumentException
  {
    // error checking null/empty
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(NO_OPERAND));
    }

    String alteredOp = ((operand.replaceAll(" ", "")).replace(OPEN_PAREN, "")).replace(CLOSED_PAREN,
        "");

    // error checking invalid
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(INVALID));
    }

    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(NO_OPERAND));
    }

    boolean complex = TempContext.isComplex(alteredOp);
    String result = "";

    if (alteredOp.length() > 1)
      try
      {
        Double.parseDouble(((alteredOp.replace("i", "")).replace("+", "")).replaceAll(MINUS, ""));
      }
      catch (NumberFormatException nfe)
      {
        throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(INVALID));
      }

    if (complex)
    {
      ConjugateOperator c = new ConjugateOperator();
      String conjugatedOp = c.conjugate(alteredOp);
      if (conjugatedOp.charAt(0) == '-')
      {
        result = OPEN_PAREN + conjugatedOp.substring(1) + CLOSED_PAREN; // put back parens
      }
      else
      {
        result = "(-" + conjugatedOp + CLOSED_PAREN;
      }
    }
    else
    {
      if (alteredOp.charAt(0) == '-')
      {
        result = alteredOp.substring(1);
      }
      else
      {
        result = MINUS + alteredOp;
      }
    }
    return result;
  }
}
