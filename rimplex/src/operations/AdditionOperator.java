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
      
      
    /*//Appending complex number units to non-complex numbers
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
    }*/
    String simplifedLeft  = leftOperand.replaceAll(" ", "");
    String simplifedRight = rightOperand.replaceAll(" ", "");
    
    String alterROp = TempContext.format(simplifedRight);
    String alteredLOp = TempContext.format(simplifedLeft);
    //Method for counting i's in a string from: https://www.baeldung.com/java-count-chars 
    long iCountLeft = alteredLOp.chars().filter(ch -> ch == 'i').count();
    long iCountRight = alterROp.chars().filter(ch -> ch == 'i').count();
    
    if (iCountLeft > 1 || iCountRight > 1) 
    {
      throw new IllegalArgumentException("Please provide two valid operands, or simplify them.");
    }
    
    
     
    int leftPlusIndex  = alteredLOp.indexOf("+");
    int rightPlusIndex = alterROp.indexOf("+");
   
    //Getting the two parts of the complex number
    String simplifedLeftAugend  = alteredLOp.substring(0, leftPlusIndex);
    String simplifedLeftAddend  = alteredLOp.substring(leftPlusIndex + 1);
    String simplifedRightAugend = alterROp.substring(0, rightPlusIndex);
    String simplifedRightAddend = alterROp.substring(rightPlusIndex + 1);
    
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
    long leftImagNumLong = 0;
    try
    {
      leftImagNumLong = Long.parseLong(leftImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      throw new IllegalArgumentException("Not a valid operand.");
    }
    
    
    long leftRegNumLong = 0;
    try
    {
      leftRegNumLong = Long.parseLong(leftRegularNumber);
    }
    catch (NumberFormatException e)
    {
      
      throw new IllegalArgumentException("Not a valid operand.");
    }
    
    
    long rightImagNumLong = 0;
    try
    {
      rightImagNumLong = Long.parseLong(rightImaginaryNumber);
    }
    catch (NumberFormatException e)
    {
      
      throw new IllegalArgumentException("Not a valid operand.");
    }
    
    
    long rightRegNumLong = 0;
    try
    {
      rightRegNumLong = Long.parseLong(rightRegularNumber);
    }
    catch (NumberFormatException e)
    {
      
      throw new IllegalArgumentException("Not a valid operand.");
    }
    
    long finalRegTotal  =  leftRegNumLong + rightRegNumLong;
    long finalImagTotal =  leftImagNumLong + rightImagNumLong;

    return finalRegTotal + "+" + finalImagTotal + "i";
   
  }

}
