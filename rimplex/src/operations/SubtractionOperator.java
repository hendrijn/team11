package operations;

/**
 * Subtraction Operator Class. 
 * 
 * @author team 11 - may4sa
 * @version Sprint 1
 */
public class SubtractionOperator implements Operator
{

  /**
   * Evaluates a subtraction of two operands.
   * 
   * @param leftOperand
   *          the operand that the rightOperand will be subtracted from.
   * @param rightOperand
   *          the operand that will be subtracted from the leftOperand.
   * @return the result of the subtraction.
   * @throws IllegalArgumentException
   *           thrown if operands are null or empty.
   */
  @Override
  public String evaluate(final String leftOperand, final String rightOperand)
      throws IllegalArgumentException
  {

    // error checking
    if (leftOperand == null || rightOperand == null || leftOperand.equals("") || rightOperand.equals(""))
    {
      throw new IllegalArgumentException("Please provide two operands");
    }

    // remove spaces
    String noSpL = leftOperand.replaceAll(" ", ""); 
    String noSpR = rightOperand.replaceAll(" ", "");

    // put left Operand in +- form if negative
    String distribute = this.distribute(noSpR);

    // distribute and fix +- form to - form
    String result = new AdditionOperator().evaluate(noSpL, distribute);
    
    return result;
  }

  public String distribute(String rightOperand)
  {
    int indexOfNeg = rightOperand.indexOf("-");
    String distribute = "";
    if (rightOperand.indexOf("+") != -1)
    {
      if (rightOperand.charAt(0) == '-')
      {
        distribute = rightOperand.substring(0, rightOperand.indexOf("+")) + "-"
            + rightOperand.substring(rightOperand.indexOf("+") + 1);
      }
      else
      {
        distribute = "-" + rightOperand.substring(0, rightOperand.indexOf("+")) + "+-"
            + rightOperand.substring(rightOperand.indexOf("+") + 1) + "";
      }
    } 
    else {
      if(rightOperand.charAt(0) == '-')
      {
        distribute = rightOperand.substring(1);
      }
      else 
      {
        distribute = "-" + rightOperand;
      }
    }

    if (rightOperand.indexOf("-", indexOfNeg+1) != -1)
    {
      if (rightOperand.charAt(0) == '-')
      {
        distribute = rightOperand.substring(1, rightOperand.indexOf("-", indexOfNeg + 1)) + "+"
            + rightOperand.substring(rightOperand.indexOf("-", indexOfNeg + 1) + 1);
      }
      else
      {
        distribute = "-" + rightOperand.substring(0, rightOperand.indexOf("-", indexOfNeg + 1))
            + "+" + rightOperand.substring(rightOperand.indexOf("-", indexOfNeg + 1) + 1);
      }
    }
    return distribute;
  }

  public String format(String operand)
  {
    boolean complex = false;
    boolean imaginary = false;
    boolean real = false;
    String result = "";

    int negative = operand.indexOf("-");
    int minus = operand.indexOf("-", negative + 1);

    if (operand.contains("+"))
    {
      complex = true;
    }
    else if (operand.charAt(0) == '-' && minus != -1)
    {
      complex = true;
    }
    else if (operand.charAt(0) != '-' && negative != -1)
    {
      complex = true;
    }
    else if (operand.contains("i"))
    {
      imaginary = true;
    }
    else
    {
      real = true;
    }

    if (complex)
    {
      if (operand.contains("-"))
      {
          result = operand.substring(0, operand.indexOf("-", minus)) + "+-"
              + operand.substring(operand.indexOf("-", minus) + 1);
      }
      else
      {
        result = operand;
      }
    }

    if (imaginary)
    {
      result = "0+" + operand;
    }

    if (real)
    {
      result = operand + "+0i";
    }

    return result;
  }
}
