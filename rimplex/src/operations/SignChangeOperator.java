package operations;

public class SignChangeOperator
{
  public static String changeSign(String operand) throws IllegalArgumentException
  {
    // TODO: handle random strings
    //error checking 
    if (operand == null)
    {
      throw new IllegalArgumentException("Please provide an operand");
    }
    
    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");;
    
    long iCount  = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1 || alteredOp.isEmpty() || alteredOp.equals("()"))
    {
      throw new IllegalArgumentException("Please provide a valid operand, or simplify it.");
    }

    boolean complex = TempContext.isComplex(alteredOp);
    boolean imaginary = TempContext.isImaginary(alteredOp);
    boolean real = TempContext.isReal(alteredOp);
    String result = "";

    if (complex)
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
    
    else if(imaginary || real)
    {
      if(alteredOp.charAt(0) == '-')
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
