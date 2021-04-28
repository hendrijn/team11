package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import operations.RealPartOperator;

/**
 * Unit Tests for the RealPartOperator class.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
public class RealPartOperatorTest
{
  private final String decimalZero = "0.00";
  private final String decimalNegTwo = "-2.00";
  
  /**
   * tests for operands with spaces.
   */
  @Test
  public void testSpaces()
  {
    RealPartOperator r = new RealPartOperator();

    // complex
    String actual = r.evaluate("    7 +     9       i");
    String expected = "7.00";
    assertTrue(actual.equals(expected));

    // real
    actual = r.evaluate("    4    ");
    expected = "4.00";
    assertTrue(actual.equals(expected));

    // imaginary
    actual = r.evaluate("  6  i    ");
    expected = decimalZero;
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for illegal arguments (operands that are not real, imaginary, or complex numbers.
   */
  @Test
  public void testIllegalArgs()
  {
    RealPartOperator r = new RealPartOperator();

    // just parens
    try
    {
      r.evaluate("()");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // empty
    try
    {
      r.evaluate("");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // null
    try
    {
      r.evaluate(null);
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // string
    try
    {
      r.evaluate("nsdbciwsjkvbq");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // multi is
    try
    {
      r.evaluate("5iii");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // ilovecs
    try
    {
      r.evaluate("ilovecs");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  /**
   * tests for real opeands.
   */
  @Test
  public void testReal()
  {
    RealPartOperator r = new RealPartOperator();

    // positive
    String actual = r.evaluate("6");
    String expected = "6.00";
    assertTrue(actual.equals(expected));

    // negative
    actual = r.evaluate("-2");
    expected = decimalNegTwo;
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for imaginary operands.
   */
  @Test
  public void testImaginary()
  {
    RealPartOperator r = new RealPartOperator();

    // positive
    String actual = r.evaluate("7i");
    String expected = decimalZero;
    assertTrue(actual.equals(expected));

    // negative
    actual = r.evaluate("-9i");
    expected = decimalZero;
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for complex operands.
   */
  @Test
  public void testComplex()
  {
    RealPartOperator r = new RealPartOperator();

    // positive
    String actual = r.evaluate("3+5i");
    String expected = "3.00";
    assertTrue(actual.equals(expected));

    // negative
    actual = r.evaluate("-2-6i");
    expected = decimalNegTwo;
    assertTrue(actual.equals(expected));

    // positive real, negative imaginary
    actual = r.evaluate("9-8i");
    expected = "9.00";
    assertTrue(actual.equals(expected));

    // negative real, positive imaginary
    actual = r.evaluate("-4+3i");
    expected = "-4.00";
    assertTrue(actual.equals(expected));
  }
}
