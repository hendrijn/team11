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
    
    /* complex numbers and imaginary numbers*/
    //no added terms, positive result from subtraction
    String actual = s.calculate("5i", "3i");
    String expected = "2i + 0";
    assertTrue(expected.equals(actual));
    
    //positive summing added terms, positive result from subtraction
    actual = s.calculate("5i + 4", "3i + 2");
    expected = "2i + 2 ";
    assertTrue(expected.equals(actual));
    
    //no added terms, negative result from subtraction
    actual = s.calculate("4i", "9i");
    expected = "-5i + 0";
    assertTrue(expected.equals(actual));
    
    //positive summing added terms, negative result from subtraction
    actual = s.calculate("4i + 4", "9i + 2");
    expected = "-5i + 6";
    assertTrue(expected.equals(actual));
    
    //negative summing added terms, negative result from subtraction
    actual = s.calculate("4i + 6", "9i + 9");
    expected = "-5i - 3";
    assertTrue(expected.equals(actual));
    
    //negative summing added terms, positive result from subtraction
    actual = s.calculate("9i + 6", "4i + 9");
    expected = "5i - 3";
    assertTrue(expected.equals(actual));
    
    /* real numbers */
    
    
    
    
  }

}
