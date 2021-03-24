package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

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
    String expectedResult = "7 + 4i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  
  @Test
  public void twoValidRealNumbersTest()
  {
    String complexNumberOne = "4";
    String complexNumberTwo = "7";
    String expectedResult = "7 + 0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(complexNumberOne, complexNumberTwo);
    assertEquals(expectedResult, actualResult);
  }
  
  @Test
  public void twoRandomComplexNumbersTest()
  {
    Random random = new Random();
    int firstRandomNum = random.nextInt();
    int secondRandomNum = random.nextInt();
    int firstRandomI = random.nextInt();
    int secondRandomI = random.nextInt();
    String complexNumberOne = String.valueOf(firstRandomNum) + " + " 
        + String.valueOf(firstRandomI) + "i";
    String complexNumberTwo = String.valueOf(secondRandomNum) + " + " 
        + String.valueOf(secondRandomI) + "i";
    String expectedResult = String.valueOf(firstRandomNum + secondRandomNum) + 
        " + " + String.valueOf(firstRandomI + secondRandomI) + "i";
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
    String expectedResult = String.valueOf(firstRandomNum + secondRandomNum) + 
        " + 0i";
    TempContext tempContext = new TempContext(new AdditionOperator());
    String actualResult = tempContext.evaluate(firstStringRandomNum, secondStringRandomNum);
    assertEquals(expectedResult, actualResult);
  }

}
