package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import operations.ConjugateOperator;

/**
 * Unit Tests for the ConjugateOperator.
 * 
 * @author may4sa - team11
 * @version Sprint 3
 */
class ConjugateOperatorTest
{

  /**
   * tests for Illegal Arguments.
   */
  @Test
  public void testIllegalArgs()
  {
    ConjugateOperator c = new ConjugateOperator();

    // null
    try
    {
      c.conjugate(null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // empty
    try
    {
      c.conjugate("");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // just parens
    try
    {
      c.conjugate("   ()");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // string
    try
    {
      c.conjugate("rogphusdnjivbuo");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // two i's
    try
    {
      c.conjugate("5ii");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // i in an illegal string
    try
    {
      c.conjugate("ilovecs");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
  }

  /**
   * tests the change from positive to negative.
   */
  @Test
  public void testPlusToMinus()
  {
    ConjugateOperator c = new ConjugateOperator();

    // all positive
    String actual = c.conjugate("3+7i");
    String expected = "3-7i";
    assertTrue(actual.equals(expected));

    // negative real, positive imaginary
    actual = c.conjugate("-9+5i");
    expected = "-9-5i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests change from negative to positive.
   */
  @Test
  public void testMinustoPlus()
  {
    ConjugateOperator c = new ConjugateOperator();

    // all negative
    String actual = c.conjugate("-2-6i");
    String expected = "-2+6i";
    assertTrue(actual.equals(expected));

    // positive real, negative imaginary
    actual = c.conjugate("4-8i");
    expected = "4+8i";
    assertTrue(actual.equals(expected));
  }
}
