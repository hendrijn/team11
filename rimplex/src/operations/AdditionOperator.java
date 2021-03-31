package operations;

/**
 * Addition Operator Class.
 * 
 * @author team 11 - pgleb and may4sa
 * @version Sprint 1
 */
public class AdditionOperator implements Operator
{

  /**
   * Evaluates an addition of two operands.
   * 
   * @param leftOperand
   *          the operand that the rightOperand will be added to.
   * @param rightOperand
   *          the operand that will be added to the leftOperand.
   * @return the sum of the two operands.
   * @throws IllegalArgumentException
   *           thrown if operands are null or empty.
   */
  @Override
  public String evaluate(String leftOperand, String rightOperand)
  {

    if (leftOperand == null || rightOperand == null)
    {
      throw new IllegalArgumentException("Please provide two valid operands.");
    }
    
    String simplifedLeft = leftOperand.replaceAll(" ", "");
    String simplifedRight = rightOperand.replaceAll(" ", "");
    
    if (leftOperand.equals("") || rightOperand.equals(""))
    {
      throw new IllegalArgumentException("Please provide two valid operands.");
    }

   
    String alteredROp = TempContext.format(simplifedRight);
    String alteredLOp = TempContext.format(simplifedLeft);

    // Method for counting i's in a string from: https://www.baeldung.com/java-count-chars
    long iCountLeft = alteredLOp.chars().filter(ch -> ch == 'i').count();
    long iCountRight = alteredROp.chars().filter(ch -> ch == 'i').count();

    if (iCountLeft > 1 || iCountRight > 1)
    {
      throw new IllegalArgumentException("Please provide two valid operands, or simplify them.");
    }

    int leftPlusIndex = alteredLOp.indexOf("+");
    int rightPlusIndex = alteredROp.indexOf("+");

    // Getting the two parts of the complex number
    String simplifedLeftAugend = alteredLOp.substring(0, leftPlusIndex);
    String simplifedLeftAddend = alteredLOp.substring(leftPlusIndex + 1);
    String simplifedRightAugend = alteredROp.substring(0, rightPlusIndex);
    String simplifedRightAddend = alteredROp.substring(rightPlusIndex + 1);

    String leftImaginaryNumber = "";
    String rightImaginaryNumber = "";
    String leftRegularNumber = "";
    String rightRegularNumber = "";

    // Figuring out which part is the i units
    if (simplifedLeftAugend.contains("i"))
    {
      leftImaginaryNumber = simplifedLeftAugend.replaceAll("i", "");
      leftRegularNumber = simplifedLeftAddend;
    }
    else
    {
      leftImaginaryNumber = simplifedLeftAddend.replaceAll("i", "");
      leftRegularNumber = simplifedLeftAugend;
    }

    if (simplifedRightAugend.contains("i"))
    {
      rightImaginaryNumber = simplifedRightAugend.replaceAll("i", "");
      rightRegularNumber = simplifedRightAddend;
    }
    else
    {
      rightImaginaryNumber = simplifedRightAddend.replaceAll("i", "");
      rightRegularNumber = simplifedRightAugend;
    }

    if (leftImaginaryNumber.equals(""))
    {
      leftImaginaryNumber = "1";
    }

    if (leftImaginaryNumber.equals("-"))
    {
      leftImaginaryNumber = "-1";
    }

    if (rightImaginaryNumber.equals(""))
    {
      rightImaginaryNumber = "1";
    }

    if (rightImaginaryNumber.equals("-"))
    {
      rightImaginaryNumber = "-1";
    }
    // Integer processing
    long leftImagNumLong = 0;
    try
    {
      leftImagNumLong = Long.parseLong(leftImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException("Not a valid operand.");
    }

    long leftRegNumLong = 0;
    try
    {
      leftRegNumLong = Long.parseLong(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    long rightImagNumLong = 0;
    try
    {
      rightImagNumLong = Long.parseLong(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    long rightRegNumLong = 0;
    try
    {
      rightRegNumLong = Long.parseLong(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    long finalRegTotal = leftRegNumLong + rightRegNumLong;
    long finalImagTotal = leftImagNumLong + rightImagNumLong;

    String result = finalRegTotal + "+" + finalImagTotal + "i";

    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf("+")) + "-"
          + result.substring(result.indexOf("+") + 2);
    }
    return result;
  }
}
