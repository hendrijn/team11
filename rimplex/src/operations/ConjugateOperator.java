package operations;

public class ConjugateOperator
{

  public String conjugate(String operand)
  {
    // error checking
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException("Please Enter an Operand.");
    }

    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException("Please Enter an Operand.");
    }

    if ((alteredOp.indexOf("i", alteredOp.indexOf("i") + 1) != -1))
    {
      throw new IllegalArgumentException("Please Enter a Valid Operand.");
    }
    
    if((alteredOp.replace("i", "")).matches(".*[a-zA-Z]+.*"))
    {
      throw new IllegalArgumentException("Please Enter a Valid Operand.");
    }
    
    String result = "";

    boolean complex = TempContext.isComplex(alteredOp);
    boolean imaginary = TempContext.isImaginary(alteredOp);

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
