package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

}
