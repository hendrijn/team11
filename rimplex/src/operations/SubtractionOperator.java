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

    // error checking
    if (leftOperand == null || rightOperand == null || leftOperand == "" || rightOperand == "")
    {
      throw new IllegalArgumentException("Please provide two operands");
    }

    // remove spaces
    String noSpL = leftOperand.replaceAll(" ", ""); 
    String noSpR = rightOperand.replaceAll(" ", "");

    // put left Operand in +- form if negative
    String distribute = this.distribute(noSpR);
    String alteredLOp = this.format(noSpL);
    String alteredROp = this.format(distribute);

    // distribute and fix +- form to - form
    
    String result = new AdditionOperator().evaluate(alteredLOp, distribute);
    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf("+")) + "-"
          + result.substring(result.indexOf("+") + 2);
    }

    // return
    return result;
  }

  public String distribute(String rightOperand)
  {
    // add non-complex cases
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
