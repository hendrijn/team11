package operations;

/**
 * Class that provides methods for evaluating problems that involve logarithms.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class LogarithmOperator
{
  /**
   * Computes the natural log of the given operand.
   * 
   * @param operand
   *          a real, imaginary, or complex number.
   * @return the natural log of the operand.
   * @throws IllegalArgumentException
   *           if the operand is empty, null or invalid.
   */
  public String log(final String operand) throws IllegalArgumentException
  {
    // error checking empty/null
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    String alteredOp = ((operand.replaceAll(Strings.SPACE, "")).replace(Strings.OPEN_PAREN, ""))
        .replace(Strings.CLOSED_PAREN, "");

    // error checking invalid
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(alteredOp, Strings.NO_OPERAND);
    }
    catch (IllegalArgumentException e)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];

    double dblRegNum = 0.0;
    try
    {
      dblRegNum = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString(Strings.INVALID));
    }

    double dblImagNum = 0.00;
    double finalResult = 0.00;
    double lnComplexReal = 0.00;
    double lnComplexImag = 0.00;

    try
    {
      dblImagNum = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e2)
    {
      throw new IllegalArgumentException(e2.getMessage());
    }

    String finalString = "";

    if (dblRegNum <= 0 && dblImagNum <= 0)
    {
      throw new IllegalArgumentException(Strings.UI.getStrings().getString("LOGARITHM"));
    }

    if (dblImagNum == 0.00)
    {
      finalResult = Math.log(dblRegNum);
      finalString = String.format("%.2f+0.00i", finalResult);
    }
    else
    {
      // Math formula used found here:
      // https://www.redcrab-software.com/en/Calculator/Algebra/Complex/Log
      lnComplexReal = (0.5) * Math.log(Math.pow(dblRegNum, 2) + Math.pow(dblImagNum, 2));
      lnComplexImag = Math.atan(dblImagNum / dblRegNum);
      finalString = String.format("%.2f+%.2fi", lnComplexReal, lnComplexImag);
    }

    return finalString;
  }
}
