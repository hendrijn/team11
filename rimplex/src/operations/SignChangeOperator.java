package operations;

/**
 * class for changing the sign of an operand from its current sign to the opposite. ex: if currently
 * -7 changes to 7 and vice versa.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
public class SignChangeOperator
{
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
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.NO_OPERAND));
    }

    String alteredOp = ((operand.replaceAll(Strings.SPACE, "")).replace(Strings.OPEN_PAREN, ""))
        .replace(Strings.CLOSED_PAREN, "");

    // error checking invalid
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.NO_OPERAND));
    }

    boolean complex = TempContext.isComplex(alteredOp);
    String result = "";

    if (alteredOp.length() > 1)
      try
      {
        Double.parseDouble(((alteredOp.replace(Strings.I, "")).replace(Strings.PLUS, ""))
            .replaceAll(Strings.MINUS, ""));
      }
      catch (NumberFormatException nfe)
      {
        throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
      }

    if (complex)
    {
      ConjugateOperator c = new ConjugateOperator();
      String conjugatedOp = c.conjugate(alteredOp);
      if (conjugatedOp.charAt(0) == '-')
      {
        result = Strings.OPEN_PAREN + conjugatedOp.substring(1) + Strings.CLOSED_PAREN; // put back
                                                                                        // parens
      }
      else
      {
        result = "(-" + conjugatedOp + Strings.CLOSED_PAREN;
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
        result = Strings.MINUS + alteredOp;
      }
    }
    return result;
  }
}
