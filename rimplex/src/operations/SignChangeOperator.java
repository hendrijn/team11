package operations;

public class SignChangeOperator
{
  public String changeSign(String operand) throws IllegalArgumentException
  {
    //TODO: handle illegal args
    ConjugateOperator c = new ConjugateOperator();
    String conjugatedOp = c.conjugate(operand);
    String result = "";
    
    if(conjugatedOp.charAt(0) == '-')
    {
      result = conjugatedOp.substring(1);
    }
    else
    {
      result = "-" + conjugatedOp;
    }
    return result;
  }
}
