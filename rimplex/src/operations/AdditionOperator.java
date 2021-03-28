package operations;


public class AdditionOperator implements Operator
{

  
  @Override
  public String evaluate(String leftOperand, String rightOperand)
  {
    
 
    if (leftOperand == null || rightOperand == null || leftOperand == "" || rightOperand == "") 
    {
      throw new IllegalArgumentException("Please provide two valid operands.");
    }
    
    
//    if (leftOperand.equals("i")) 
//    { 
//      leftOperand 
//    }
      
      
    //Appending complex number units to non-complex numbers
    if (leftOperand.equals("i")) 
    {
      leftOperand = "1i+0";
    }
    
    if (rightOperand.equals("i")) 
    {
      rightOperand = "1i+0";
    }
    
    if (leftOperand.equals("-i")) 
    {
      leftOperand = "-1i+0";
    }
    
    if (rightOperand.equals("-i")) 
    {
      rightOperand = "-1i+0";
    }
        
    if (!leftOperand.contains("i")) {
      leftOperand  = leftOperand + "+0i";
    }
    
    if (!rightOperand.contains("i")) {
      rightOperand = rightOperand + "+0i";
    }
    
    if (!leftOperand.contains("+")) {
      leftOperand  = leftOperand + "+0";
    }
    
    if (!rightOperand.contains("+")) {
      rightOperand = rightOperand + "+0";
    }
    
    
    
    //Method for counting i's in a string from: https://www.baeldung.com/java-count-chars 
    long iCountLeft = leftOperand.chars().filter(ch -> ch == 'i').count();
    long iCountRight = rightOperand.chars().filter(ch -> ch == 'i').count();
    
    if (iCountLeft > 1 || iCountRight > 1) 
    {
      throw new IllegalArgumentException("Please provide two valid operands, or simplify them.");
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
      leftRegularNumber   = simplifedLeftAugend;
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
    
    if (leftImaginaryNumber.equals("")) {
      leftImaginaryNumber = "1";
    }
    
    if (rightImaginaryNumber.equals("")) {
      rightImaginaryNumber = "1";
    }
    
    //Integer processing
    int leftImagNumInt = 0;
    try
    {
      leftImagNumInt = Integer.parseInt(leftImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException("Not a valid operand.");
    }
    
    
    int leftRegNumInt = 0;
    try
    {
      leftRegNumInt = Integer.parseInt(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {
      
      throw new IllegalArgumentException("Not a valid operand.");
    }
    
    
    int rightImagNumInt = 0;
    try
    {
      rightImagNumInt = Integer.parseInt(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      
      throw new IllegalArgumentException("Not a valid operand.");
    }
    
    
    int rightRegNumInt = 0;
    try
    {
      rightRegNumInt = Integer.parseInt(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {
      
      throw new IllegalArgumentException("Not a valid operand.");
    }
    
    int finalRegTotal  =  leftRegNumInt + rightRegNumInt;
    int finalImagTotal = rightImagNumInt + leftImagNumInt;
    
    return finalRegTotal + "+" + finalImagTotal + "i";
   
  }

}
