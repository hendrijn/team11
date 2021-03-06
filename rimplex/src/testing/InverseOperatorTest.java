package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import operations.InverseOperator;

/**
 * Unit tests for the InverseOperator.
 * 
 * @author pgleb - team 11
 * @version Sprint 2
 */
public class InverseOperatorTest
{
  private final String empty =  "Please provide a valid operand";

  /**
   * Testing inverting on complex number.
   */
  @Test
  public void invertComplexTest1()
  {
    String operand = "2+4i";
    String expectedInverse = "0.10-0.20i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }

  /**
   * Testing inverting on complex number.
   */
  @Test
  public void invertRealTest1()
  {
    String operand = "8";
    String expectedInverse = "0.13+0.00i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }

  /**
   * Testing inverting a complex number with a minus.
   */
  @Test
  public void invertComplexTest2()
  {
    String operand = "2-3i";
    String expectedInverse = "0.15+0.23i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }

  /**
   * Testing inverting an imaginary number.
   */
  @Test
  public void invertI()
  {
    String operand = "3i";
    String expectedInverse = "0.00-0.33i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }

  /**
   * Testing inverting just i.
   */
  @Test
  public void invertI2()
  {
    String operand = "i";
    String expectedInverse = "0.00-1.00i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }

  /**
   * Testing inverting a negative real number.
   */
  @Test
  public void invertNegReal()
  {
    String operand = "-4";
    String expectedInverse = "0.25+0.00i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }
  
  /**
   * Testing inverting negative complex number.
   */
  @Test
  public void invertNegComplex()
  {
    String operand = "-4+3i";
    String expectedInverse = "-0.16-0.12i";
    InverseOperator inverseOperator = new InverseOperator();
    String actualInverse = inverseOperator.invert(operand);
    assertEquals(expectedInverse, actualInverse);
  }

  /**
   * Testing an invalid operand.
   */
  @Test
  public void invertInvalid1()
  {
    String operand = "-4+3iiii";
    InverseOperator inverseOperator = new InverseOperator();
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      inverseOperator.invert(operand);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an empty operand.
   */
  @Test
  public void invertInvalid2()
  {
    String operand = "";
    InverseOperator inverseOperator = new InverseOperator();
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      inverseOperator.invert(operand);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing a null operand.
   */
  @Test
  public void invertInvalid3()
  {
    String operand = null;
    InverseOperator inverseOperator = new InverseOperator();
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      inverseOperator.invert(operand);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * Testing an operand with extra invalid text.
   */
  @Test
  public void invertInvalid4()
  {
    String operand = "3+2asczxi";
    InverseOperator inverseOperator = new InverseOperator();
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> 
    {
      inverseOperator.invert(operand);
    });
    String expectedException = empty;
    String actualException = exception.getMessage();
    assertEquals(expectedException, actualException);
  }

  /**
   * tests for illegal arguments.
   */
  @Test
  public void testIllgealArgs()
  {
    InverseOperator inverseOperator = new InverseOperator();

    // test empty
    try
    {
      inverseOperator.invert("");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test null
    try
    {
      inverseOperator.invert(null);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test random string
    try
    {
      inverseOperator.invert("jfh3ourfh");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test space and parens
    try
    {
      inverseOperator.invert("  ()      ");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test random string with i
    try
    {
      inverseOperator.invert("ilovecs");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test two i's
    try
    {
      inverseOperator.invert("5ii");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }
}
