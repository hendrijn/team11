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
    double dblRegNum = Double.parseDouble(leftRegularNumber);
    double dblImagNum = 0.0;
    double finalResult = 0.0;
    
    try
    {
      dblImagNum = Double.parseDouble(leftImaginaryNumber);
    }
    catch (NumberFormatException e2)
    {
      throw new IllegalArgumentException(e2.getMessage());
    }
    
    String finalString = "";
    
    if (dblImagNum == 0.00 /*|| dblImagNum == -0.00*/) 
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
      finalString = "ln(" + alteredOp + ")";
    }
    
    return finalString;
    
  }
}
