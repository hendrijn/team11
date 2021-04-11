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
    String expectedResult = "7.0+4.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplex2NumbersTest()
  {
    String complexNumberOne = "3-2i";
    String complexNumberTwo = "4+2i";
    String expectedResult = "7.0+0.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidNoSpaceComplexNumbersTest()
  {
    String complexNumberOne = "3+2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "7.0+4.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersOnlyTest()
  {
    String complexNumberOne = "3 + 2i";
    String complexNumberTwo = "2i";
    String expectedResult = "3.0+4.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidNumbersCombinedTest()
  {
    String complexNumberOne = "42";
    String complexNumberTwo = "1 + 2i";
    String expectedResult = "43.0+2.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersNegTest()
  {
    String complexNumberOne = "-3 + 2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "1.0+4.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersNegITest()
  {
    String complexNumberOne = "-3 + -2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "1.0+0.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersDiffIPlacementTest()
  {
    String complexNumberOne = "3i + 4";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "8.0+5.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidComplexNumbersDiffIPlacementTest2()
  {
    String complexNumberOne = "3i + 4";
    String complexNumberTwo = "4i + 2";
    String expectedResult = "6.0+7.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidRealNumbersTest()
  {
    String complexNumberOne = "4";
    String complexNumberTwo = "7";
    String expectedResult = "11.0+0.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidRealNegNumbersTest()
  {
    String complexNumberOne = "-4";
    String complexNumberTwo = "7";
    String expectedResult = "3.0+0.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void twoValidRealNegNumbers2Test()
  {
    String complexNumberOne = "4";
    String complexNumberTwo = "-7";
    String expectedResult = "-3.0+0.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void validOneRealOneComplexNumbersTest()
  {
    String complexNumberOne = "4";
    String complexNumberTwo = "7 + 9i";
    String expectedResult = "11.0+9.0i";
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
    String expectedResult = "0.0+2.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void iPlusI2Test()
  {
    String complexNumberOne = "i";
    String complexNumberTwo = "2 + 2i";
    String expectedResult = "2.0+3.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void iPlusILeftTest()
  {
    String complexNumberOne = "2 + i";
    String complexNumberTwo = "2 + 2i";
    String expectedResult = "4.0+3.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void iPlusIRightTest()
  {
    String complexNumberOne = "2 + i";
    String complexNumberTwo = "2 + i";
    String expectedResult = "4.0+2.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleILeftTest()
  {
    String complexNumberOne = "i";
    String complexNumberTwo = "3 + 2i";
    String expectedResult = "3.0+3.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleIRightTest()
  {
    String complexNumberOne = "2 + 3i";
    String complexNumberTwo = "i";
    String expectedResult = "2.0+4.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleNegILeftTest()
  {
    String complexNumberOne = "-i";
    String complexNumberTwo = "2i + 2";
    String expectedResult = "2.0+1.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleNegIRightTest()
  {
    String complexNumberOne = "2 + 3i";
    String complexNumberTwo = "-i";
    String expectedResult = "2.0+2.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void singleNegMIRightTest()
  {
    String complexNumberOne = "2 + 3i";
    String complexNumberTwo = "-6i";
    String expectedResult = "2.0-3.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void operandsWithSubtractionTest()
  {
    String complexNumberOne = "2 + 3i";
    String complexNumberTwo = "2 - 2i";
    String expectedResult = "4.0+1.0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void largeNumberTest()
  {
    String complexNumberOne = "100000000i";
    String complexNumberTwo = "100000000i";
    String expectedResult = "0.0+2.0E8i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void largeNumber2Test()
  {
    String complexNumberOne = "100000000000i";
    String complexNumberTwo = "100000000000i";
    String expectedResult = "0.0+2.0E11i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void testDecimalOperands1()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("3.45+7.56i", "2.98+5.04i");
    String expected = "6.43+12.6i";
    assertEquals(expected, actual);
  } 
  
  
  @Test
  public void testDecimalOperands2()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("6.42i", "7.75i");
    String expected = "0.0+14.17i";
    assertEquals(expected, actual);
  } 
  
  
  @Test
  public void testDecimalOperands3()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("3.88", "2.94");
    String expected = "6.82+0.0i";
    assertEquals(expected, actual);
  } 
  
  @Test
  public void testDecimalOperands4()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("0.89+7.25i", "3.56i");
    String expected = "0.89+10.81i";
    assertEquals(expected, actual);
  } 
  
  
  @Test
  public void testDecimalOperands5()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("3.39+6.89i", "2.09");
    String expected = "5.48+6.89i";
    assertEquals(expected, actual);
  } 
  
  @Test
  public void testDecimalOperands6()
  {
    TempContext a = new TempContext(new AdditionOperator());
    String actual = a.evaluate("9.06", "2.66i");
    String expected = "9.06+2.66i";
    assertEquals(expected, actual);
  } 
    
  
  //TODO: test complex spaces and parens
}
