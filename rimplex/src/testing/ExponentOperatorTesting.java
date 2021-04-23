package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import operations.ExponentOperator;

class ExponentOperatorTesting
{

  @Test
  public void validRegularNumSqredTest()
  {
    String operand = "3";
    String power = "2";
    String expectedResult = "9.0+00.0i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void validRegularNumCubedTest()
  {
    String operand = "4";
    String power = "3";
    String expectedResult = "64.0+00.0i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void validiCubedTest()
  {
    String operand = "i";
    String power = "3";
    String expectedResult = "0.00-1.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void validiSquaredTest()
  {
    String operand = "i";
    String power = "2";
    String expectedResult = "-1.00+0.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  
  @Test
  public void validComplexNumTest()
  {
    String operand = "3+2i";
    String power = "4";
    String expectedResult = "-119.00+120.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void invalidOperand()
  {
    String operand = null;
    String power = "2";
    ExponentOperator expOp = new ExponentOperator();
    String expectedMessage = "Please provide a valid operand.";
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      expOp.exponentation(operand, power);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }
  
  @Test
  public void invalidBase()
  {
    String operand = "4";
    String power = null;
    ExponentOperator expOp = new ExponentOperator();
    String expectedMessage = "Please provide a valid base.";
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      expOp.exponentation(operand, power);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }
  
  @Test
  public void invalidRealOperandGibbersh()
  {
    String operand = "ajjajaja";
    String power = "2";
    ExponentOperator expOp = new ExponentOperator();
    String expectedMessage = "Please provide a valid operand.";
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      expOp.exponentation(operand, power);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }
  
  

  @Test
  public void invalidOperandImagGibbersh()
  {
    String operand = "3+abci";
    String power = "2";
    ExponentOperator expOp = new ExponentOperator();
    String expectedMessage = "Please provide a valid operand.";
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      expOp.exponentation(operand, power);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }
  
  @Test
  public void validImagNegativeZero()
  {
    String operand = "3-0.0i";
    String power = "2";
    String expectedResult = "9.0+00.0i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  
  @Test
  public void validImagZero()
  {
    String operand = "3+0.0i";
    String power = "2";
    String expectedResult = "9.0+00.0i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

}
