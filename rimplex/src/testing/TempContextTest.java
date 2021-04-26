package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.SubtractionOperator;
import operations.TempContext;

/**
 * Unit tests for the Temp Context Class.
 * 
 * @author team 11 - may4sa
 * @version Sprint 3
 */
class TempContextTest
{

  /**
   * tests for the format class.
   */
  @Test
  public void testFormat()
  {
    //without parens
    String actual = TempContext.format("3-6i");
    String expected = "3+-6i";
    assertTrue(actual.equals(expected));

    actual = TempContext.format("3+6i");
    expected = "3+6i";
    assertTrue(actual.equals(expected));

    actual = TempContext.format("3");
    expected = "3+0.00i";
    assertTrue(actual.equals(expected));

    actual = TempContext.format("3i");
    expected = "0.00+3i";
    assertTrue(actual.equals(expected));

    actual = TempContext.format("-3");
    expected = "-3+0.00i";
    assertTrue(actual.equals(expected));

    actual = TempContext.format("-3i");
    expected = "0.00+-3i";
    assertTrue(actual.equals(expected));
    
    //with parens
    actual = TempContext.format("(3-6i)");
    expected = "3+-6i";
    assertTrue(actual.equals(expected));

    actual = TempContext.format("(3+6i)");
    expected = "3+6i";
    assertTrue(actual.equals(expected));
  }

  //should at some point test other methods in tempContext
}
