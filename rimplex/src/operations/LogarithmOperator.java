package operations;

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
   
    if (dblImagNum == 0.00 || dblImagNum == -0.00) 
    {
      finalResult = Math.log10(dblRegNum);
      return String.valueOf(finalResult) + "+00.0i";
    }
    
    return "log(" + operand + ")";
    
  }
}
