package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import operations.AdditionOperator;
import operations.MultiplicationOperator;
import operations.TempContext;

class MultiplicationOperatorTesting
{

  @Test
  public void twoValidComplexNumbersTest()
  {
    String complexNumberOne = "3 + 2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "8.0+14.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidRealNumTest()
  {
    String complexNumberOne = "3";
    String complexNumberTwo = "4";
    String expectedResult = "12.0+0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  
  @Test
  public void twoValidComplexNumMix1Test()
  {
    String complexNumberOne = "3 + 2i";
    String complexNumberTwo = "4";
    String expectedResult = "12.0+8.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidComplexNumMix2Test()
  {
    String complexNumberOne = "6";
    String complexNumberTwo = "4i + 4";
    String expectedResult = "24.0+24.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidZero1Test()
  {
    String complexNumberOne = "6";
    String complexNumberTwo = "0";
    String expectedResult = "0.0+0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidZero2Test()
  {
    String complexNumberOne = "0";
    String complexNumberTwo = "3i+2";
    String expectedResult = "0.0+0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  
  @Test
  public void twoValidZero3Test()
  {
    String complexNumberOne = "i";
    String complexNumberTwo = "0";
    String expectedResult = "0.0+0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidComplexNumI1Test()
  {
    String complexNumberOne = "i";
    String complexNumberTwo = "i";
    String expectedResult = "-1.0+0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidComplexNumI2Test()
  {
    String complexNumberOne = "2i";
    String complexNumberTwo = "15i";
    String expectedResult = "-30.0+0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  
//  @Test
//  public void twoRandomRealNumTest()
//  {
//    Random random = new Random();
//    int firstRandomNum = random.nextInt();
//    int secondRandomNum = random.nextInt();
//    String firstStringRandomNum = String.valueOf(firstRandomNum);
//    String secondStringRandomNum = String.valueOf(secondRandomNum);
//    String expectedResult = String.valueOf(firstRandomNum * secondRandomNum) + "+0i";
//    TempContext tempContext = new TempContext(new MultiplicationOperator());
//    String actualResult = tempContext.evaluate(firstStringRandomNum, secondStringRandomNum);
//    assertEquals(expectedResult, actualResult);
//    
//  }
  
  @Test
  public void inValidNullLeftOperandTest()
  {

    String complexNumberOne = null;
    String complexNumberTwo = "4 + 2i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
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
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      tempContext.evaluate(complexNumberOne, complexNumberTwo);
    });
    String expectedException = "Not a valid operand.";
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }
  
  @Test
  public void twoValidComplexNumbersNeg1Test()
  {
    String complexNumberOne = "3 - 2i";
    String complexNumberTwo = "4 + 2i";
    String expectedResult = "16.0-2.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidComplexNumbersNeg2Test()
  {
    String complexNumberOne = "3 + 2i";
    String complexNumberTwo = "4 - 2i";
    String expectedResult = "16.0+2.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidComplexNumbersNeg3Test()
  {
    String complexNumberOne = "3 - 2i";
    String complexNumberTwo = "4 - 2i";
    String expectedResult = "8.0-14.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidRegNumbersNeg1Test()
  {
    String complexNumberOne = "-300";
    String complexNumberTwo = "400";
    String expectedResult = "-120000.0+0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidRegNumbersNeg2Test()
  {
    String complexNumberOne = "300";
    String complexNumberTwo = "-400";
    String expectedResult = "-120000.0+0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidRegNumbersNeg3Test()
  {
    String complexNumberOne = "-300";
    String complexNumberTwo = "-400";
    String expectedResult = "120000.0-0.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidMixedNumbersNeg1Test()
  {
    String complexNumberOne = "-300 + 4i";
    String complexNumberTwo = "400";
    String expectedResult = "-120000.0+1600.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidMixedNumbersNeg2Test()
  {
    String complexNumberOne = "20";
    String complexNumberTwo = "400 - 3i";
    String expectedResult = "8000.0-60.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoValidMixedNumbersNeg3Test()
  {
    String complexNumberOne = "-20";
    String complexNumberTwo = "400 - 3i";
    String expectedResult = "-8000.0+60.0i";
    TempContext tempContext = new TempContext(new MultiplicationOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  
  @Test
  public void testDecimalOperands2()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("6.42i", "7.75i");
    String expected = "-49.755+0.0i";
    assertEquals(expected, actual);
  } 
  
  
  @Test
  public void testDecimalOperands3()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("3.88", "2.94");
    String expected = "11.4072+0.0i";
    assertEquals(expected, actual);
  } 
  
  @Test
  public void testDecimalOperands4()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("0.89+7.25i", "3.56i");
    String expected = "-25.81+3.1684i";
    assertEquals(expected, actual);
  } 
  
  
  @Test
  public void testDecimalOperands5()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("3.39+6.89i", "2.09");
    String expected = "7.0851+14.400099999999998i";
    assertEquals(expected, actual);
  } 
  
  @Test
  public void testDecimalOperands6()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("9.06", "2.66i");
    String expected = "0.0+24.099600000000002i";
    assertEquals(expected, actual);
  } 
  
  @Test
  public void testNegComplex()
  {
    TempContext a = new TempContext(new MultiplicationOperator());
    String actual = a.evaluate("-3+5i", "-4-2i");
    String expected = "22.0-14.0i";
    System.out.println(actual);
    assertEquals(expected, actual);
  }

}
