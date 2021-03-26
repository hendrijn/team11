package operations;

/**
 * Subtraction Operator Class
 * 
 * @author may4sa
 * @version Sprint 1
 */
public class SubtractionOperator implements Operator
{
  public SubtractionOperator()
  {

  }

  public String evaluate(final String leftOperand, final String rightOperand)
      throws IllegalArgumentException
  {
    boolean real = false;
    boolean complex = false;
    boolean imaginary = false;

    String result = "";
    int resultOfSub = -1;

    if (leftOperand == null || rightOperand == null || leftOperand == "" || rightOperand == "")
    {
      throw new IllegalArgumentException("Please provide two operands");
    }

    String noSpLeft = leftOperand.replaceAll(" ", "");
    String noSpRight = rightOperand.replaceAll(" ", "");

    int iIndexL = noSpLeft.indexOf("i");
    int iIndexR = noSpRight.indexOf("i");

    if (noSpLeft.indexOf("i", iIndexL + 1) != -1)
    {
      throw new IllegalArgumentException("Not a valid operand");
    }
    if (noSpRight.indexOf("i", iIndexR + 1) != -1)
    {
      throw new IllegalArgumentException("Not a valid operand");
    }

    // real num processing
    int realL;
    int realR;
    try
    {
      realL = Integer.parseInt(noSpLeft);
    }
    catch (NumberFormatException nfe)
    {
      realL = -1;
    }

    try
    {
      realR = Integer.parseInt(noSpRight);
    }
    catch (NumberFormatException nfe)
    {
      realR = -1;
    }

    if (realR != -1 && realL != -1)
    {
      real = true;
      resultOfSub = realL - realR;
    }

    if (noSpRight.indexOf("i") != -1 && noSpLeft.indexOf("i") != -1)
    {
      imaginary = true;
      String left = noSpLeft.substring(0, noSpLeft.indexOf("i"));
      String right = noSpRight.substring(0, noSpRight.indexOf("i"));

      int leftInt = Integer.parseInt(left);
      int rightInt = Integer.parseInt(right);

      resultOfSub = leftInt - rightInt;
    }

    // imaginary num processing

    // final conversion toString
    if (real)
    {
      result = ((Integer) resultOfSub).toString() + "+0i";
    }

    if (imaginary)
    {
      if (resultOfSub < 0)
      {
        result = "0" + ((Integer) resultOfSub).toString() + "i";
      }
      else
      {
        result = "0+" + ((Integer) resultOfSub).toString() + "i";
      }
    }
    // System.out.println(result);
    return result;
  }
}
