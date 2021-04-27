package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import operations.ExponentOperator;

class ExponentOperatorTest
{

  @Test
  public void validRegularNumSqredTest()
  {
    String operand = "3";
    String power = "2";
    String expectedResult = "9.00+0.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void validRegularNumSqredZeroBaseTest()
  {
    String operand = "3";
    String power = "0";
    String expectedResult = "1.00+0.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void validImagNumSqredBaseZeroTest()
  {
    String operand = "3i";
    String power = "0";
    String expectedResult = "1.00+0.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void validImagNumSqredBase1Test()
  {
    String operand = "3i";
    String power = "1";
    String expectedResult = "0.00+3.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void validRegularNumCubedTest()
  {
    String operand = "4";
    String power = "3";
    String expectedResult = "64.00+0.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void validiCubedTest()
  {
    String operand = "i";
    String power = "3";
    String expectedResult = "-0.00-1.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void validiSixthedTest()
  {
    String operand = "i";
    String power = "6";
    String expectedResult = "-1.00+0.00i";
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
    String expectedMessage = "Please provide a valid operand";
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
    String expectedMessage = "Please provide a valid base";
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
    String expectedMessage = "Please provide a valid operand";
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
    String expectedMessage = "Please provide a valid operand";
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
    String expectedResult = "9.00+0.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void validImagZero()
  {
    String operand = "3+0.0i";
    String power = "2";
    String expectedResult = "9.00+0.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

}
