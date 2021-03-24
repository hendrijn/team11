package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Subtraction;
/**
 * Unit tests for the Subtraction class.
 * 
 * @author may4sa
 * @version Sprint 1
 */
class SubtractionTest
{

  @Test
  void testCalculation()
  {
    Subtraction s = new Subtraction();
      /* 
        additions to make
          complex num:
            negative number cases
            operands without numbers
            
          real num adds:
            null cases
            empty operands 
            operands without numbers
            
          both:
            cases with one complex one real
            cases with one imaginary one real
      */
    
    /* complex numbers and imaginary numbers*/
    
    //both operands null
    try 
    {
      String bothNull = s.calculate(null, null);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
    
    //first operand null
    String actual = s.calculate(null, "3i");
    String expected = "0-3i";
    assertTrue(expected.equals(actual));
    
    //second operand null
    actual = s.calculate("5i", null);
    expected = "0+5i";
    assertTrue(expected.equals(actual));
    
    //both operands empty
    try 
    {
      String empty = s.calculate("", "");
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
    
    //first operand empty
    actual = s.calculate("", "3i");
    expected = "0-3i";
    assertTrue(expected.equals(actual));
    
    //second operand empty
    actual = s.calculate("5i", "");
    expected = "0+5i";
    assertTrue(expected.equals(actual));
    
    //no added terms, positive result from subtraction
    actual = s.calculate("5i", "3i");
    expected = "0+2i";
    assertTrue(expected.equals(actual));
    
    //positive summing added terms, positive result from subtraction
    actual = s.calculate("5i + 4", "3i + 2");
    expected = "2+2i ";
    assertTrue(expected.equals(actual));
    
    //no added terms, negative result from subtraction
    actual = s.calculate("4i", "9i");
    expected = "0-5i";
    assertTrue(expected.equals(actual));
    
    //positive summing added terms, negative result from subtraction
    actual = s.calculate("4i + 4", "9i + 2");
    expected = "6-5i";
    assertTrue(expected.equals(actual));
    
    //negative summing added terms, negative result from subtraction
    actual = s.calculate("4i + 6", "9i + 9");
    expected = "-3-5i";
    assertTrue(expected.equals(actual));
    
    //negative summing added terms, positive result from subtraction
    actual = s.calculate("9i + 6", "4i + 9");
    expected = "-3+5i";
    assertTrue(expected.equals(actual));
    
    /* real numbers */
    
    //both positive, positive result
    actual = s.calculate("35", "12");
    expected = "23+0i";
    assertTrue(expected.equals(actual));
    
    //both positive, negative result
    actual = s.calculate("15", "45");
    expected = "-30+0i";
    assertTrue(expected.equals(actual));
    
    //negative first operand, positive result
    actual = s.calculate("-25", "69");
    expected = "44+0i";
    assertTrue(expected.equals(actual));
    
    //negative first operand, negative result
    actual = s.calculate("-55", "15");
    expected = "-70+0i";
    assertTrue(expected.equals(actual));
    
    //negative second operand, positive result
    actual = s.calculate("63", "-45");
    expected = "108+0i";
    assertTrue(expected.equals(actual));
    
    //negative second operand, negative result (this might be impossible)
    /*actual = s.calculate("17", "?");
    expected = "-11+0i";
    assertTrue(expected.equals(actual));*/
    
    //both negative, positive result
    actual = s.calculate("-57", "-68");
    expected = "11+0i";
    assertTrue(expected.equals(actual));
    
    //both negative, negative result
    actual = s.calculate("-96", "-42");
    expected = "-54+0i";
    assertTrue(expected.equals(actual));
  }

}
