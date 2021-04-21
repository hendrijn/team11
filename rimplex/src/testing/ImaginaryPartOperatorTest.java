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
class ImaginaryPartOperatorTest
{
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
    expected = "0.00i";
    assertTrue(actual.equals(expected));
    
    // imaginary
    actual = i.evaluate("   2    i   ");
    expected = "2.00i";
    assertTrue(actual.equals(expected));
  }

  @Test
  public void testIllegalArgs()
  {
    ImaginaryPartOperator i = new ImaginaryPartOperator();
    
    // empty
    try
    {
      String actual = i.evaluate("");
      assertTrue(false);
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    // null
    try
    {
      String actual = i.evaluate(null);
      assertTrue(false);
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    // string
    try
    {
      String actual = i.evaluate("jnvu4ifho");
      assertTrue(false);
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    // multi is
    try
    {
      String actual = i.evaluate("4iii");
      assertTrue(false);
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    // ilovecs
    try
    {
      String actual = i.evaluate("ilovecs");
      assertTrue(false);
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  public void testReal()
  {
    ImaginaryPartOperator i = new ImaginaryPartOperator();
    
    // positive
    String actual = i.evaluate("2");
    String expected = "0.00i";
    assertTrue(actual.equals(expected));
    
    // negative
    actual = i.evaluate("-4");
    expected = "0.00i";
    assertTrue(actual.equals(expected));
  }

  @Test
  public void testImaginary()
  {
    ImaginaryPartOperator i = new ImaginaryPartOperator();
    
    // positive
    String actual = i.evaluate("9i");
    String expected = "9.00i";
    assertTrue(actual.equals(expected));
    
    // negative
    actual = i.evaluate("-7");
    expected = "-7.00i";
    assertTrue(actual.equals(expected));
  }

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
