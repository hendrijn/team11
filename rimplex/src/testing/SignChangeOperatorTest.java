package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.SignChangeOperator;

class SignChangeOperatorTest
{

  @Test
  public void testIllgealArgs()
  {
    SignChangeOperator s = new SignChangeOperator();

    try
    {
      String actual = s.changeSign("");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    try
    {
      String actual = s.changeSign(null);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    try
    {
      String actual = s.changeSign("jfh3ourfh");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    try
    {
      String actual = s.changeSign("  ()      ");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
  }
  
  @Test
  public void testChangeSignComplex()
  {
    SignChangeOperator s = new SignChangeOperator();
    
    // positive complex
    String actual = s.changeSign("6+3i");
    String expected = "-6-3i";
    assertTrue(expected.equals(actual));
    
    // negative complex
    actual = s.changeSign("-3-2i");
    expected = "3+2i";
    assertTrue(expected.equals(actual));
  
    // complex with negative real positive imaginary
    actual = s.changeSign("-6+i");
    expected = "6-i";
    assertTrue(expected.equals(actual));
    
    // complex with positive real negative imaginary
    actual = s.changeSign("8-3i");
    expected = "-8+3i";
    assertTrue(expected.equals(actual));
  }
  
  @Test
  public void testChangeSignImaginary()
  {
    SignChangeOperator s = new SignChangeOperator();
    
    // positive
    String actual = s.changeSign("2i");
    String expected = "-2i";
    assertTrue(expected.equals(actual));
    
    // negative
    actual = s.changeSign("-4i");
    expected = "4i";
    assertTrue(expected.equals(actual)); 
  }
  
  @Test
  public void testChangeSignReal()
  {
    SignChangeOperator s = new SignChangeOperator();
    
    // positive
    String actual = s.changeSign("7");
    String expected = "-7";
    assertTrue(expected.equals(actual));
    
    // negative
    actual = s.changeSign("-9");
    expected = "9";
    assertTrue(expected.equals(actual));
  }
}
