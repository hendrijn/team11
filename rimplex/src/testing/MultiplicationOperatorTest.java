package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import operations.MultiplicationOperator;
import operations.TempContext;

/**
 * Unit tests for the MultiplcationOperator.
 * 
 * @author pgleb - team 11
 * @version Sprint 3
 */
public class MultiplicationOperatorTest
{
  private final String invalid = "Please provide two valid operands";
  private final String simplify = "Please provide a valid operand, or simplify it";
  private final String empty = "Please provide a valid operand";
  private final String complexZero = "0.00+0.00i";
  private final String complexOne = "3 + 2i";
  private final String complexTwo = "4 + 2i";
  private final String complexThree = "4 + 3i";
  private final String complexFour = "3 + 3i";
  private final String complexFive = "3 - 2i";
  private final String complexSix = "4 - 2i";
  private final String complexSeven = "400 - 3i";
  private final String complexEight = "-4-2i";
  private final String complexNine = "-3+5i";
  private final String complexDecimalOne = "-120000.00+0.00i";
  private final String negFourHun = "-400";
  private final String negThreeHun = "-300";
  private final String zero = "0";
  private final String four = "4";
  private final String six = "6";
  private final String threeHun = "300";
  private final String fourHun = "400";
  private final String i = "i";
  private final String iLoveCS345 = "iLoveCS345";
  
