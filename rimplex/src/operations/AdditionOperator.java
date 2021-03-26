package operations;

import java.util.StringTokenizer;

public class AdditionOperator implements Operator
{

  
  @Override
  public String evaluate(String leftOperand, String rightOperand)
  {
    
 
    if (leftOperand == null || rightOperand == null || leftOperand == "" || rightOperand == "") 
    {
      throw new IllegalArgumentException("Please provide two operands");
    }
    
    //Appending complex number units to non-complex numbers
    if (!leftOperand.contains("i")) {
      leftOperand = leftOperand + "+0i";
    }
    
    if (!rightOperand.contains("i")) {
      rightOperand = rightOperand + "+0i";
    }
    
    
    String simplifedLeft  = leftOperand.replaceAll(" ", "");
    String simplifedRight = rightOperand.replaceAll(" ", "");
     
    int leftPlusIndex  = simplifedLeft.indexOf("+");
    int rightPlusIndex = simplifedRight.indexOf("+");
   
    //Getting the two parts of the complex number
    String simplifedLeftAugend  = simplifedLeft.substring(0, leftPlusIndex);
    String simplifedLeftAddend  = simplifedLeft.substring(leftPlusIndex + 1);
    String simplifedRightAugend = simplifedRight.substring(0, rightPlusIndex);
    String simplifedRightAddend = simplifedRight.substring(rightPlusIndex + 1);
    
    String leftImaginaryNumber  = "";
    String rightImaginaryNumber = "";
    String leftRegularNumber    = "";
    String rightRegularNumber   = "";
    
    //Figuring out which part is the i units
    if (simplifedLeftAugend.contains("i")) 
    {
      leftImaginaryNumber = simplifedLeftAugend.replaceAll("i", "");
      leftRegularNumber   = simplifedLeftAddend;
    }
    else 
    {
      leftImaginaryNumber = simplifedLeftAddend.replaceAll("i", "");
      leftRegularNumber  = simplifedLeftAugend;
    }
    
    
    if (simplifedRightAugend.contains("i")) 
    {
      rightImaginaryNumber = simplifedRightAugend.replaceAll("i", "");
      rightRegularNumber   = simplifedRightAddend;
    }
    else 
    {
      rightImaginaryNumber = simplifedRightAddend.replaceAll("i", "");
      rightRegularNumber   = simplifedRightAugend;
    }
    
    //Integer processing
    int leftImagNumInt  = Integer.parseInt(leftImaginaryNumber);
    int leftRegNumInt   = Integer.parseInt(leftRegularNumber);
    int rightImagNumInt = Integer.parseInt(rightImaginaryNumber);
    int rightRegNumInt  = Integer.parseInt(rightRegularNumber);
    
    int finalRegTotal =  leftRegNumInt + rightRegNumInt;
    int finalImagTotal = rightImagNumInt + leftImagNumInt;
    
    return finalRegTotal + " + " + finalImagTotal + "i";
   
  }

}
