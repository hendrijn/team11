package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.ConjugateOperator;
import operations.TempContext;

class ConjugateOperatorTest
{

  @Test
  public void testIllegalArgs()
  {
    ConjugateOperator c = new ConjugateOperator();

    try
    {
      String bothNull = c.conjugate(null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
    
    try
    {
      String empty = c.conjugate("");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
    
    try
    {
      String emptyParen = c.conjugate("   ()");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
    
    try
    {
      String random = c.conjugate("rogphusdnjivbuo");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
    
    try
    {
      String doubleI = c.conjugate("5ii");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
    
    try
    {
      String iString = c.conjugate("ilovecs");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
    
  }
  
  @Test
  public void testPlusToMinus()
  {
    ConjugateOperator c = new ConjugateOperator();
    
    //all positive
    String actual = c.conjugate("3+7i");
    String expected = "3-7i";
    assertTrue(actual.equals(expected));
    
    //negative real, positive imaginary
    actual = c.conjugate("-9+5i");
    expected = "-9-5i";
    assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testMinustoPlus()
  {
    ConjugateOperator c = new ConjugateOperator();

    //all negative
    String actual = c.conjugate("-2-6i");
    String expected = "-2+6i";
    assertTrue(actual.equals(expected));
    
    //positive real, negative imaginary
    actual = c.conjugate("4-8i");
    expected = "4+8i";
    assertTrue(actual.equals(expected));
  }

}
