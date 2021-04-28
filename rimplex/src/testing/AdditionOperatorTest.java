package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import operations.AdditionOperator;
import operations.TempContext;

/**
 * Unit tests for the Addition Operator Class.
 * 
 * @author team 11 - pgleb
 * @version Sprint 3
 */
public class AdditionOperatorTest
{
  private final String complexOne = "3 + 2i";
  private final String complexTwo = "4 + 2i";
  private final String complexThree = "3i + 4";
  private final String complexFour = "4 + 3i";
  private final String complexFive = "3 + 3i";
  private final String complexSix = "2 + 3i";
  private final String complexSeven = "2 + 2i";
  private final String complexEight = "2 + i";
  private final String complexDecimalOne = "7.00+4.00i";
  private final String negativeI = "-i";
  private final String i = "i";
  private final String four = "4";
  private final String seven = "7";
  private final String invalid = "Please provide two valid operands";
  private final String empty = "Please provide a valid operand";
  private final String simplify = "Please provide a valid operand, or simplify it";
  private final String iLoveCS345 = "iLoveCS345";

  /**
   * Testing for two valid complex numbers.
   */
  @Test 
  public void twoValidComplexNumbersTest()
  {
    String complexNumberOne = complexOne;
    String complexNumberTwo = complexTwo;
    String expectedResult = complexDecimalOne;
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing for two valid complex numbers.
   */
  @Test
  public void twoValidComplex2NumbersTest()
  {
    String complexNumberOne = "3-2i";
    String complexNumberTwo = "4+2i";
    String expectedResult = "7.00+0.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing for two valid with varying spacing complex numbers.
   */
  @Test
  public void twoValidNoSpaceComplexNumbersTest()
  {
    String complexNumberOne = "3+2i";
    String complexNumberTwo = complexTwo;
    String expectedResult = complexDecimalOne;
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing with one complex and one imaginary.
   */
  @Test
  public void oneValidComplexOneImaginaryTest()
  {
    String complexNumberOne = complexOne;
    String complexNumberTwo = "2i";
    String expectedResult = "3.00+4.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing with one real and one complex number.
   */
  @Test
  public void twoValidNumbersCombinedTest()
  {
    String complexNumberOne = "42";
    String complexNumberTwo = "1 + 2i";
    String expectedResult = "43.00+2.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing with one negative complex and one positive complex number.
   */
  @Test
  public void twoValidComplexNumbersNegTest()
  {
    String complexNumberOne = "-3 + 2i";
    String complexNumberTwo = complexTwo;
    String expectedResult = "1.00+4.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing with one fully negative complex number and one positive complex number.
   */
  @Test
  public void twoValidComplexNumbersNegITest()
  {
    String complexNumberOne = "-3 + -2i";
    String complexNumberTwo = complexTwo;
    String expectedResult = "1.00+0.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing two complex numbers with one out of traditional format.
   */
  @Test
  public void twoValidComplexNumbersDiffIPlacementTest()
  {
    String complexNumberOne = complexThree;
    String complexNumberTwo = complexTwo;
    String expectedResult = "8.00+5.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing two complex numbers both out of traditional format.
   */
  @Test
  public void twoValidComplexNumbersDiffIPlacementTest2()
  {
    String complexNumberOne = complexThree;
    String complexNumberTwo = "4i + 2";
    String expectedResult = "6.00+7.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing two valid real numbers.
   */
  @Test
  public void twoValidRealNumbersTest()
  {
    String complexNumberOne = four;
    String complexNumberTwo = seven;
    String expectedResult = "11.00+0.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing two valid real numbers, one negative in the first spot.
   */
  @Test
  public void twoValidRealNegNumbersTest()
  {
    String complexNumberOne = "-4";
    String complexNumberTwo = seven;
    String expectedResult = "3.00+0.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing two valid real numbers, one negative in the second spot.
   */
  @Test
  public void twoValidRealNegNumbers2Test()
  {
    String complexNumberOne = four;
    String complexNumberTwo = "-7";
    String expectedResult = "-3.00+0.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  
  /**
   * Testing one real and one complex number.
   */
  @Test
  public void validOneRealOneComplexNumbersTest()
  {
    String complexNumberOne = four;
    String complexNumberTwo = "7 + 9i";
    String expectedResult = "11.00+9.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing an null left operand.
   */
  @Test
  public void inValidNullLeftOperandTest()
  {
    String complexNumberOne = null;
    String complexNumberTwo = complexTwo;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = invalid;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an null right operand.
   */
  @Test
  public void inValidNullRightOperandTest()
  {
    String complexNumberOne = complexTwo;
    String complexNumberTwo = null;
    TempContext tempContext = new TempContext(new AdditionOperator());
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
    TempContext tempContext = new TempContext(new AdditionOperator());
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
    String complexNumberOne = complexFour;
    String complexNumberTwo = "";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = invalid;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a complex number with an invalid real num component.
   */
  @Test
  public void inValidRegLeftOperandTest()
  {
    String complexNumberOne = "4b + 3i";
    String complexNumberTwo = complexFive;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a complex number with an invalid imaginary and real num component.
   */
  @Test
  public void inValidImagLeftOperandTest()
  {
    String complexNumberOne = "4b + 3iiabc";
    String complexNumberTwo = complexFive;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = simplify;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a complex number with an invalid real num component.
   */
  @Test
  public void inValidRegRightOperandTest()
  {
    String complexNumberOne = complexFour;
    String complexNumberTwo = "bvxc + 3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a complex number with an invalid imaginary num component.
   */
  @Test
  public void inValidImagRightOperandTest()
  {
    String complexNumberOne = complexFour;
    String complexNumberTwo = "4 + 3iasdsads";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a nonsensical operand on the left.
   */
  @Test
  public void inValidGibberishLeftOperandTest()
  {
    String complexNumberOne = "dsfgfdsgdsfg";
    String complexNumberTwo = complexFour;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a nonsensical operand on the right.
   */
  @Test
  public void inValidGibberishRightOperandTest()
  {
    String complexNumberOne = complexFour;
    String complexNumberTwo = iLoveCS345;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing too many is on the left operand imaginary part.
   */
  @Test
  public void tooManyIsLeftTest()
  {
    String complexNumberOne = "4 + 3iiiiiiiii";
    String complexNumberTwo = iLoveCS345;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = simplify;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing too many is on the right operand imaginary part.
   */
  @Test
  public void tooManyIsRightTest()
  {
    String complexNumberOne = complexFour;
    String complexNumberTwo = "4iiiiii + 3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = simplify;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a nonsensical operand (that has an i in it) on the left.
   */
  @Test
  public void oneIInvalidLeftOperandTest()
  {
    String complexNumberOne = iLoveCS345;
    String complexNumberTwo = complexFour;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a nonsensical operand (that has an i in it) on the right.
   */
  @Test
  public void oneIInvalidRightOperandTest()
  {
    String complexNumberOne = complexFour;
    String complexNumberTwo = iLoveCS345;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing i + i.
   */
  @Test
  public void iPlusI1Test()
  {
    String complexNumberOne = i;
    String complexNumberTwo = i;
    String expectedResult = "0.00+2.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing i plus a complex number.
   */
  @Test
  public void iPlusI2Test()
  {
    String complexNumberOne = i;
    String complexNumberTwo = complexSeven;
    String expectedResult = "2.00+3.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing a complex number that has 1i plus another complex.
   */
  @Test
  public void iPlusILeftTest()
  {
    String complexNumberOne = complexEight;
    String complexNumberTwo = complexSeven;
    String expectedResult = "4.00+3.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing a complex number that has 1i plus another complex number that has 1i.
   */
  @Test
  public void iPlusIRightTest()
  {
    String complexNumberOne = complexEight;
    String complexNumberTwo = complexEight;
    String expectedResult = "4.00+2.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing just a single i on the left being added to a complex number.
   */
  @Test
  public void singleILeftTest()
  {
    String complexNumberOne = i;
    String complexNumberTwo = complexOne;
    String expectedResult = "3.00+3.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing just a single i on the right being added to a complex number.
   */
  @Test
  public void singleIRightTest()
  {
    String complexNumberOne = complexSix;
    String complexNumberTwo = i;
    String expectedResult = "2.00+4.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing just a single negative i on the left being added to a complex number.
   */
  @Test
  public void singleNegILeftTest()
  {
    String complexNumberOne = negativeI;
    String complexNumberTwo = "2i + 2";
    String expectedResult = "2.00+1.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing just a single negative i on the right being added to a complex number.
   */
  @Test
  public void singleNegIRightTest()
  {
    String complexNumberOne = complexSix;
    String complexNumberTwo = negativeI;
    String expectedResult = "2.00+2.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing a negative imaginary number plus a complex number.
   */
  @Test
  public void singleNegMIRightTest()
  {
    String complexNumberOne = complexSix;
    String complexNumberTwo = "-6i";
    String expectedResult = "2.00-3.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing one positive and one complex number.
   */
  @Test
  public void operandsWithSubtractionTest()
  {
    String complexNumberOne = complexSix;
    String complexNumberTwo = "2 - 2i";
    String expectedResult = "4.00+1.00i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Testing two complex decimal operands.
   */
  @Test
  public void testDecimalOperands1()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("3.45+7.56i", "2.98+5.04i");
    String expected = "6.43+12.60i";
    assertEquals(expected, actual);
  }

  /**
   * Testing two imaginary decimal operands.
   */
  @Test
  public void testDecimalOperands2()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("6.42i", "7.75i");
    String expected = "0.00+14.17i";
    assertEquals(expected, actual);
  }

  /**
   * Testing two real decimal operands.
   */
  @Test
  public void testDecimalOperands3()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("3.88", "2.94");
    String expected = "6.82+0.00i";
    assertEquals(expected, actual);
  }

  /**
   * Testing one complex and one imaginary decimal operands.
   */
  @Test
  public void testDecimalOperands4()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("0.89+7.25i", "3.56i");
    String expected = "0.89+10.81i";
    assertEquals(expected, actual);
  }

  /**
   * Testing one complex and one real decimal operands.
   */
  @Test
  public void testDecimalOperands5()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("3.39+6.89i", "2.09");
    String expected = "5.48+6.89i";
    assertEquals(expected, actual);
  }

  /**
   * Testing one real and one imaginary decimal operands.
   */
  @Test
  public void testDecimalOperands6()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("9.06", "2.66i");
    String expected = "9.06+2.66i";
    assertEquals(expected, actual);
  } 
}
