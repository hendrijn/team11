package operations;

import gui.NewMainInterface;

public class LogarithmOperator
{
  
  final private String BLANK_OPERAND = "0";
  
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
    
    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    double dblRegNum = 0;
    try
    {
      dblRegNum = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
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
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("LOGARITHM"));
    }
    
    if (dblImagNum == 0.00) 
    {
      finalResult = Math.log(dblRegNum);
      finalString = String.format("%.2f", finalResult) + "+0.00i";
    } 
    else 
    {
      finalString = "ln(" + dblRegNum + "0+" + dblImagNum + "0i" + ")";
    }
    
    return finalString;
    
  }
}
