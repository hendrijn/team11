package operations;

public class SignChangeOperator
{
  public String changeSign(String operand) throws IllegalArgumentException
  {
    // TODO: handle random strings
    //error checking 
    if (operand == null)
    {
      throw new IllegalArgumentException("Please provide an operand");
    }
    
    String alteredOp = operand.replaceAll(" ", "");
    
    long iCount  = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1 || alteredOp.isEmpty() || alteredOp.equals("()"))
    {
      throw new IllegalArgumentException("Please provide a valid operand, or simplify it.");
    }

    
    boolean complex = false;
    boolean imaginary = false;
    boolean real = false;
    String result = "";

    if (alteredOp.contains("+"))
    {
      complex = true;
    }
    else if (alteredOp.charAt(0) == '-' && alteredOp.indexOf("-", 1) != -1)
    {
      complex = true;
    }
    else if (alteredOp.charAt(0) != '-' && alteredOp.contains("-"))
    {
      complex = true;
    }
    else if (alteredOp.contains("i"))
    {
      imaginary = true;
    }
    else
    {
      real = true;
    }

    if (complex)
    {
      ConjugateOperator c = new ConjugateOperator();
      String conjugatedOp = c.conjugate(operand);
      if (conjugatedOp.charAt(0) == '-')
      {
        result = conjugatedOp.substring(1);
      }
      else
      {
        result = "-" + conjugatedOp;
      }
    } 
    
    if(imaginary || real)
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
