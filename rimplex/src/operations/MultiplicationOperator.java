package operations;

public class MultiplicationOperator implements Operator
{
  
  final int I_SQUARED = -1;

  /**
   * This evaluates two operands using multiplication!
   * @param leftOperand The left operand to be evaluated.
   * @param rightOperand The right operand to be evaluated.
   * @return a string of the two operands multiplied together.
   * @throws IllegalArgumentException
   *           thrown if operands are null or empty.
   */
  @Override
  public String evaluate(String leftOperand, String rightOperand)
  {
    
    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(leftOperand, rightOperand);
    }
    catch (Exception e1)
    {
      throw new IllegalArgumentException(e1.getMessage());
    }
    
    String leftRegularNumber     = decomposedOperands[0];
    String leftImaginaryNumber   = decomposedOperands[1];
    String rightRegularNumber    = decomposedOperands[2];
    String rightImaginaryNumber  = decomposedOperands[3];
    
    
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

    double fOILFirst  = leftRegNumLong * rightRegNumLong;
    double fOILOuters = leftRegNumLong * rightImagNumLong;
    double fOILInners = leftImagNumLong * rightRegNumLong;
    double fOILLasts  = leftImagNumLong * rightImagNumLong *  I_SQUARED;
    
    double finalRegTotal  = fOILFirst + fOILLasts;
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
