package operations;

import gui.NewMainInterface;

/**
 * class that has an operation for performing a subtraction on two complex, real, or imaginary
 * numbers.
 * 
 * @author team 11 - may4sa
 * @version Sprint 3
 */
public class SubtractionOperator implements Operator
{

  private final String space = " ";

  /**
   * Evaluates a subtraction of two operands.
   * 
   * @param leftOperand
   *          the operand that the rightOperand will be subtracted from.
   * @param rightOperand
   *          the operand that will be subtracted from the leftOperand.
   * @return the result of the subtraction.
   * @throws IllegalArgumentException
   *           thrown if operands are null, empty, or invalid.
   */
  @Override
  public String evaluate(final String leftOperand, final String rightOperand)
      throws IllegalArgumentException
  {
    // error checking for null/empty
    if (leftOperand == null || rightOperand == null || leftOperand.equals("")
        || rightOperand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("TWO_OPERANDS"));
    }

    String noSpL = leftOperand.replaceAll(space, "");
    String noSpR = rightOperand.replaceAll(space, "");
    String distribute = SubtractionOperator.distribute(noSpR);
    String result = new AdditionOperator().evaluate(noSpL, distribute);

    return result;
  }

  /**
   * Distributes a negative to the given operand.
   * 
   * @param rightOperand
   *          a complex, real, or imaginary number.
   * @return the operand with a negative distributed to it.
   */
  private static String distribute(final String rightOperand)
  {
    final String minusSign = "-";
    final String plus = "+";
    int negMinus = rightOperand.indexOf(minusSign);
    int minus = rightOperand.indexOf(minusSign, negMinus + 1);
    String distribute = "";

    boolean complex = TempContext.isComplex(rightOperand);
    boolean imaginary = TempContext.isImaginary(rightOperand);
    boolean real = TempContext.isReal(rightOperand);

    if (complex)
    {
      // form x+yi -> -x-yi
      if (rightOperand.contains(plus))
      {
        distribute = minusSign + rightOperand.substring(0, rightOperand.indexOf(plus)) + "+-"
            + rightOperand.substring(rightOperand.indexOf(plus) + 1);
      }
      // form -x-yi -> x+yi
      else if (minus != -1)
      {
        distribute = rightOperand.substring(1, minus) + plus + rightOperand.substring(minus + 1);
      }
      // form x-yi -> -x+yi
      else
      {
        distribute = minusSign + rightOperand.substring(0, rightOperand.indexOf(minusSign)) + plus
            + rightOperand.substring(rightOperand.indexOf(minusSign) + 1);
      }
    }
    if (imaginary || real)
    {
      if (rightOperand.contains(minusSign))
      {
        distribute = rightOperand.substring(1);
      }
      else
      {
        distribute = minusSign + rightOperand;
      }
    }
    return distribute;
  }
}
