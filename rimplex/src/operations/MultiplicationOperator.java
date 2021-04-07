package operations;

public class MultiplicationOperator implements Operator
{

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
    String simplifedLeftMultiplicand = alteredLOp.substring(0, leftPlusIndex);
    String simplifedLeftMultiplier = alteredLOp.substring(leftPlusIndex + 1);
    String simplifedRightMultiplicand = alteredROp.substring(0, rightPlusIndex);
    String simplifedRightMultiplier= alteredROp.substring(rightPlusIndex + 1);

    String leftImaginaryNumber = "";
    String rightImaginaryNumber = "";
    String leftRegularNumber = "";
    String rightRegularNumber = "";

    // Figuring out which part is the i units
    if (simplifedLeftMultiplicand.contains("i"))
    {
      leftImaginaryNumber = simplifedLeftMultiplicand.replaceAll("i", "");
      leftRegularNumber = simplifedLeftMultiplier;
    }
    else
    {
      leftImaginaryNumber = simplifedLeftMultiplier.replaceAll("i", "");
      leftRegularNumber = simplifedLeftMultiplicand;
    }

    if (simplifedRightMultiplicand.contains("i"))
    {
      rightImaginaryNumber = simplifedRightMultiplicand.replaceAll("i", "");
      rightRegularNumber = simplifedRightMultiplier;
    }
    else
    {
      rightImaginaryNumber = simplifedRightMultiplier.replaceAll("i", "");
      rightRegularNumber = simplifedRightMultiplicand;
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

    double fOILFirst = leftRegNumLong * rightRegNumLong;
    double fOILOuters = leftRegNumLong * rightImagNumLong;
    double fOILInners = leftImagNumLong * rightRegNumLong;
    double fOILLasts = leftImagNumLong * rightImagNumLong * -1;
    
    double finalRegTotal = fOILFirst + fOILLasts;
    double finalImagTotal = fOILOuters + fOILInners;

    String result = finalRegTotal + "+" + finalImagTotal + "i";

    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf("+")) + "-"
          + result.substring(result.indexOf("+") + 2);
    }
    return result;
  }
 }
