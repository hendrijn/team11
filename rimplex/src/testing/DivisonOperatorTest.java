package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.DivisionOperator;

class DivisonOperatorTest
{

  @Test
  public void testComplex()
  {
    DivisionOperator d = new DivisionOperator();
    
    //both positive
    String actual = d.evaluate("2+3i", "5+3i");
    String expected = "0.56+0.26i";
    assertTrue(actual.equals(expected));
    
    //both negative
    actual = d.evaluate("-6-3i", "-7-8i");
    expected = "-0.59-0.24i";
    assertTrue(actual.equals(expected));
    
    //first positive real, negative imaginary; second all positive
    actual = d.evaluate("8-2i", "4+9i");
    expected = "0.14-0.82i";
    assertTrue(actual.equals(expected));
    
    //negative real, positive imaginary; second all positive
    actual = d.evaluate("-7+3i", "2+8i");
    expected = "0.15+0.91i";
    assertTrue(actual.equals(expected));
    
    //first positive real, negative imaginary; second all negative
    actual = d.evaluate("7-4i", "-12-3i");
    expected = "-0.47+0.45i";
    assertTrue(actual.equals(expected));
    
    //negative real, positive imaginary; second all negative
    actual = d.evaluate("-2+4i", "-3-6i");
    expected = "-0.4-0.53i";
    assertTrue(actual.equals(expected));
    
    /* TESTS PAST THIS POINT ARE INCOMPLETE AS OF 4/7/2021 */
    
    //first all positive; second positive real, negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first all positive; second negative real, positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first all negative; second positive real, negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first all negative; second negative real, positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive real, negative imaginary; second positive real, negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative real, positive imaginary; second negative real, positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative real, positive imaginary; second positive real, negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive real, negative imaginary; second negative real, positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));

  }
  
  @Test
  public void testImaginary()
  {
    DivisionOperator d = new DivisionOperator();
    
    //both negative
    String actual = d.evaluate("", "");
    String expected = "";
    assertTrue(actual.equals(expected));
    
    //both positive
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative, second positive
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive, second negative
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
  }

  @Test
  public void testReal()
  {
    DivisionOperator d = new DivisionOperator();
    
    //both negative
    String actual = d.evaluate("", "");
    String expected = "";
    assertTrue(actual.equals(expected));
    
    //both positive
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative, second positive
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive, second negative
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
  }
  
  @Test
  public void testComplexImaginary()
  {
    DivisionOperator d = new DivisionOperator();
    
    //first complex all positive; second positive imaginary
    String actual = d.evaluate("", "");
    String expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, negative real, positive imaginary; second positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, positive real, negative imaginary; second positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, all negative; second positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    
    //first complex all positive; second negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, negative real, positive imaginary; second negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, positive real, negative imaginary; second negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, all negative; second negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    
    //first positive imaginary; second complex all positive; 
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive imaginary; second complex, negative real, positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive imaginary; second complex, positive real, negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive imaginary; second complex, all negative
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    
    //first negative imaginary; second complex all positive
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative imaginary; second complex, negative real, positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative imaginary; second complex, positive real, negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative imaginary; second complex, all negative
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
  }
  
  @Test
  public void testComplexReal()
  {
    DivisionOperator d = new DivisionOperator();
    
    //first complex all positive; second positive real
    String actual = d.evaluate("", "");
    String expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, negative real, positive imaginary; second positive real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, positive real, negative imaginary; second positive real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, all negative; second positive real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    
    //first complex all positive; second negative real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, negative real, positive imaginary; second negative real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, positive real, negative imaginary; second negative real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first complex, all negative; second negative real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    
    //first positive real; second complex all positive 
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive real; second complex, negative real, positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive real; second complex, positive real, negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first positive real; second complex, all negative
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    
    //first negative real; second complex all positive
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative real; second complex, negative real, positive imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative real; second complex, positive real, negative imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first negative real; second complex, all negative
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
  }
  
  @Test
  public void testImginaryReal()
  {
    DivisionOperator d = new DivisionOperator();
    
    //both negative; first imaginary; second real
    String actual = d.evaluate("", "");
    String expected = "";
    assertTrue(actual.equals(expected));
    
    //both positive; first imaginary; second real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //both negative; first real; second imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //both positive; first real; second imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    
    //first imaginary negative; second real positive
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first imaginary positive; second real negative
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first real negative; second imaginary positive
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //first real positive; second imaginary negative
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
  }
  
  @Test
  public void nonDecimalSolution()
  {
    DivisionOperator d = new DivisionOperator();
    
    //complex
    String actual = d.evaluate("", "");
    String expected = "";
    assertTrue(actual.equals(expected));
    
    //imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //complex real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //complex imaginary
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
    //imaginary real
    actual = d.evaluate("", "");
    expected = "";
    assertTrue(actual.equals(expected));
    
  }
}
