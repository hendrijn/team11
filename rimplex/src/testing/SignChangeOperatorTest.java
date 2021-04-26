package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.SignChangeOperator;

/**
 * Unit tests for SignChangeOperator.
 * 
 * @author may4sa - team11
 * @version Sprint 3
 */
class SignChangeOperatorTest
{
  /**
   * test constructor for full coverage.
   */
  @Test
  public void testConstruction()
  {
    new SignChangeOperator();
  }

  /**
   * tests for Illegal Arguements.
   */
  @Test
  public void testIllgealArgs()
  {
    // test empty
    try
    {
      SignChangeOperator.changeSign("");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test null
    try
    {
      SignChangeOperator.changeSign(null);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test random string
    try
    {
      SignChangeOperator.changeSign("jfh3ourfh");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test space and parens
    try
    {
      SignChangeOperator.changeSign("  ()      ");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test random string with i
    try
    {
      SignChangeOperator.changeSign("ilovecs");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // test two i's
    try
    {
      SignChangeOperator.changeSign("5ii");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  /**
   * tests sign change with complex operand.
   */
  @Test
  public void testChangeSignComplex()
  {
    // positive complex
    String actual = SignChangeOperator.changeSign("6+3i");
    String expected = "(-6-3i)";
    assertTrue(expected.equals(actual));

    // negative complex
    actual = SignChangeOperator.changeSign("-3-2i");
    expected = "(3+2i)";
    assertTrue(expected.equals(actual));

    // complex with negative real positive imaginary
    actual = SignChangeOperator.changeSign("-6+i");
    expected = "(6-i)";
    assertTrue(expected.equals(actual));

    // complex with positive real negative imaginary
    actual = SignChangeOperator.changeSign("8-3i");
    expected = "(-8+3i)";
    assertTrue(expected.equals(actual));
  }

  /**
   * tests sign change with imaginary operand.
   */
  @Test
  public void testChangeSignImaginary()
  {
    // positive
    String actual = SignChangeOperator.changeSign("2i");
    String expected = "-2i";
    assertTrue(expected.equals(actual));

    // negative
    actual = SignChangeOperator.changeSign("-4i");
    expected = "4i";
    assertTrue(expected.equals(actual));
  }

  /**
   * tests sign change with real operand.
   */
  @Test
  public void testChangeSignReal()
  {
    // positive
    String actual = SignChangeOperator.changeSign("7");
    String expected = "-7";
    assertTrue(expected.equals(actual));

    // negative
    actual = SignChangeOperator.changeSign("-9");
    expected = "9";
    assertTrue(expected.equals(actual));
  }

  /**
   * test only i operand.
   */
  @Test
  public void justI()
  {
    String actual = SignChangeOperator.changeSign("i");
    String expected = "-i";
    assertTrue(expected.equals(actual));
  }
}
