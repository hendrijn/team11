package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import operations.SquareRootOperator;

/**
 * Unit tests for the Square Root Operator class.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class SquareRootOperatorTest
{

  private final String empty = "Please enter an operand";
  private final String invalid = "Please provide a valid operand";
  
  /**
   * tests valid real numbers.
   */
  @Test
  public void validRealNumberTest1()
  {

    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "4";
    String expected = "2.00+0.00i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }


  /**
   * tests valid real numbers.
   */
  @Test
  public void validRealNumberTest2()
  {

    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "78";
    String expected = "8.83+0.00i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }

  /**
   * tests null operand.
   */
  @Test
  public void invalidOperandNullTest()
  {

    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = null;
    String expectedMessage = empty;
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      sqrt.evaluate(operand);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }

  /**
   * tests empty operand.
   */
  @Test
  public void invalidOperandEmptyTest()
  {
    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "";
    String expectedMessage = empty;
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      sqrt.evaluate(operand);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }


  /**
   * tests operand with multiple i's.
   */
  @Test
  public void invalidOperandMultiITest()
  {
    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "5iii";
    String expectedMessage = invalid;
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      sqrt.evaluate(operand);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }


  /**
   * tests operand with just parentheses.
   */
  @Test
  public void invalidOperandJustParensTest()
  {
    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "()";
    String expectedMessage = empty;
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      sqrt.evaluate(operand);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }

  /**
   * tests random String.
   */
  @Test
  public void invalidOperandGibbershTest()
  {
    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "abcascx";
    String expectedMessage = invalid;
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      sqrt.evaluate(operand);
    });
    assertEquals(expectedMessage, exception.getMessage());
  }
  
  /**
   * tests negative real number.
   */
  @Test
  public void validNegativeRealNumberTest1()
  {
    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "-48";
    String expected = "6.93i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }


  /**
   * tests negative real number.
   */
  @Test
  public void validNegativeRealNumberTest2()
  {

    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "-1";
    String expected = "1.00i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }


  /**
   * tests a complex number.
   */
  @Test
  public void validComplexNumberTest1()
  {

    SquareRootOperator sqrt = new SquareRootOperator();
    String operand = "8-6i";
    String expected = "3.00-1.00i";
    String actual = sqrt.evaluate(operand);
    assertEquals(expected, actual);
  }

  /**
   * tests complex number.
   */
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
