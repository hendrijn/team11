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
  private final String blankOp = "0";
  private final String invalid = "NOT_VALID_OPERAND";
  private final String closedParen = ")";
  private NewMainInterface ui = NewMainInterface.getInstance();

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
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(closedParen, "");

    // error checking invalid
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(alteredOp, blankOp);
    }
    catch (IllegalArgumentException e)
    {
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
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
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    double dblImagNum = 0.00;
    double finalResult = 0.00;

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
      throw new IllegalArgumentException(ui.getStrings().getString("LOGARITHM"));
    }

    if (dblImagNum == 0.00)
    {
      finalResult = Math.log(dblRegNum);
      finalString = String.format("%.2f+0.00i", finalResult);
    }
    else
    {
      finalString = "ln(" + dblRegNum + "0+" + dblImagNum + "0i" + closedParen;
    }

    return finalString;
  }
}
