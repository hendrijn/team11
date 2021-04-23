package operations;

import gui.NewMainInterface;

public class ExponentOperator
{
  
  final private String BLANK_OPERAND = "0";

  public String exponentation(String operand, String power) 
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
    
    int powerOf = 0;
    try
    {
      powerOf = Integer.parseInt(power);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException(NewMainInterface.STRINGS.getString("BASE"));
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
      finalResult = Math.pow(dblRegNum, powerOf);
      return String.valueOf(finalResult) + "+00.0i";
    }
    
    String runningOperand = operand;
    String finalOperand = "";
    TempContext multiOp = new TempContext(new MultiplicationOperator());
    
    for (int i = 1; i < powerOf; i++) {
      finalOperand = multiOp.evaluate(operand, runningOperand);
      runningOperand = finalOperand;
    }
    
    if (finalOperand.substring(0, 4).equals("-0.0")) 
    {
      finalOperand = "0.00" + finalOperand.substring(5);
    }
    return finalOperand;
    
    
  }
  
  
  
}
