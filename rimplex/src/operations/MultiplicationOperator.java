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
    Double leftImagNumDouble = 0.0;
    try
    {
      leftImagNumDouble    = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException("Not a valid operand.");
    }

    Double leftRegNumDouble = 0.0;
    try
    {
      leftRegNumDouble    = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    Double rightImagNumDouble = 0.0;
    try
    {
      rightImagNumDouble    = Double.parseDouble(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    Double rightRegNumDouble = 0.0;
    try
    {
      rightRegNumDouble    = Double.parseDouble(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {

      throw new IllegalArgumentException("Not a valid operand.");
    }

    double fOILFirst  = leftRegNumDouble  * rightRegNumDouble;
    double fOILOuters = leftRegNumDouble  * rightImagNumDouble;
    double fOILInners = leftImagNumDouble * rightRegNumDouble;
    double fOILLasts  = leftImagNumDouble * rightImagNumDouble *  I_SQUARED;
    
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
