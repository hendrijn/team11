package operations;

public class DivisionOperator implements Operator
{
  @Override
  public String evaluate(String leftOperand, String rightOperand)
  {
    String alteredLOp = ((leftOperand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    String alteredROp = ((rightOperand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    
    boolean complexL = TempContext.isComplex(alteredLOp);
    boolean imaginaryL = TempContext.isImaginary(alteredLOp);
    boolean realL = TempContext.isReal(alteredLOp);
    
    boolean complexR = TempContext.isComplex(alteredROp);
    boolean imaginaryR = TempContext.isImaginary(alteredROp);
    boolean realR = TempContext.isReal(alteredROp);
    
    String[] parts = new String[4];
    
    parts = TempContext.decomposeOperands(alteredLOp, alteredROp);
    double doubleResult = 0.0;
    String result = "";

    if(complexL && complexR)
    {
      
    }
    else if(imaginaryL && imaginaryR)
    {
      doubleResult = Double.parseDouble(parts[1]) / Double.parseDouble(parts[3]);
      result = TempContext.format(String.format("%.2f", doubleResult));
    }
    else if (realL && realR)
    {
      double doubleL = Double.parseDouble(alteredLOp);
      double doubleR = Double.parseDouble(alteredROp);
      doubleResult = doubleL / doubleR;
      result = TempContext.format(String.format("%.2f", doubleResult));
    }
    else if (realL && imaginaryR)
    {
      double doubleL = Double.parseDouble(alteredLOp);
      doubleResult = doubleL / Double.parseDouble(parts[3]);
      result = TempContext.format(String.format("%.2f", doubleResult) + "i");
    }
    else if(imaginaryL && realR)
    {
      double doubleR = Double.parseDouble(alteredROp);
      doubleResult = Double.parseDouble(parts[1]) / doubleR;
      result = TempContext.format(String.format("%.2f", doubleResult) + "i");
    }
    
    if(result.contains("+-"))
    {
      result = result.substring(0,result.indexOf("+")) + "-" + result.substring(result.indexOf("-") + 1);
     }
    return result;
  }
}
