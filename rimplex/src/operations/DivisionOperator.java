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
      
    }
    else if (realL && realR)
    {
      double doubleL = Double.parseDouble(alteredLOp);
      double doubleR = Double.parseDouble(alteredROp);
      System.out.println(doubleL);
      System.out.println(doubleR);
      doubleResult = doubleL / doubleR;
      result = TempContext.format(String.format("%.2f", doubleResult));
    }
    
    return result;
  }
}
