package operations;

import gui.NewMainInterface;

public class SquareRootOperator
{
  
  final private String BLANK_OPERAND = "0";

  public String evaluate(String operand) 
  {
    
    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(operand, BLANK_OPERAND);
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }
    
    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    double dblRegNum = 0.0;
    double dblImagNum = 0.0;
    double finalResult = 0.0;
    String finalString = "";
    
    try
    {
      dblRegNum = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e1)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }
    
    try
    {
      dblImagNum = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e2)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("NOT_VALID_OPERAND"));
    }
    
    if (dblImagNum == 0.00) 
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
      finalString = "0.00i";
    }
    
    return finalString;
    
  }
}
