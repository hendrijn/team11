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
    
    boolean complex = false;
    boolean imaginary = false;
    boolean real = false;
    String result = "";
    
    String alteredOp = operand.replaceAll(" ", "");
    int negative = alteredOp.indexOf("-");
    int minus = alteredOp.indexOf("-", negative + 1);

    if (alteredOp.contains("+"))
    {
      complex = true;
    }
    else if (alteredOp.charAt(0) == '-' && minus != -1)
    {
      complex = true;
    }
    else if (alteredOp.charAt(0) != '-' && negative != -1)
    {
      complex = true;
    }
    else if (alteredOp.contains("i"))
    {
      imaginary = true;
    }
    else
    {
      real = true;
    }

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
      result = "0+" + alteredOp;
    }

    if (real)
    {
      result = alteredOp + "+0i";
    }
    return result;
  }
}
