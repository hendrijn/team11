package operations;

public class ConjugateOperator 
{

  public String conjugate(String operand)
  {
    //TODO: handle illegal args
    
    if(operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException("Please Enter an Operand.");
    }
    
    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    
    if(alteredOp.equals(""))
    {
      throw new IllegalArgumentException("Please Enter an Operand.");
    }
    
    String result = "";
    int negMin = alteredOp.indexOf("-");
    int min = alteredOp.indexOf("-", negMin + 1);
    
    if(alteredOp.contains("+"))
    {
      result = alteredOp.substring(0, alteredOp.indexOf("+")) + "-" + alteredOp.substring(alteredOp.indexOf("+") + 1);
    } 
    else 
    {
      if(min != -1)
      {
        result = alteredOp.substring(0, min) + "+" + alteredOp.substring(min + 1);
      }
      else
      {
        result = alteredOp.substring(0, negMin) + "+" + alteredOp.substring(negMin + 1);
      }
    }
    return result;
  }
}
