package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.InverseOperator;
import operations.TempContext;

class InverseOperatorTest
{

  @Test
  public void invertComplexTest1()
  {
    String operand = "2+4i";
    String expectedInverse = "0.1-0.2i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }
  
  
  @Test
  public void invertRealTest1()
  {
    String operand = "8";
    String expectedInverse = "0.125";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }
  
  @Test
  public void invertComplexTest2()
  {
    String operand = "2-3i";
    String expectedInverse = "14.5-3.75i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }

}
