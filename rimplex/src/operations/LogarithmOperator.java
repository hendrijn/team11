package operations;

import gui.NewMainInterface;

public class LogarithmOperator
{
  
  final private String BLANK_OPERAND = "0";
  
  public String log(String operand)
  {
    
    
    String[] decomposedOperands = new String[3];
    try
    {
      decomposedOperands = TempContext.decomposeOperands(operand, BLANK_OPERAND);
    }
    catch (Exception e)
    {
      throw new IllegalArgumentException(e.getMessage());
    }
    
    
    String leftRegularNumber = decomposedOperands[0];
    String leftImaginaryNumber = decomposedOperands[1];
    double dblRegNum = 0.0;
    double dblImagNum = 0.0;
    double finalResult = 0.0;
    
    try
    {
      dblRegNum = Double.parseDouble(leftRegularNumber);
    }
    catch (NumberFormatException e1)
    {
      throw new IllegalArgumentException(e1.getMessage());
    }
    
    try
    {
      dblImagNum = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e2)
    {
      throw new IllegalArgumentException(e2.getMessage());
    }
    
    String finalString = "";
    
    if (dblImagNum == 0.00 || dblImagNum == -0.00) 
    {
      if (dblRegNum > 0) 
      {
        finalResult = Math.log(dblRegNum);
        finalString = String.valueOf(finalResult) + "+00.0i";
      } 
      else 
      {
        throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("LOGARITHM"));
      }
    } 
    else 
    {
      finalString = "ln(" + operand + ")";
    }
    
    return finalString;
    
  }
}
