package operations;

import gui.NewMainInterface;

/**
 * Subtraction Operator Class.
 * 
 * @author team 11 - may4sa
 * @version Sprint 2
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
    if (leftOperand == null || rightOperand == null || leftOperand.equals("")
        || rightOperand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("TWO_OPERANDS"));
    }

    // remove spaces
    String noSpL = leftOperand.replaceAll(" ", "");
    String noSpR = rightOperand.replaceAll(" ", "");

    // put left Operand in +- form if negative
    String distribute = SubtractionOperator.distribute(noSpR);

    // distribute and fix +- form to - form
    String result = new AdditionOperator().evaluate(noSpL, distribute);

    return result;
  }

  private static String distribute(String rightOperand)
  {
    int negMinus = rightOperand.indexOf("-");
    int minus = rightOperand.indexOf("-", negMinus + 1);
    String distribute = "";

    boolean complex = TempContext.isComplex(rightOperand);
    boolean imaginary = TempContext.isImaginary(rightOperand);
    boolean real = TempContext.isReal(rightOperand);

    if (complex)
    {
      if (rightOperand.contains("+"))
      {

        distribute = "-" + rightOperand.substring(0, rightOperand.indexOf("+")) + "+-"
            + rightOperand.substring(rightOperand.indexOf("+") + 1);
      }

      else if (minus != -1)
      {
        distribute = rightOperand.substring(1, minus) + "+" + rightOperand.substring(minus + 1);
      }
      else
      {
        distribute = "-" + rightOperand.substring(0, rightOperand.indexOf("-")) + "+"
            + rightOperand.substring(rightOperand.indexOf("-") + 1);
      }

    }
    if (imaginary || real)
    {
      if (rightOperand.contains("-"))
      {
        distribute = rightOperand.substring(1);
      }
      else
      {
        distribute = "-" + rightOperand;
      }
    }

    return distribute;
  }

}
