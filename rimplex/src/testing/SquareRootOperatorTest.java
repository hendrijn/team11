package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import operations.SquareRootOperator;

public class SquareRootOperatorTest
{

  //Testing a real number square root
  @Test
  public void validRealNumberTest1()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator();
   String operand = "4";
   String expected = "2.00+0.00i";
   String actual = sqrt.evaluate(operand);
   assertEquals(expected, actual);
  }
  
  //Testing another real number square root
  @Test
  public void validRealNumberTest2()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator(); 
   String operand = "78";
   String expected = "8.83+0.00i";
   String actual = sqrt.evaluate(operand);
   assertEquals(expected, actual);
  }
  
  //Testing a null square root
  @Test
  public void invalidOperandNullTest()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator(); 
   String operand = null;
   String expectedMessage = "Please enter an operand";
   Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
     sqrt.evaluate(operand);
   });
   assertEquals(expectedMessage, exception.getMessage());
  }

  //Testing an empty operand
  @Test
  public void invalidOperandEmptyTest()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator(); 
   String operand = "";
   String expectedMessage = "Please enter an operand";
   Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
     sqrt.evaluate(operand);
   });
   assertEquals(expectedMessage, exception.getMessage());
  }

  //Testing a square root with too many is
  @Test
  public void invalidOperandMultiITest()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator(); 
   String operand = "5iii";
   String expectedMessage = "Please provide a valid operand";
   Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
     sqrt.evaluate(operand);
   });
   assertEquals(expectedMessage, exception.getMessage());
  }

  //Testing a square root with just parenthesises
  @Test
  public void invalidOperandJustParensTest()
  {
    
   SquareRootOperator sqrt = new SquareRootOperator(); 
   String operand = "()";
   String expectedMessage = "Please enter an operand";
   Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
     sqrt.evaluate(operand);
   });
   assertEquals(expectedMessage, exception.getMessage());
  }
  
  //Testing a square root with random letter
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
  
  //Testing a square root with a negative number
  @Test
  public void validNegativeRealNumberTest1()
  {
    
    SquareRootOperator sqrt = new SquareRootOperator(); 
    String operand = "-48";
    String expected = "6.93i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }
  
  //Testing a square root with negative one
  @Test
  public void validNegativeRealNumberTest2()
  {
    
    SquareRootOperator sqrt = new SquareRootOperator(); 
    String operand = "-1";
    String expected = "1.00i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }
  
  //Testing a complex number with a negative
  @Test
  public void validComplexNumberTest1()
  {
    
    SquareRootOperator sqrt = new SquareRootOperator(); 
    String operand = "8-6i";
    String expected = "3.00-1.00i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }
  
  //Testing a complex number
  @Test
  public void validComplexNumberTest2()
  {
    
    SquareRootOperator sqrt = new SquareRootOperator(); 
    String operand = "3+2i";
    String expected = "1.82+0.55i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }
}
