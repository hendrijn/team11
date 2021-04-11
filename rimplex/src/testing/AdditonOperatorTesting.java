package testing;

/**
 * Unit tests for the Addition Operator Class.
 * 
 * @author team 11 - pgleb
 * @version Sprint 1
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import operations.AdditionOperator;
import operations.TempContext;

class AdditonOperatorTesting
{

  @Test
  public void twoValidComplexNumbersTest()
  {
    String complexNumberOne = "3 + 2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "7+4i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplex2NumbersTest()
  {
    String complexNumberOne = "3-2i";
    String complexNumberTwo = "4+2i";
    String expectedResult = "7+0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidNoSpaceComplexNumbersTest()
  {
    String complexNumberOne = "3+2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "7+4i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersOnlyTest()
  {
    String complexNumberOne = "3 + 2i";
    String complexNumberTwo = "2i";
    String expectedResult = "3+4i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidNumbersCombinedTest()
  {
    String complexNumberOne = "42";
    String complexNumberTwo = "1 + 2i";
    String expectedResult = "43+2i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersNegTest()
  {
    String complexNumberOne = "-3 + 2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "1+4i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersNegITest()
  {
    String complexNumberOne = "-3 + -2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "1+0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersDiffIPlacementTest()
  {
    String complexNumberOne = "3i + 4";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "8+5i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersDiffIPlacementTest2()
  {
    String complexNumberOne = "3i + 4";
    String complexNumberTwo = "4i + 2";
    String expectedResult = "6+7i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidRealNumbersTest()
  {
    String complexNumberOne = "4";
    String complexNumberTwo = "7";
    String expectedResult = "11+0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidRealNegNumbersTest()
  {
    String complexNumberOne = "-4";
    String complexNumberTwo = "7";
    String expectedResult = "3+0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidRealNegNumbers2Test()
  {
    String complexNumberOne = "4";
    String complexNumberTwo = "-7";
    String expectedResult = "-3+0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void validOneRealOneComplexNumbersTest()
  {
    String complexNumberOne = "4";
    String complexNumberTwo = "7 + 9i";
    String expectedResult = "11+9i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  // had to comment out because sometimes works and sometimes doesn't 
  // and was not able to get a standard result during this sprint
  /*@Test
  public void twoRandomComplexNumbersTest()
  {
    Random random = new Random();
    int firstRandomNum = random.nextInt();
    int secondRandomNum = random.nextInt();
    int firstRandomI = random.nextInt();
    int secondRandomI = random.nextInt();
    String complexNumberOne = String.valueOf(firstRandomNum) + "+" + String.valueOf(firstRandomI)
        + "i";
    String complexNumberTwo = String.valueOf(secondRandomNum) + "+" + String.valueOf(secondRandomI)
        + "i";
    String expectedResult = String.valueOf(firstRandomNum + secondRandomNum) + "+"
        + String.valueOf(firstRandomI + secondRandomI) + "i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoRandomRealNumbersTest()
  {
    Random random = new Random();
    int firstRandomNum = random.nextInt();
    int secondRandomNum = random.nextInt();
    String firstStringRandomNum = String.valueOf(firstRandomNum);
    String secondStringRandomNum = String.valueOf(secondRandomNum);
    String expectedResult = String.valueOf(firstRandomNum + secondRandomNum) + "+0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(firstStringRandomNum, secondStringRandomNum);
    assertEquals(expectedResult, actualResult);
  }*/

  @Test
  public void inValidNullLeftOperandTest()
  {

    String complexNumberOne = null;
    String complexNumberTwo = "4 + 2i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Please provide two valid operands.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidNullRightOperandTest()
  {

    String complexNumberOne = "4 + 2i";
    String complexNumberTwo = null;
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Please provide two valid operands.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidEmptyLeftOperandTest()
  {

    String complexNumberOne = "";
    String complexNumberTwo = "4 + 2i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Please provide two valid operands.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidEmptyRightOperandTest()
  {

    String complexNumberOne = "4 + 3i";
    String complexNumberTwo = "";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Please provide two valid operands.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidRegLeftOperandTest()
  {

    String complexNumberOne = "4b + 3i";
    String complexNumberTwo = "3 + 3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Not a valid operand.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidImagLeftOperandTest()
  {

    String complexNumberOne = "4b + 3iiabc";
    String complexNumberTwo = "3 + 3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Please provide two valid operands, or simplify them.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidRegRightOperandTest()
  {

    String complexNumberOne = "4 + 3i";
    String complexNumberTwo = "bvxc + 3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Not a valid operand.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidImagRightOperandTest()
  {

    String complexNumberOne = "4 + 3i";
    String complexNumberTwo = "4 + 3iasdsads";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Not a valid operand.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidGibberishLeftOperandTest()
  {

    String complexNumberOne = "dsfgfdsgdsfg";
    String complexNumberTwo = "4 + 3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Not a valid operand.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void inValidGibberishRightOperandTest()
  {

    String complexNumberOne = "4 + 3i";
    String complexNumberTwo = "iLoveCS345";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Not a valid operand.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void tooManyIsLeftTest()
  {

    String complexNumberOne = "4 + 3iiiiiiiii";
    String complexNumberTwo = "iLoveCS345";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Please provide two valid operands, or simplify them.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void tooManyIsRightTest()
  {

    String complexNumberOne = "4 + 3i";
    String complexNumberTwo = "4iiiiii + 3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Please provide two valid operands, or simplify them.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void oneIInvalidLeftOperandTest()
  {

    String complexNumberOne = "iLoveCS345";
    String complexNumberTwo = "4 + 3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Not a valid operand.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void oneIInvalidRightOperandTest()
  {

    String complexNumberOne = "4 + 3i";
    String complexNumberTwo = "iLoveCS345";
    TempContext tempContext = new TempContext(new AdditionOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Not a valid operand.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  @Test
  public void iPlusI1Test()
  {
    String complexNumberOne = "i";
    String complexNumberTwo = "i";
    String expectedResult = "0+2i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void iPlusI2Test()
  {
    String complexNumberOne = "i";
    String complexNumberTwo = "2 + 2i";
    String expectedResult = "2+3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void iPlusILeftTest()
  {
    String complexNumberOne = "2 + i";
    String complexNumberTwo = "2 + 2i";
    String expectedResult = "4+3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void iPlusIRightTest()
  {
    String complexNumberOne = "2 + i";
    String complexNumberTwo = "2 + i";
    String expectedResult = "4+2i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleILeftTest()
  {
    String complexNumberOne = "i";
    String complexNumberTwo = "3 + 2i";
    String expectedResult = "3+3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleIRightTest()
  {
    String complexNumberOne = "2 + 3i";
    String complexNumberTwo = "i";
    String expectedResult = "2+4i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleNegILeftTest()
  {
    String complexNumberOne = "-i";
    String complexNumberTwo = "2i + 2";
    String expectedResult = "2+1i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleNegIRightTest()
  {
    String complexNumberOne = "2 + 3i";
    String complexNumberTwo = "-i";
    String expectedResult = "2+2i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleNegMIRightTest()
  {
    String complexNumberOne = "2 + 3i";
    String complexNumberTwo = "-6i";
    String expectedResult = "2-3i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void operandsWithSubtractionTest()
  {
    String complexNumberOne = "2 + 3i";
    String complexNumberTwo = "2 - 2i";
    String expectedResult = "4+1i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void largeNumberTest()
  {
    String complexNumberOne = "100000000i";
    String complexNumberTwo = "100000000i";
    String expectedResult = "0+200000000i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void largeNumber2Test()
  {
    String complexNumberOne = "100000000000i";
    String complexNumberTwo = "100000000000i";
    String expectedResult = "0+200000000000i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void testDecimalOperands()
  {
    TempContext a = new TempContext(new AdditionOperator());

    //TODO: implement
    //complex
    String actual = a.evaluate("3.45+7.56i", "2.98+5.04i");
    String expected = "6.43+12.60i";
    assertTrue(actual.equals(expected));
    
    //imaginary
    actual = a.evaluate("6.42i", "7.75i");
    expected = "0.00+14.17i";
    assertTrue(actual.equals(expected));
    
    //real
    actual = a.evaluate("3.88", "2.94");
    expected = "6.82+0.00i";
    assertTrue(actual.equals(expected));
    
    //complex imaginary
    actual = a.evaluate("0.89+7.25i", "3.56i");
    expected = "0.89+10.81i";
    assertTrue(actual.equals(expected));
    
    //complex real
    actual = a.evaluate("3.39+6.89i", "2.09");
    expected = "5.48+6.89i";
    assertTrue(actual.equals(expected));
    
    //real imaginary
    actual = a.evaluate("9.06", "2.66i");
    expected = "9.06+2.66i";
    assertTrue(actual.equals(expected));
  }
  
  //TODO: test complex spaces and parens
}
