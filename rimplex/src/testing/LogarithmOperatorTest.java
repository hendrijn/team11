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
    String actual = l.evalulate(" 7    + 9     i ");
    String expected = "log(7+9i)";
    assertTrue(actual.equals(expected));

    // real
    actual = l.evalulate("  4      ");
    expected = "0.60";
    assertTrue(actual.equals(expected));

    // imaginary
    actual = l.evalulate("  8      i      ");
    expected = "log(8i)";
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
      String actual = l.evalulate("");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // null
    try
    {
      String actual = l.evalulate(null);
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // string
    try
    {
      String actual = l.evalulate("vhjb3yito");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // multi i's
    try
    {
      String actual = l.evalulate("6ii");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // ilovecs
    try
    {
      String actual = l.evalulate("ilovecs");
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

    String actual = l.evalulate("18");
    String expected = "1.26";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests an imaginary operand.
   */
  @Test
  public void testImaginary()
  {
    LogarithmOperator l = new LogarithmOperator();

    String actual = l.evalulate("4i");
    String expected = "log(4i)";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests a complex operand.
   */
  @Test
  public void testComplex()
  {
    LogarithmOperator l = new LogarithmOperator();

    String actual = l.evalulate("3+7i");
    String expected = "log(3+7i)";
    assertTrue(actual.equals(expected));
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
      String actual = l.evalulate("-7");
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
      String actual = l.evalulate("0");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    try
    {
      String actual = l.evalulate("0.00");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }
}
