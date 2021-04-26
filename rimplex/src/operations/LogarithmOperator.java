package operations;

import gui.NewMainInterface;

/**
 * Class that provides methods for evaluating problems that involve logarithms.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class LogarithmOperator
{
  // attributes
  final private String BLANK_OPERAND = "0";

  /**
   * Computes the natural log of the given operand.
   * 
   * @param operand
   *          a real, imaginary, or complex number.
   * @return the natural log of the operand.
   */
  public String log(String operand)
  {
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("VALID_OR_SIMPLIFY"));
    }

    String[] decomposedOperands = TempContext.decomposeOperands(alteredOp, BLANK_OPERAND);

    String leftRegularNumber   = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    double dblRegNum           = Double.parseDouble(leftRegularNumber);
    double dblImagNum          = 0.00;
    double finalResult         = 0.00;
    double lnComplexReal       = 0.00;
    double lnComplexImag       = 0.00;
    
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
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("LOGARITHM"));
    }

    if (dblImagNum == 0.00)
    {
      finalResult = Math.log(dblRegNum);
      finalString = String.format("%.2f+0.00i", finalResult);
    }
    else
    {
      lnComplexReal = (0.5) * Math.log(Math.pow(dblRegNum, 2) + Math.pow(dblImagNum, 2));
      lnComplexImag = Math.atan(dblImagNum/dblRegNum);
      finalString   =  String.format("%.2f+%.2fi", lnComplexReal, lnComplexImag);
    }
    return finalString;
  }
}
