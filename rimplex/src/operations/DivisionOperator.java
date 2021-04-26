package operations;

import gui.NewMainInterface;

/**
 * the division operation for real, imaginary, and complex numbers.
 * 
 * @author may4sa - team11
 * @version Sprint 3
 */
public class DivisionOperator implements Operator
{
  private final String FORM = "%.2f";

  /**
   * Divides the given dividend by the given divisor.
   * 
   * @param leftOperand
   *          the dividend of the division operation.
   * @param rightOperand
   *          the divisor of the division operation.
   * @return the quotient of the division.
   */
  @Override
  public String evaluate(final String leftOperand, final String rightOperand)
      throws IllegalArgumentException
  {
    // check for null and empty
    if (leftOperand == null || rightOperand == null || leftOperand.equals("")
        || rightOperand.equals(""))
    {
      throw new IllegalArgumentException("Please enter two operands");
    }

    // removes spaces and parens from l and r operands
    String alteredLOp = ((leftOperand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    String alteredROp = ((rightOperand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    if (alteredLOp.equals("") || alteredROp.equals(""))
    {
      throw new IllegalArgumentException("Please enter two operands");
    }

    // determines type of L operand
    boolean complexL = TempContext.isComplex(alteredLOp);
    boolean imaginaryL = TempContext.isImaginary(alteredLOp);
    boolean realL = TempContext.isReal(alteredLOp);

    // determines type of R operand
    boolean complexR = TempContext.isComplex(alteredROp);
    boolean imaginaryR = TempContext.isImaginary(alteredROp);
    boolean realR = TempContext.isReal(alteredROp);

    String[] parts = new String[4];

    // error checking to see if right operand is 0 (checking for divide by zero)
    String zeroCheckR = (((alteredROp.replaceAll("-", "")).replace("+", "")).replace("i", ""))
        .replaceAll("0", "");

    if (!alteredROp.equals("i") && !alteredROp.equals("-i"))
    {
      if (zeroCheckR.equals("") || zeroCheckR.equals(".") || zeroCheckR.equals(".."))
      {
        throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("RIGHT_OPERAND"));
      }
    }

    // gets the pieces of the operands (see TempContext)
    parts = TempContext.decomposeOperands(alteredLOp, alteredROp);

    double doubleResult = 0.0;
    String result = "0.00+0.00i";

    // complex and imaginary in the R operand division uses the conjugate
    if ((complexL && complexR) || (complexL && imaginaryR) || (imaginaryL && complexR)
        || (realL && complexR) || (realL && imaginaryR))
    {
      ConjugateOperator c = new ConjugateOperator();
      MultiplicationOperator mult = new MultiplicationOperator();
      String conjugate = c.conjugate(alteredROp);
      String top = mult.evaluate(alteredLOp, conjugate);
      String bottom = mult.evaluate(conjugate, alteredROp);
      String[] conjugateParts = TempContext.decomposeOperands(top, bottom);
      double realDiv = Double.parseDouble(conjugateParts[0])
          / Double.parseDouble(conjugateParts[2]);
      double imgDiv = Double.parseDouble(conjugateParts[1]) / Double.parseDouble(conjugateParts[2]);
      result = TempContext
          .format(String.format(FORM, realDiv) + "+" + String.format(FORM, imgDiv) + "i");
    }

    // normal double division
    if (realL && realR)
    {
      double doubleL = Double.parseDouble(alteredLOp);
      double doubleR = Double.parseDouble(alteredROp);
      doubleResult = doubleL / doubleR;
      result = TempContext.format(String.format(FORM, doubleResult));
    }

    // divides the non-i piece of the imaginary by the real then replaces the i at the end of the
    // quotient
    if (imaginaryL && realR)
    {
      double doubleR = Double.parseDouble(alteredROp);
      doubleResult = Double.parseDouble(parts[1]) / doubleR;
      result = TempContext.format(String.format(FORM, doubleResult) + "i");
    }

    // divides each part of the complex by the real
    if (complexL && realR)
    {
      double realNum = Double.parseDouble(parts[0]) / Double.parseDouble(parts[2]);
      double imgNum = Double.parseDouble(parts[1]) / Double.parseDouble(parts[2]);
      result = TempContext
          .format(String.format(FORM, realNum) + "+" + String.format(FORM, imgNum) + "i");
    }

    // both imaginary and real as the right operand do not use the conjugate
    if (imaginaryL && imaginaryR)
    {
      doubleResult = Double.parseDouble(parts[1]) / Double.parseDouble(parts[3]);
      result = TempContext.format(String.format(FORM, doubleResult));
    }

    // edits any +- occurances to -
    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf("+")) + "-"
          + result.substring(result.indexOf("+") + 2);
    }

    // fixes weird case where -0.00 was occurring
    if (result.contains("-0.00"))
    {
      result = result.substring(1);
    }
    return result;
  }
}
