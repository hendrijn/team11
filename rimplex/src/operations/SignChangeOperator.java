package operations;

public class SignChangeOperator
{
  public String changeSign(String operand) throws IllegalArgumentException
  {
    if(operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException("Please Enter an Operand.");
    }
    
    
    
    return "0+0i";
  }
}
