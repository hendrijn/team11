package operations;

import gui.NewMainInterface;

/**
 * Class that has an operation for computing the square root.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class SquareRootOperator
{

  // atrributes
  private final String blankOperand = "0";
  private final String noOp = "NO_OPERAND";
  private final String invalid = "NOT_VALID_OPERAND";
  private final String plus = "+";
  private final String minusSign = "-";
  private NewMainInterface ui = NewMainInterface.getInstance();

  /**
   * Computes the square root of a complex, real, or imaginary number.
   * 
   * @param operand
   *          a complex, real, or imaginary number.
   * @return the square root of the given operand.
   * @throws IllegalArgumentException
   *           if the given operand is empty, null, or illegal (gibberish string or too many i's,
   *           etc.)
   */
  public String evaluate(final String operand) throws IllegalArgumentException
  {
    // error checking for null/empty operand
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(ui.getStrings().getString(noOp));
    }

    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    // error checking for illegal
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(ui.getStrings().getString(noOp));
    }

    if (alteredOp.length() > 1)
      try
      {
        Double.parseDouble(
            ((alteredOp.replace("i", "")).replace(plus, "")).replaceAll(minusSign, ""));
      }
      catch (NumberFormatException nfe)
      {
        throw new IllegalArgumentException(ui.getStrings().getString(invalid));
      }

    String[] decomposedOperands = new String[3];

    try
    {
      decomposedOperands = TempContext.decomposeOperands(alteredOp, blankOperand);
    }
    catch (IllegalArgumentException e)
    {
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }

    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    double dblRegNum = 0.0;

    // double manipulation/error checking
    try
    {
      dblRegNum = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }
    double dblImagNum = 0.0;
    try
    {
      dblImagNum = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(ui.getStrings().getString(invalid));
    }
    double finalResult = 0.0;
    String finalString = "";

    if (dblImagNum == 0.0)
    {
      if (dblRegNum >= 0)
      {
        finalResult = Math.sqrt(dblRegNum);
        finalString = String.format("%.2f", finalResult) + "+0.00i";
      }
      else
      {
        finalResult = Math.sqrt(Math.abs(dblRegNum));
        finalString = String.format("%.2fi", finalResult);
      }
    }
    else
    {
      // This is intense math best explained here:
      // http://stanleyrabinowitz.com/bibliography/complexSquareRoot.pdf
      double a = dblRegNum;
      double b = dblImagNum;
      double p = 0;
      double q = 0;

      double firstPartOfP = (1.00 / Math.sqrt(2));
      double secondPartOfP = Math.sqrt(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) + a);
      p = firstPartOfP * secondPartOfP;

      double firstPartOfQ = Math.signum(b);
      double secondPartOfQ = (firstPartOfQ / Math.sqrt(2));
      double thirdPartOfQ = Math.sqrt(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) - a);
      q = secondPartOfQ * thirdPartOfQ;

      finalString = String.format("%.2f+%.2fi", p, q);
    }
    if (finalString.contains("+-"))
    {
      finalString = finalString.substring(0, finalString.indexOf(plus)) + minusSign
          + finalString.substring(finalString.indexOf(plus) + 2);
    }
    return finalString;
  }
}
