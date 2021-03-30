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
    if (leftOperand == null || rightOperand == null || leftOperand == "" || rightOperand == "")
    {
      throw new IllegalArgumentException("Please provide two operands");
    }

    // remove spaces
    String noSpL = leftOperand.replaceAll(" ", ""); 
    String noSpR = rightOperand.replaceAll(" ", "");
    
    String distribute = this.distribute(noSpR);
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
    System.out.println(distribute);
    return distribute;
  }
}
