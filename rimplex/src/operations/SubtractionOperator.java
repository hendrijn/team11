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
    
    // need to put imaginary into 0+xi form
    // need to put real into x+0i form
    // can;t figure out where to do it
    if (leftOperand == null || rightOperand == null || leftOperand == "" || rightOperand == "")
    {
      throw new IllegalArgumentException("Please provide two operands");
    }
    
    String noSpL = leftOperand.replaceAll(" ", "");
    String noSpR = rightOperand.replaceAll(" ", "");
    
    String alteredLOp = noSpL;
    int indexOfNeg = noSpL.indexOf("-");
    int subSign = noSpL.indexOf("-", indexOfNeg+1);
    if(subSign != -1)
    {
      alteredLOp = noSpL.substring(0, noSpL.indexOf("-", subSign)) + "+-" + noSpL.substring(noSpL.indexOf("-", subSign) + 1);
    }

    String distribute = this.distribute(noSpR);
    String result = new AdditionOperator().evaluate(alteredLOp, distribute);
    if(result.contains("+-"))
    {
      result = result.substring(0, result.indexOf("+")) + "-" + result.substring(result.indexOf("+") + 2);
    }
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

    if (rightOperand.indexOf("-", indexOfNeg++) != -1)
    {
      if (rightOperand.charAt(0) == '-')
      {
        distribute = rightOperand.substring(1, rightOperand.indexOf("-", indexOfNeg++)) + "+"
            + rightOperand.substring(rightOperand.indexOf("-", indexOfNeg++) + 1);
      }
      else
      {
        distribute = "-" + rightOperand.substring(0, rightOperand.indexOf("-", indexOfNeg++)) + "+"
            + rightOperand.substring(rightOperand.indexOf("-", indexOfNeg++) + 1);
      }
    }
    return distribute;
  }
}
