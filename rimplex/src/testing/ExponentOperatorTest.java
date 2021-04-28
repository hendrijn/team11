package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import operations.ExponentOperator;

/**
 * Unit tests for the ExponentOperator class.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class ExponentOperatorTest
{
  private final String empty = "Please provide a valid operand";
  private final String zero = "0";
  private final String two = "2";
  private final String three = "3";
  private final String four = "4";
  private final String complexDecimalOne = "9.00+0.00i";
  private final String complexDecimalTwo = "1.00+0.00i";
  private final String complexDecimalThree = "-1.00+0.00i";
  private final String imagOne = "3i";
  private final String imagTwo = "i";
  private final String complexOne = "3+2i";
 
  /**
   * tests for valid regular number squared.
   */
  @Test
  public void validRegularNumSqredTest()
  {
    String operand = three;
    String power = two;
    String expectedResult = complexDecimalOne;
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * tests for regular number to the zero power.
   */
  @Test
  public void validRegularNumSqredZeroBaseTest()
  {
    String operand = three;
    String power = zero;
    String expectedResult = complexDecimalTwo;
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   *  tests for imaginary number to the zero power.
   */
  @Test
  public void validImagNumSqredBaseZeroTest()
  {
    String operand = imagOne;
    String power = zero;
    String expectedResult = complexDecimalTwo;
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * tests for imaginary number to the first power.
   */
  @Test
  public void validImagNumSqredBase1Test()
  {
    String operand = imagOne;
    String power = "1";
    String expectedResult = "0.00+3.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * tests for regular number to the third.
   */
  @Test
  public void validRegularNumCubedTest()
  {
    String operand = four;
    String power = three;
    String expectedResult = "64.00+0.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * tests for i to the third power.
   */
  @Test
  public void validiCubedTest()
  {
    String operand = imagTwo;
    String power = three;
    String expectedResult = "-0.00-1.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  /**
   * test for i to the sixth power.
   */
  @Test
  public void validiSixthedTest()
  {
    String operand = imagTwo;
    String power = "6";
    String expectedResult = complexDecimalThree;
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * test for i to the second power.
   */
  @Test
  public void validiSquaredTest()
  {
    String operand = imagTwo;
    String power = two;
    String expectedResult = complexDecimalThree;
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * test complex number raised to real exponent.
   */
  @Test
  public void validComplexNumTest()
  {
    String operand = complexOne;
    String power = four;
    String expectedResult = "-119.00+120.00i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * test invalid operands.
   */
  @Test
  public void invalidOperand()
  {
    String operand = null;
    String power = two;
    ExponentOperator expOp = new ExponentOperator();
    String expectedMessage = empty;
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      expOp.exponentation(operand, power);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }

  /**
   * test invalid base.
   */
  @Test
  public void invalidBase()
  {
    String operand = four;
    String power = null;
    ExponentOperator expOp = new ExponentOperator();
    String expectedMessage = "Please provide a valid base";
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
    {
      expOp.exponentation(operand, power);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }

  /**
   * test invalid real operand.
   */
  @Test
  public void invalidRealOperandGibbersh()
  {
    String operand = "ajjajaja";
    String power = two;
    ExponentOperator expOp = new ExponentOperator();
    String expectedMessage = empty;
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      expOp.exponentation(operand, power);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }

  /**
   * test invalid imaginary operand.
   */
  @Test
  public void invalidOperandImagGibbersh()
  {
    String operand = "3+abci";
    String power = two;
    ExponentOperator expOp = new ExponentOperator();
    String expectedMessage = empty;
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
    {
      expOp.exponentation(operand, power);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }

  /**
   * test zero imaginary number.
   */
  @Test
  public void validImagNegativeZero()
  {
    String operand = "3-0.0i";
    String power = two;
    String expectedResult = complexDecimalOne;
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * tests zero imaginary number.
   */
  @Test
  public void validImagZero()
  {
    String operand = "3+0.0i";
    String power = two;
    String expectedResult = complexDecimalOne;
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
  
  
  /**
   * tests zero imaginary number.
   */
  @Test
  public void complexNumbeToNegativeBase()
  {
    String operand = complexOne;
    String power = "-2";
    String expectedResult = "0.03-0.07i";
    ExponentOperator expOp = new ExponentOperator();
    String actualResult = expOp.exponentation(operand, power);
    assertEquals(expectedResult, actualResult);
  }
}