  /**
   * Testing two complex numbers.
   */
  @Test
  public void twoValidComplexNumbersTest()
  {
    String complexNumberOne = complexOne;
    String complexNumberTwo = complexTwo;
    String expectedResult = "8.00+14.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  /**
   *  Testing two real numbers.
   */
  @Test
  public void twoValidRealNumTest()
  {
    String complexNumberOne = "3";
    String complexNumberTwo = four;
    String expectedResult = "12.00+0.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing one complex one real.
   */
  @Test
  public void twoValidComplexNumMix1Test()
  {
    String complexNumberOne = complexOne;
    String complexNumberTwo = four;
    String expectedResult = "12.00+8.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing one complex one real with mixed formatting.
   */
  @Test
  public void twoValidComplexNumMix2Test()
  {
    String complexNumberOne = six;
    String complexNumberTwo = "4i + 4";
    String expectedResult = "24.00+24.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing times zero with a real number.
   */
  @Test
  public void twoValidZero1Test()
  {
    String complexNumberOne = six;
    String complexNumberTwo = zero;
    String expectedResult = complexZero;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing times zero with a complex number.
   */
  @Test
  public void twoValidZero2Test()
  {
    String complexNumberOne = zero;
    String complexNumberTwo = "3i+2";
    String expectedResult = complexZero;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing times zero with just i.
   */
  @Test
  public void twoValidZero3Test()
  {
    String complexNumberOne = i;
    String complexNumberTwo = zero;
    String expectedResult = complexZero;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing i times i.
   */
  @Test
  public void twoValidComplexNumI1Test()
  {
    String complexNumberOne = i;
    String complexNumberTwo = i;
    String expectedResult = "-1.00+0.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing two imaginary numbers times each other.
   */
  @Test
  public void twoValidComplexNumI2Test()
  {
    String complexNumberOne = "2i";
    String complexNumberTwo = "15i";
    String expectedResult = "-30.00+0.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing a null left operand.
   */
  @Test
  public void inValidNullLeftOperandTest()
  {
    String complexNumberOne = null;
    String complexNumberTwo = complexTwo;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = invalid;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a null right operand.
   */
  @Test
  public void inValidNullRightOperandTest()
  {
    String complexNumberOne = complexTwo;
    String complexNumberTwo = null;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = invalid;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an empty left operand.
   */
  @Test
  public void inValidEmptyLeftOperandTest()
  {
    String complexNumberOne = "";
    String complexNumberTwo = complexTwo;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = invalid;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an empty right operand.
   */
  @Test
  public void inValidEmptyRightOperandTest()
  {
    String complexNumberOne = complexThree;
    String complexNumberTwo = "";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = invalid;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an invalid regular part of a complex number left operand.
   */
  @Test
  public void inValidRegLeftOperandTest()
  {
    String complexNumberOne = "4b + 3i";
    String complexNumberTwo = complexFour;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an invalid complex number left operand.
   */
  @Test
  public void inValidImagLeftOperandTest()
  {
    String complexNumberOne = "4b + 3iiabc";
    String complexNumberTwo = complexFour;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = simplify;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an invalid regular part of a complex number right operand.  
   */
  @Test
  public void inValidRegRightOperandTest()
  {
    String complexNumberOne = complexThree;
    String complexNumberTwo = "bvxc + 3i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an invalid imaginary number in the right operand.
   */
  @Test
  public void inValidImagRightOperandTest()
  {
    String complexNumberOne = complexThree;
    String complexNumberTwo = "4 + 3iasdsads";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an nonsense left operand.
   */
  @Test
  public void inValidGibberishLeftOperandTest()
  {
    String complexNumberOne = "dsfgfdsgdsfg";
    String complexNumberTwo = complexThree;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an nonsense right operand.
   */
  @Test
  public void inValidGibberishRightOperandTest()
  {
    String complexNumberOne = complexThree;
    String complexNumberTwo = iLoveCS345;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing invalid imaginary unit format on the left.
   */
  @Test
  public void tooManyIsLeftTest()
  {
    String complexNumberOne = "4 + 3iiiiiiiii";
    String complexNumberTwo = iLoveCS345;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = simplify;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing invalid imaginary unit format on the right.
   */
  @Test
  public void tooManyIsRightTest()
  {
    String complexNumberOne = complexThree;
    String complexNumberTwo = "4iiiiii + 3i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = simplify;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an invalid left operand with an i in it.
   */
  @Test
  public void oneIInvalidLeftOperandTest()
  {
    String complexNumberOne = iLoveCS345;
    String complexNumberTwo = complexThree;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an invalid right operand with an i in it.
   */
  @Test
  public void oneIInvalidRightOperandTest()
  {
    String complexNumberOne = complexThree;
    String complexNumberTwo = iLoveCS345;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing one positive and one negative complex number.
   */
  @Test
  public void twoValidComplexNumbersNeg1Test()
  {
    String complexNumberOne = complexFive;
    String complexNumberTwo = complexTwo;
    String expectedResult = "16.00-2.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing one positive and one negative complex numbers.
   */
  @Test
  public void twoValidComplexNumbersNeg2Test()
  {
    String complexNumberOne = complexOne;
    String complexNumberTwo = complexSix;
    String expectedResult = "16.00+2.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing one positive and one negative complex numbers.
   */
  @Test
  public void twoValidComplexNumbersNeg3Test()
  {
    String complexNumberOne = complexFive;
    String complexNumberTwo = complexSix;
    String expectedResult = "8.00-14.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }


  /**
   * Testing multiplying with negative numbers and decimals.
   */
  @Test
  public void twoValidRegNumbersNeg1Test()
  {
    String complexNumberOne = negThreeHun;
    String complexNumberTwo = fourHun;
    String expectedResult = complexDecimalOne;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing multiplying with one positive and one negative numbers with decimals.
   */
  @Test
  public void twoValidRegNumbersNeg2Test()
  {
    String complexNumberOne = threeHun;
    String complexNumberTwo = negFourHun;
    String expectedResult = complexDecimalOne;
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing multiplying with negative numbers with decimals.
   */
  @Test
  public void twoValidRegNumbersNeg3Test()
  {
    String complexNumberOne = negThreeHun;
    String complexNumberTwo = negFourHun;
    String expectedResult = "120000.00-0.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing multiplying with real and complex numbers with decimals.
   */
  @Test
  public void twoValidMixedNumbersNeg1Test()
  {
    String complexNumberOne = "-300 + 4i";
    String complexNumberTwo = fourHun;
    String expectedResult = "-120000.00+1600.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing multiplying with real and complex numbers with negatives.
   */
  @Test
  public void twoValidMixedNumbersNeg2Test()
  {
    String complexNumberOne = "20";
    String complexNumberTwo = complexSeven;
    String expectedResult = "8000.00-60.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing multiplying with real and complex numbers with negatives.
   */
  @Test
  public void twoValidMixedNumbersNeg3Test()
  {
    String complexNumberOne = "-20";
    String complexNumberTwo = complexSeven;
    String expectedResult = "-8000.00+60.00i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing two imaginary decimal operands.
   */
  @Test
  public void testDecimalOperands2()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("6.42i", "7.75i");
    String expected = "-49.76+0.00i";
    assertEquals(expected, actual);
  }

  /**
   * Testing two real decimal operands.
   */
  @Test
  public void testDecimalOperands3()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("3.88", "2.94");
    String expected = "11.41+0.00i";
    assertEquals(expected, actual);
  }

  /**
   * Testing one complex decimal operand and one imaginary.
   */
  @Test
  public void testDecimalOperands4()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("0.89+7.25i", "3.56i");
    String expected = "-25.81+3.17i";
    assertEquals(expected, actual);
  }

  /**
   * Testing one complex decimal operand and one real.
   */
  @Test
  public void testDecimalOperands5()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("3.39+6.89i", "2.09");
    String expected = "7.09+14.40i";
    assertEquals(expected, actual);
  }

  /**
   * Testing one imaginary decimal operand and one real.
   */
  @Test
  public void testDecimalOperands6()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("9.06", "2.66i");
    String expected = "0.00+24.10i";
    assertEquals(expected, actual);
  }

  /**
   * Testing two negative complex numbers with decimals.
   */
  @Test
  public void testNegComplex()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate(complexNine, complexEight);
    String expected = "22.00-14.00i";
    assertEquals(expected, actual);
  }

  /**
   * Testing one negative complex number and one real.
   */
  @Test
  public void testNegComplex2()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate(complexNine, "-4");
    String expected = "12.00-20.00i";
    assertEquals(expected, actual);
  }
}
