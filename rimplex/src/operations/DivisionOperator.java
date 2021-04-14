package operations;

/**
 * the division operation for real, imaginary, and complex numbers.
 * 
 * @author may4sa - team11
 * @version Sprint 2
 */
public class DivisionOperator implements Operator
{
  /**
   * 
   */
  @Override
  public String evaluate(String leftOperand, String rightOperand)
  {
    // removes spaces and parens from l and r operands
    String alteredLOp = ((leftOperand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    String alteredROp = ((rightOperand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    // determines type of L operand
    boolean complexL = TempContext.isComplex(alteredLOp);
    boolean imaginaryL = TempContext.isImaginary(alteredLOp);
    boolean realL = TempContext.isReal(alteredLOp);

    // determines type of R operand
    boolean complexR = TempContext.isComplex(alteredROp);
    boolean imaginaryR = TempContext.isImaginary(alteredROp);
    boolean realR = TempContext.isReal(alteredROp);

    String[] parts = new String[4];

    // gets the pieces of the operands (see TempContext)
    parts = TempContext.decomposeOperands(alteredLOp, alteredROp);

    double doubleResult = 0.0;
    String result = "0.00+0.00i";

    // complex and imaginary in the R operand divison uses the conjugate
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
      result = TempContext.format(String.format("%.2f", realDiv) + "+" + String.format("%.2f", imgDiv) + "i");
    }
    // both imaginary and real as the right operand do not use the conjugate
    else if (imaginaryL && imaginaryR)
    {
      doubleResult = Double.parseDouble(parts[1]) / Double.parseDouble(parts[3]);
      result = TempContext.format(String.format("%.2f", doubleResult));
    }
    else if (realL && realR)
    {
      double doubleL = Double.parseDouble(alteredLOp);
      double doubleR = Double.parseDouble(alteredROp);
      doubleResult = doubleL / doubleR;
      result = TempContext.format(String.format("%.2f", doubleResult));
    }
    else if (imaginaryL && realR)
    {
      double doubleR = Double.parseDouble(alteredROp);
      doubleResult = Double.parseDouble(parts[1]) / doubleR;
      result = TempContext.format(String.format("%.2f", doubleResult) + "i");
    }
    else if (complexL && realR)
    {
      double realNum = Double.parseDouble(parts[0]) / Double.parseDouble(parts[2]);
      double imgNum = Double.parseDouble(parts[1]) / Double.parseDouble(parts[2]);
      result = TempContext.format(String.format("%.2f", realNum) + "+" + String.format("%.2f", imgNum) + "i");
    }

    // formats result


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
