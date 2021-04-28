package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import operations.ImaginaryPartOperator;

/**
 * Unit Tests for the ImaginaryPartOperator class.
 * 
 * @author may4sa - team 11
 * @version Sprint 3
 */
public class ImaginaryPartOperatorTest
{
  private final String imagZero = "0.00i";
  
  /**
   * tests for operands with spaces.
   */
  @Test
  public void testSpaces()
  {
    ImaginaryPartOperator i = new ImaginaryPartOperator();
 
    // complex
    String actual = i.evaluate("8 +     3    i");
    String expected = "3.00i";
    assertTrue(actual.equals(expected));

    // real
    actual = i.evaluate("   9     ");
    expected = imagZero;
    assertTrue(actual.equals(expected));

    // imaginary
    actual = i.evaluate("   2    i   ");
    expected = "2.00i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for illegal arguments (operands that are not real, imaginary, or complex numbers.
   */
  @Test
  public void testIllegalArgs()
  {
    ImaginaryPartOperator i = new ImaginaryPartOperator();

    // just parens
    try
    {
      i.evaluate("()");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // empty
    try
    {
      i.evaluate("");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // null
    try
    {
      i.evaluate(null);
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // string
    try
    {
      i.evaluate("jnvu4ifho");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // multi is
    try
    {
      i.evaluate("4iii");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // ilovecs
    try
    {
      i.evaluate("ilovecs");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  /**
   * tests for real operands.
   */
  @Test
  public void testReal()
  {
    ImaginaryPartOperator i = new ImaginaryPartOperator();

    // positive
    String actual = i.evaluate("2");
    String expected = imagZero;
    assertTrue(actual.equals(expected));

    // negative
    actual = i.evaluate("-4");
    expected = imagZero;
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for imaginary operands.
   */
  @Test
  public void testImaginary()
  {
    ImaginaryPartOperator i = new ImaginaryPartOperator();

    // positive
    String actual = i.evaluate("9i");
    String expected = "9.00i";
    assertTrue(actual.equals(expected));

    // negative
    actual = i.evaluate("-7i");
    expected = "-7.00i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for complex operands.
   */
  @Test
  public void testComplex()
  {
    ImaginaryPartOperator i = new ImaginaryPartOperator();

    // positive
    String actual = i.evaluate("3+5i");
    String expected = "5.00i";
    assertTrue(actual.equals(expected));

    // negative
    actual = i.evaluate("-9-3i");
    expected = "-3.00i";
    assertTrue(actual.equals(expected));

    // positive real, negative imaginary
    actual = i.evaluate("8-2i");
    expected = "-2.00i";
    assertTrue(actual.equals(expected));

    // negative real, positive imaginary
    actual = i.evaluate("-4+6i");
    expected = "6.00i";
    assertTrue(actual.equals(expected));
  }
}
