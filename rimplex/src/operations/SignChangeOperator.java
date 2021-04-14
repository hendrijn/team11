package operations;

/**
 * changes the sign of an operand from its current sign to the opposite. ex: if currently -7 changes
 * to 7 and vice versa.
 * 
 * @author may4sa - team 11
 * @version Sprint 2
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
   *           if the operand is empty, null, or has too many i's.
   */
  public static String changeSign(String operand) throws IllegalArgumentException
  {
    // error checking
    if (operand == null)
    {
      throw new IllegalArgumentException("Please provide an operand");
    }

    // String with no spaces or parens
    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    ;

    // more error checking (for i's)
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1 || alteredOp.isEmpty() || alteredOp.equals("()"))
    {
      throw new IllegalArgumentException("Please provide a valid operand, or simplify it.");
    }

    boolean complex = TempContext.isComplex(alteredOp);
    boolean imaginary = TempContext.isImaginary(alteredOp);
    boolean real = TempContext.isReal(alteredOp);
    String result = "";

    // error checking for illegal strings
    try
    {
      Double.parseDouble(((alteredOp.replace("i", "")).replace("+", "")).replaceAll("-", ""));
    }
    catch (NumberFormatException nfe)
    {
      throw new IllegalArgumentException("Please provide a valid operand, or simplify it.");
    }

    if(alteredOp.equals("0"))
    {
      result = operand;
    }
    // complex manipulation
    else if (complex)
    {
      ConjugateOperator c = new ConjugateOperator();
      String conjugatedOp = c.conjugate(alteredOp);
      if (conjugatedOp.charAt(0) == '-')
      {
        result = "(" + conjugatedOp.substring(1) + ")";
      }
      else
      {
        result = "(-" + conjugatedOp + ")";
      }
    }

    // imaginary/real manipulation
    else if (imaginary || real)
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
