package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import operations.SquareRootOperator;

public class SquareRootOperatorTesting
{

  @Test
  public void validRealNumberTest1()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator();
   String operand = "4";
   String expected = "2.00+0.00i";
   String actual = sqrt.evaluate(operand);
   assertEquals(expected, actual);
  }
  
  @Test
  public void validRealNumberTest2()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator(); 
   String operand = "78";
   String expected = "8.83+0.00i";
   String actual = sqrt.evaluate(operand);
   assertEquals(expected, actual);
  }
  
  @Test
  public void invalidOperandNullTest()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator(); 
   String operand = null;
   String expectedMessage = "Please provide a valid operand";
   Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
     sqrt.evaluate(operand);
   });
   assertEquals(expectedMessage, exception.getMessage());
  }

  
  @Test
  public void invalidOperandGibbershTest()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator(); 
   String operand = "abcascx";
   String expectedMessage = "Please provide a valid operand";
   Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
     sqrt.evaluate(operand);
   });
   assertEquals(expectedMessage, exception.getMessage());
  }
  
  
  @Test
  public void validNegativeRealNumberTest1()
  {
    
    SquareRootOperator sqrt = new SquareRootOperator(); 
    String operand = "-48";
    String expected = "6.93i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }
  
  @Test
  public void validNegativeRealNumberTest2()
  {
    
    SquareRootOperator sqrt = new SquareRootOperator(); 
    String operand = "-1";
    String expected = "1.00i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }
}
