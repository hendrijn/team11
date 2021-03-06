package operations;

/**
 * This is class that provides context for swapping between Operators, following the Strategy
 * pattern. This class may or may not prove to be redundant and therefore was named tempContext at
 * its inception.
 * 
 * @author pgleb and may4sa - team 11
 * @version Sprint 3
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
  public TempContext(final Operator operator)
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
  public String evaluate(final String leftOperand, final String rightOperand)
  {
    return operator.evaluate(leftOperand, rightOperand);
  }

  /**
   * Formats the string into complex number form so that operations can be performed on it.
   * 
   * @param operand
   *          the operand to be formated.
   * @return a complex number formatted string.
   * @throws IllegalArgumentException
   *           if the operand is empty/null
   */
  public static String format(final String operand) throws IllegalArgumentException
  {
    // error checking for empty/null
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.TWO_OPERANDS));
    }

    boolean complex = isComplex(operand);
    boolean imaginary = isImaginary(operand);
    boolean real = isReal(operand);
    String result = "";
    String alteredOp = operand.replaceAll(" ", "");
    int negative = alteredOp.indexOf(Strings.MINUS);
    int minus = alteredOp.indexOf(Strings.MINUS, negative + 1);

    // changes - -> +- for use in the addition operator
    if (complex)
    {
      String noParenOp = (alteredOp.replace("(", "")).replace(")", "");

      if (noParenOp.charAt(0) == '-' && !noParenOp.contains(Strings.PLUS_MINUS) && minus != -1)
      {
        result = noParenOp.substring(0, noParenOp.indexOf(Strings.MINUS, minus))
            + Strings.PLUS_MINUS + noParenOp.substring(noParenOp.indexOf(Strings.MINUS, minus) + 1);
      }
      else if (negative != -1 && !noParenOp.contains(Strings.PLUS_MINUS)
          && !noParenOp.contains(Strings.PLUS))
      {
        result = noParenOp.substring(0, noParenOp.indexOf(Strings.MINUS, minus))
            + Strings.PLUS_MINUS + noParenOp.substring(noParenOp.indexOf(Strings.MINUS, minus) + 1);
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
   * 
   * @param leftOperand
   *          The leftOperand to get broken down.
   * @param rightOperand
   *          The rightOperand to get broken down.
   * @return A string array of the decomposedOperands. It very specifically is indexed in order:
   *         leftRegularNumber, leftImaginaryNumber, rightRegularNumber, rightImaginaryNumber.
   *         Example: With 5+2i, and 4+3i, [0] = 5, [1] = 2, [2] = 4, [3] = 3.
   * @throws IllegalArgumentException
   *           if there are too many i's in the operand.
   */
  public static String[] decomposeOperands(final String leftOperand, final String rightOperand)
      throws IllegalArgumentException
  {
    String alteredROp = TempContext.format(rightOperand);
    String alteredLOp = TempContext.format(leftOperand);

    // Method for counting i's in a string from: https://www.baeldung.com/java-count-chars
    long iCountLeft = alteredLOp.chars().filter(ch -> ch == 'i').count();
    long iCountRight = alteredROp.chars().filter(ch -> ch == 'i').count();

    if (iCountLeft > 1 || iCountRight > 1)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.SIMPLIFY));
    }

    int leftPlusIndex = alteredLOp.indexOf(Strings.PLUS);
    int rightPlusIndex = alteredROp.indexOf(Strings.PLUS);

    // Getting the two parts of the complex number
    String simplifedLeftOperand1 = alteredLOp.substring(0, leftPlusIndex);
    String simplifedLeftOperand2 = alteredLOp.substring(leftPlusIndex + 1);
    String simplifedRightOperand1 = alteredROp.substring(0, rightPlusIndex);
    String simplifedRightOperand2 = alteredROp.substring(rightPlusIndex + 1);

    String leftImaginaryNumber = "";
    String rightImaginaryNumber = "";
    String leftRegularNumber = "";
    String rightRegularNumber = "";

    // Figuring out which part is the i units
    if (simplifedLeftOperand1.contains(Strings.I))
    {
      leftImaginaryNumber = simplifedLeftOperand1.replaceAll(Strings.I, "");
      leftRegularNumber = simplifedLeftOperand2;
    }
    else
    {
      leftImaginaryNumber = simplifedLeftOperand2.replaceAll(Strings.I, "");
      leftRegularNumber = simplifedLeftOperand1;
    }

    if (simplifedRightOperand1.contains(Strings.I))
    {
      rightImaginaryNumber = simplifedRightOperand1.replaceAll(Strings.I, "");
      rightRegularNumber = simplifedRightOperand2;
    }
    else
    {
      rightImaginaryNumber = simplifedRightOperand2.replaceAll(Strings.I, "");
      rightRegularNumber = simplifedRightOperand1;
    }

    // handling for just i operands
    if (leftImaginaryNumber.equals(""))
    {
      leftImaginaryNumber = Strings.ONE;
    }

    if (leftImaginaryNumber.equals(Strings.MINUS))
    {
      leftImaginaryNumber = Strings.NEG_ONE;
    }

    if (rightImaginaryNumber.equals(""))
    {
      rightImaginaryNumber = Strings.ONE;
    }

    if (rightImaginaryNumber.equals(Strings.MINUS))
    {
      rightImaginaryNumber = Strings.NEG_ONE;
    }

    String[] operandArray = {leftRegularNumber, leftImaginaryNumber, rightRegularNumber,
        rightImaginaryNumber};

    return operandArray;
  }

  /**
   * determines if an operand is complex.
   * 
   * @param operand
   *          the operand to check.
   * @return true if the operand is complex, false otherwise.
   */
  public static boolean isComplex(final String operand)
  {
    boolean complex = false;

    if (operand.contains(Strings.PLUS))
    {
      complex = true;
    }
    else if (operand.charAt(0) == '-' && operand.indexOf((Strings.MINUS), 1) != -1)
    {
      complex = true;
    }
    else if (operand.charAt(0) != '-' && operand.contains(Strings.MINUS))
    {
      complex = true;
    }
    return complex;
  }

  /**
   * determines if an operand is imaginary.
   * 
   * @param operand
   *          the operand to check.
   * @return true if the operand is imaginary, false otherwise.
   */
  public static boolean isImaginary(final String operand)
  {
    boolean imaginary = false;
    boolean complex = isComplex(operand);
    if (!complex && operand.contains(Strings.I))
    {
      imaginary = true;
    }
    return imaginary;
  }

  /**
   * determines if an operand is real.
   * 
   * @param operand
   *          the operand to check.
   * @return true if the operand is real, false otherwise.
   */
  public static boolean isReal(final String operand)
  {
    boolean real = false;
    boolean imaginary = isImaginary(operand);
    boolean complex = isComplex(operand);

    if (!complex && !imaginary)
    {
      real = true;
    }
    return real;
  }
}
