package operations;

import gui.NewMainInterface;

public class SquareRootOperator
{

  final private String BLANK_OPERAND = "0";

  public String evaluate(String operand)
  {
    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NO_OPERAND"));
    }

    // String with no spaces or parens
    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");

    // more error checking (for i's)
    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }

    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NO_OPERAND"));
    }

    // error checking for illegal strings
    if (alteredOp.length() > 1)
      try
      {
        Double.parseDouble(((alteredOp.replace("i", "")).replace("+", "")).replaceAll("-", ""));
      }
      catch (NumberFormatException nfe)
      {
        throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("VALID_OR_SIMPLIFY"));
      }

    String[] decomposedOperands = new String[3];
    decomposedOperands = TempContext.decomposeOperands(alteredOp, BLANK_OPERAND);

    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    double dblRegNum = Double.parseDouble(leftRegularNumber);
    double dblImagNum = Double.parseDouble(leftImaginaryNumber);
    double finalResult = 0.0;
    String finalString = "";


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


    return finalString;

  }
}
