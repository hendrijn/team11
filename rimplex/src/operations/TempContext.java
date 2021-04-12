package operations;

/**
 * This is class that provides context for swapping between Operators, following the Strategy
 * pattern. This class may or may not prove to be redundant and therefore was named tempContext at
 * its inception.
 * 
 * @author pgleb
 * @version 1.0.
 *
 */
public class TempContext
{

  private Operator operator;

  /**
   * Constructs a context with a certain operator (addition or subtraction).
   * 
   * @param operator
   *          Addition or subtraction operator.
   */
  public TempContext(Operator operator)
  {
    this.operator = operator;
  }

  /**
   * Performs the necessary operator evaluation.
   * 
   * @param leftOperand
   *          The left operand the operation is to be performed on.
   * @param rightOperand
   *          The right operand the operation is to be performed on.
   * @return The result of the performing the evaluation on the two operands as a String.
   */
  public String evaluate(String leftOperand, String rightOperand)
  {
    return operator.evaluate(leftOperand, rightOperand);
  }

  /**
   * Formats the string into complex number form so that operations can be performed on it.
   * 
   * @param operand
   *          the operand to be formated.
   * @return a complex number formatted string.
   */
  public static String format(String operand) throws IllegalArgumentException
  {
    if(operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException("Please provide two valid operands.");
    }
    
    boolean complex = isComplex(operand);
    boolean imaginary = isImaginary(operand);
    boolean real = isReal(operand);
    String result = "";
    
    String alteredOp = operand.replaceAll(" ", "");
    int negative = alteredOp.indexOf("-");
    int minus = alteredOp.indexOf("-", negative + 1);

    if (complex)
    {
      String noParenOp = (alteredOp.replace("(", "")).replace(")", "");
      if (noParenOp.charAt(0) == '-' && !noParenOp.contains("+-") && minus != -1)
      {
        result = noParenOp.substring(0, noParenOp.indexOf("-", minus)) + "+-"
            + noParenOp.substring(noParenOp.indexOf("-", minus) + 1);
      }
      else if (negative != -1 && !noParenOp.contains("+-") && !noParenOp.contains("+"))
      {
        result = noParenOp.substring(0, noParenOp.indexOf("-", minus)) + "+-"
            + noParenOp.substring(noParenOp.indexOf("-", minus) + 1);
      }
      else
      {
        result = noParenOp;
      }
    }

    if (imaginary)
    {
      result = "0.00+" + alteredOp;
    }

    if (real)
    {
      result = alteredOp + "+0.00i";
    }
    return result;
  }
  
  /**
   * This function takes two string operands for complex numbers and decomposes them into parts.
   * Example: 5+2i, and 4+3i, will be returned as 3 2 4 3.
   * @param leftOperand The leftOperand to get broken down.
   * @param rightOperand The rightOperand to get broken down.
   * @return A string array of the decomposedOperands. It very specifically is indexed in order:
   *    leftRegularNumber, leftImaginaryNumber, rightRegularNumber, rightImaginaryNumber.
   *    Example: With 5+2i, and 4+3i, [0] = 5, [1] = 2, [2] = 4, [3] = 3;
   */
  public static String[] decomposeOperands(String leftOperand, String rightOperand) 
  {

    String alteredROp = TempContext.format(rightOperand);
    String alteredLOp = TempContext.format(leftOperand);

    // Method for counting i's in a string from: https://www.baeldung.com/java-count-chars
    long iCountLeft  = alteredLOp.chars().filter(ch -> ch == 'i').count();
    long iCountRight = alteredROp.chars().filter(ch -> ch == 'i').count();

    if (iCountLeft > 1 || iCountRight > 1)
    {
      throw new IllegalArgumentException("Please provide two valid operands, or simplify them.");
    }

    int leftPlusIndex  = alteredLOp.indexOf("+");
    int rightPlusIndex = alteredROp.indexOf("+");

    // Getting the two parts of the complex number
    String simplifedLeftOperand1  = alteredLOp.substring(0, leftPlusIndex);
    String simplifedLeftOperand2  = alteredLOp.substring(leftPlusIndex + 1);
    String simplifedRightOperand1 = alteredROp.substring(0, rightPlusIndex);
    String simplifedRightOperand2 = alteredROp.substring(rightPlusIndex + 1);

    String leftImaginaryNumber  = "";
    String rightImaginaryNumber = "";
    String leftRegularNumber    = "";
    String rightRegularNumber   = "";

    // Figuring out which part is the i units
    if (simplifedLeftOperand1.contains("i"))
    {
      leftImaginaryNumber = simplifedLeftOperand1.replaceAll("i", "");
      leftRegularNumber   = simplifedLeftOperand2;
    }
    else
    {
      leftImaginaryNumber = simplifedLeftOperand2.replaceAll("i", "");
      leftRegularNumber   = simplifedLeftOperand1;
    }

    if (simplifedRightOperand1.contains("i"))
    {
      rightImaginaryNumber = simplifedRightOperand1.replaceAll("i", "");
      rightRegularNumber   = simplifedRightOperand2;
    }
    else
    {
      rightImaginaryNumber = simplifedRightOperand2.replaceAll("i", "");
      rightRegularNumber   = simplifedRightOperand1;
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
    
    
    String[] operandArray = {leftRegularNumber, leftImaginaryNumber, 
        rightRegularNumber, rightImaginaryNumber};
    
    return operandArray;
  }
  
  public static boolean isComplex(String operand)
  {
    boolean complex = false;
    if (operand.contains("+"))
    {
      complex = true;
    }
    else if (operand.charAt(0) == '-' && operand.indexOf("-", 1) != -1)
    {
      complex = true;
    }
    else if (operand.charAt(0) != '-' && operand.contains("-"))
    {
      complex = true;
    }
    return complex;
  }
  
  public static boolean isImaginary(String operand)
  {
    boolean imaginary = false;
    boolean complex = isComplex(operand);
    if (!complex && operand.contains("i"))
    {
      imaginary = true;
    }
    return imaginary;
  }
  
  public static boolean isReal(String operand)
  {
    boolean real = false;
    boolean imaginary = isImaginary(operand);
    boolean complex = isComplex(operand);
    
    if(!complex && ! imaginary)
    {
      real = true;
    }
    return real;
  }
}
