package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.SignChangeOperator;

class SignChangeOperatorTest
{

  @Test
  public void testIllgealArgs()
  {
   

    try
    {
      String actual = SignChangeOperator.changeSign("");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    try
    {
      String actual = SignChangeOperator.changeSign(null);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    /*try
    {
      String actual = s.changeSign("jfh3ourfh");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }*/
    
    try
    {
      String actual = SignChangeOperator.changeSign("  ()      ");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    /*try
    {
      String actual = s.changeSign("ilovecs");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }*/
    
    try
    {
      String actual = SignChangeOperator.changeSign("5ii");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    
    
  }
  
  @Test
  public void testChangeSignComplex()
  {
   
    
    // positive complex
    String actual = SignChangeOperator.changeSign("6+3i");
    String expected = "-6-3i";
    assertTrue(expected.equals(actual));
    
    // negative complex
    actual = SignChangeOperator.changeSign("-3-2i");
    expected = "3+2i";
    assertTrue(expected.equals(actual));
  
    // complex with negative real positive imaginary
    actual = SignChangeOperator.changeSign("-6+i");
    expected = "6-i";
    assertTrue(expected.equals(actual));
    
    // complex with positive real negative imaginary
    actual = SignChangeOperator.changeSign("8-3i");
    expected = "-8+3i";
    assertTrue(expected.equals(actual));
  }
  
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
}
