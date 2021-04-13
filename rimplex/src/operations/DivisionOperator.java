package operations;

import java.util.Arrays;

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
    String result = "0.00+0.00i";

    if(complexL && complexR)
    {
      ConjugateOperator c = new ConjugateOperator();
      MultiplicationOperator mult = new MultiplicationOperator();
      String conjugate = c.conjugate(alteredROp);
      String top = mult.evaluate(alteredLOp, conjugate);
      String bottom = mult.evaluate(conjugate, alteredROp);
      String[] conjugateParts = TempContext.decomposeOperands(top, bottom);
      double realDiv = Double.parseDouble(conjugateParts[0]) / Double.parseDouble(conjugateParts[2]);
      double imgDiv = Double.parseDouble(conjugateParts[1]) / Double.parseDouble(conjugateParts[2]);

      result = TempContext.format(String.format("%.2f",realDiv) + "+" + String.format("%.2f", imgDiv) + "i");
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
    else if(complexL && imaginaryR)
    {
      double realNum = Double.parseDouble(parts[0]) / (Double.parseDouble(parts[3]));
      double imgNum = Double.parseDouble(parts[1]) / Double.parseDouble(parts[3]);
      result = TempContext.format(String.format("%.2f", imgNum) + "+" + String.format("%.2f", realNum) + "i");
    }
    else if(imaginaryL && complexR)
    {
      //conjugate
    }
    else if (complexL && realR)
    {
      /*ConjugateOperator c = new ConjugateOperator();
      MultiplicationOperator mult = new MultiplicationOperator();
      double realNum = Double.parseDouble(parts[0]) / Double.parseDouble(mult.evaluate(parts[2], c.conjugate(parts[2])));
      double imgNum = Double.parseDouble(parts[1]) / Double.parseDouble(parts[2]);
      result = TempContext.format(String.format("%.2f", realNum) + "+" + String.format("%.2f", imgNum) + "i");*/
    }
    else if (realL && complexR)
    {
      //conjugate
    }

    if(result.contains("+-"))
    {
      result = result.substring(0, result.indexOf("+")) + "-" + result.substring(result.indexOf("+") + 2);
     }
    return result;
  }
}
