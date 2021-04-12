package operations;

public class InverseOperator 
{

  
  public InverseOperator() {
    
  }
  
  public String invert(String operand)
  {
   
    
    
    if (operand == null || operand.equals("")) {
      throw new IllegalArgumentException("Please provide two valid operands.");
    }
    
    if (!operand.contains("+") && !operand.contains("-")) {
      double finalOperand = 0;
      try
      {
        finalOperand = Double.parseDouble(operand);
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException("Not a valid operand.");
      }
      double finalReturnOperand = (1 / finalOperand);
      return String.valueOf(finalReturnOperand);
    }
    
    TempContext multiContext = new TempContext(new MultiplicationOperator());
    TempContext divContext = new TempContext(new DivisionOperator());
    ConjugateOperator cjOperator = new ConjugateOperator();
    String conjugate = cjOperator.conjugate(operand);
    String denominator = multiContext.evaluate(operand, conjugate);
    //String finalResult = divContext.evaluate(conjugate, denominator);
    
    return conjugate + " / " + denominator;
  }

}
