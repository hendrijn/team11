package operations;

import java.util.StringTokenizer;

public class AdditionOperator implements Operator
{

  
  @Override
  public String evaluate(String leftOperand, String rightOperand)
  {
    if (leftOperand == null || rightOperand == null) 
    {
      throw new IllegalArgumentException("Left or right operand is null.");
    }
    
    StringTokenizer leftTokenizer = new StringTokenizer(leftOperand, " + ");
    StringTokenizer rightTokenizer = new StringTokenizer(rightOperand, " + ");
    
    //Left side preliminary work
    String leftNonIComplexN = leftTokenizer.nextToken();
    String leftIComplexN = leftTokenizer.nextToken();
    StringTokenizer leftTokenizerForI = new StringTokenizer(leftIComplexN, "i");
    String leftIComplexNNoUnits = leftTokenizerForI.nextToken();
    
    //Right side preliminary work
    String rightNonIComplexN = rightTokenizer.nextToken();
    String rightIComplexN = rightTokenizer.nextToken();
    StringTokenizer rightTokenizerForI = new StringTokenizer(rightIComplexN, "i");
    String rightIComplexNNoUnits = rightTokenizerForI.nextToken();
    
    
    //Conversion from Strings to Ints
    int nonILeftAdd = Integer.parseInt(leftNonIComplexN);
    int iLeftAdd = Integer.parseInt(leftIComplexNNoUnits);
    int nonIRightAdd = Integer.parseInt(rightNonIComplexN);
    int iRightAdd = Integer.parseInt(rightIComplexNNoUnits);
    
    //final addition
    int finalNotITotal = nonILeftAdd + nonIRightAdd;
    int finalItotal = iLeftAdd + iRightAdd;
    
    //final string
    return finalNotITotal + " + " + finalItotal + "i";
  }

}
