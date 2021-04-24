package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.LogarithmOperator;

/**
 * Unit Tests for the LogarithmOperator class.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
class LogarithmOperatorTest
{
  /**
   * test operands with extra spaces.
   */
  @Test
  public void testSpaces()
  {
    LogarithmOperator l = new LogarithmOperator();

    // complex
    String actual = l.log(" 7    + 9     i ");
    String expected = "ln(7.00+9.00i)";
    assertTrue(actual.equals(expected));

    // real
    actual = l.log("  4      ");
    expected = "1.39";
    assertTrue(actual.equals(expected));

    // imaginary
    actual = l.log("  8      i      ");
    expected = "ln(8.00i)";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for illegal arguments (operands that are not real, imaginary, or complex numbers.
   */
  @Test
  public void testIllegalArgs()
  {
    LogarithmOperator l = new LogarithmOperator();

    // empty
    try
    {
      String actual = l.log("");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // null
    try
    {
      String actual = l.log(null);
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // string
    try
    {
      String actual = l.log("vhjb3yito");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // multi i's
    try
    {
      String actual = l.log("6ii");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // ilovecs
    try
    {
      String actual = l.log("ilovecs");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  /**
   * tests a real operand.
   */
  @Test
  public void testReal()
  {
    LogarithmOperator l = new LogarithmOperator();

    String actual = l.log("18");
    String expected = "2.89";
    assertEquals(actual, expected);
  }

  /**
   * tests an imaginary operand.
   */
  @Test
  public void testImaginary()
  {
    LogarithmOperator l = new LogarithmOperator();

    String actual = l.log("4i");
    String expected = "ln(4.00i)";
    assertEquals(actual, expected);
    
    
  }

  /**
   * tests a complex operand.
   */
  @Test
  public void testComplex()
  {
    LogarithmOperator l = new LogarithmOperator();

    String actual = l.log("3+7i");
    String expected = "ln(3.00+7.00i)";
    assertEquals(actual, expected);
  }

  /**
   * tests a negative operand.
   */
  @Test
  public void testNegative()
  {
    LogarithmOperator l = new LogarithmOperator();

    try
    {
      String actual = l.log("-7i");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  /**
   * tests a zero operand.
   */
  @Test
  public void testZero()
  {
    LogarithmOperator l = new LogarithmOperator();

    try
    {
      String actual = l.log("0");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    try
    {
      String actual = l.log("0.00");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    try
    {
      String actual = l.log("-0.00");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }
}
