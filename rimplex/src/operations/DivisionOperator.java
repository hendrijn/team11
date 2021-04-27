package operations;

import gui.NewMainInterface;

/**
 * class that includes operations for computing the quotient of two real, imaginary, and complex
 * numbers.
 * 
 * @author may4sa - team11
 * @version Sprint 3
 */
public class DivisionOperator implements Operator
{
  private final String form = "%.2f";
  private final String noOp = "NO_OPERAND";
  private final String space = " ";
  private final String openParen = "(";
  private final String closedParen = ")";
  private final String plus = "+";
  private final String minus = "-";
  private final String i = "i";

  /**
   * Divides the given dividend by the given divisor.
   * 
   * @param leftOperand
   *          the dividend of the division operation.
   * @param rightOperand
   *          the divisor of the division operation.
   * @return the quotient of the division.
   * @throws IllegalArguemntException
   *           if the operands are empty, null, or invalid.
   */
  @Override
  public String evaluate(final String leftOperand, final String rightOperand)
      throws IllegalArgumentException
  {
    // check for null and empty
    if (leftOperand == null || rightOperand == null || leftOperand.equals("")
        || rightOperand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString(noOp));
    }

    // removes spaces and parens from l and r operands
    String alteredLOp = ((leftOperand.replaceAll(space, "")).replace(openParen, ""))
        .replace(closedParen, "");
    String alteredROp = ((rightOperand.replaceAll(space, "")).replace(openParen, ""))
        .replace(closedParen, "");

    if (alteredLOp.equals("") || alteredROp.equals(""))
    {
      throw new IllegalArgumentException("Please enter two operands");
    }

    boolean complexL = TempContext.isComplex(alteredLOp);
    boolean imaginaryL = TempContext.isImaginary(alteredLOp);
    boolean realL = TempContext.isReal(alteredLOp);

    boolean complexR = TempContext.isComplex(alteredROp);
    boolean imaginaryR = TempContext.isImaginary(alteredROp);
    boolean realR = TempContext.isReal(alteredROp);

    String[] parts = new String[4];

    // error checking to see if right operand is 0 (checking for divide by zero)
    String zeroCheckR = (((alteredROp.replaceAll(minus, "")).replace(plus, "")).replace(i, ""))
        .replaceAll("0", "");

    if (!alteredROp.equals(i) && !alteredROp.equals("-i"))
    {
      if (zeroCheckR.equals("") || zeroCheckR.equals(".") || zeroCheckR.equals(".."))
      {
        throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("RIGHT_OPERAND"));
      }
    }

    parts = TempContext.decomposeOperands(alteredLOp, alteredROp);

    double doubleResult = 0.0;
    String result = "0.00+0.00i";

    if ((complexL && complexR) || (complexL && imaginaryR) || (imaginaryL && complexR)
        || (realL && complexR) || (realL && imaginaryR))
    {
      ConjugateOperator c = new ConjugateOperator();
      MultiplicationOperator mult = new MultiplicationOperator();

      String conjugate = c.conjugate(alteredROp);
      String top = mult.evaluate(alteredLOp, conjugate); // numerator of frac
      String bottom = mult.evaluate(conjugate, alteredROp); // denominator of frac
      String[] conjugateParts = TempContext.decomposeOperands(top, bottom);
      double realDiv = Double.parseDouble(conjugateParts[0])
          / Double.parseDouble(conjugateParts[2]);
      double imgDiv = Double.parseDouble(conjugateParts[1]) / Double.parseDouble(conjugateParts[2]);
      result = TempContext
          .format(String.format(form, realDiv) + plus + String.format(form, imgDiv) + i);
    }

    if (realL && realR)
    {
      double doubleL = Double.parseDouble(alteredLOp);
      double doubleR = Double.parseDouble(alteredROp);
      doubleResult = doubleL / doubleR;
      result = TempContext.format(String.format(form, doubleResult));
    }

    if (imaginaryL && realR)
    {
      double doubleR = Double.parseDouble(alteredROp);
      doubleResult = Double.parseDouble(parts[1]) / doubleR;
      result = TempContext.format(String.format(form, doubleResult) + i);
    }

    if (complexL && realR)
    {
      double realNum = Double.parseDouble(parts[0]) / Double.parseDouble(parts[2]);
      double imgNum = Double.parseDouble(parts[1]) / Double.parseDouble(parts[2]);
      result = TempContext
          .format(String.format(form, realNum) + plus + String.format(form, imgNum) + i);
    }

    if (imaginaryL && imaginaryR)
    {
      doubleResult = Double.parseDouble(parts[1]) / Double.parseDouble(parts[3]);
      result = TempContext.format(String.format(form, doubleResult));
    }

    // edits any +- occurances to -
    if (result.contains("+-"))
    {
      result = result.substring(0, result.indexOf(plus)) + minus
          + result.substring(result.indexOf(plus) + 2);
    }

    // fixes weird case where -0.00 was occurring
    if (result.contains("-0.00"))
    {
      result = result.substring(1);
    }
    return result;
  }
}
