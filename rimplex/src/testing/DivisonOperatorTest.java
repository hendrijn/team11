package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.DivisionOperator;
import operations.SubtractionOperator;
import operations.TempContext;

class DivisonOperatorTest
{

  @Test 
  public void testSpaces()
  {
    TempContext d = new TempContext(new DivisionOperator());
    
    //complex
    String actual = d.evaluate("2    +    3   i", "5    +    3 i");
    String expected = "0.56+0.26i";
    assertTrue(actual.equals(expected));
    
    //imaginary
    actual = d.evaluate("  2  i      ", " 9    i");
    expected = "0.22+0.00i";
    assertTrue(actual.equals(expected));
    
    //real
    actual = d.evaluate("   5 ", " 2     ");
    expected = "2.50+0.00i";
    assertTrue(actual.equals(expected));
    
    //complex imaginary
    actual = d.evaluate("  9    - 5   i ", " - 2       i  ");
    expected = "2.50+4.50i";
    assertTrue(actual.equals(expected));
    
    //complex real
    actual = d.evaluate("  -    7 ", " 4      -  6 i   ");
    expected = "-0.54-0.81i";
    assertTrue(actual.equals(expected));
    
    //imaginary real
    actual = d.evaluate(" -   9    i ", "        2 ");
    expected = "0.00-4.50i";
    assertTrue(actual.equals(expected));
  }
  
  @Test
  public void testIllegalArgs()
  {
    TempContext d = new TempContext(new DivisionOperator());
    
    //random chars
    try 
    {
      String actual = d.evaluate("nfouuvboa", "kleroiweygp");
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }
    
    //numbers and operators with random chars
    try 
    {
      String actual = d.evaluate("5+heuq", "6++jbiogh");
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    //too many i's
    try 
    {
      String actual = d.evaluate("5+6ii", "4i");
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    //one i in invalid string
    try 
    {
      String actual = d.evaluate("ilovecs", "6");
    }
    catch(IllegalArgumentException iae)
    {
      assertTrue(true);
    }

  }
  
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
    expected = "-0.40-0.53i";
    assertTrue(actual.equals(expected));
    
    //first all positive; second positive real, negative imaginary
    actual = d.evaluate("4+7i", "6-2i");
    expected = "0.25+1.25i";
    assertTrue(actual.equals(expected));
    
    //first all positive; second negative real, positive imaginary
    actual = d.evaluate("3+8i", "-4+9i");
    expected = "0.62-0.61i";
    assertTrue(actual.equals(expected));
    
    //first all negative; second positive real, negative imaginary
    actual = d.evaluate("-2-5i", "6-8i");
    expected = "0.28-0.46i";
    assertTrue(actual.equals(expected));
    
    //first all negative; second negative real, positive imaginary
    actual = d.evaluate("-5-7i", "-4+6i");
    expected = "-0.42+1.12i";
    assertTrue(actual.equals(expected));
    
    //first positive real, negative imaginary; second positive real, negative imaginary
    actual = d.evaluate("5-4i", "7-2i");
    expected = "0.81-0.34i";
    assertTrue(actual.equals(expected));
    
    //first negative real, positive imaginary; second negative real, positive imaginary
    actual = d.evaluate("-6+9i", "-2+5i");
    expected = "1.97+0.41i";
    assertTrue(actual.equals(expected));
    
    //first negative real, positive imaginary; second positive real, negative imaginary
    actual = d.evaluate("-4+9i", "8-7i");
    expected = "-0.84+0.39i";
    assertTrue(actual.equals(expected));
    
    //first positive real, negative imaginary; second negative real, positive imaginary
    actual = d.evaluate("4-3i", "-5+7i");
    expected = "-0.55-0.18i";
    assertTrue(actual.equals(expected));

  }
  
  @Test
  public void testImaginary()
  {
    TempContext d = new TempContext(new DivisionOperator());
    
    //both negative
    String actual = d.evaluate("-3i", "-5i");
    String expected = "0.60+0.00i";
    assertTrue(actual.equals(expected));
    
    //both positive
    actual = d.evaluate("2i", "9i");
    expected = "0.22+0.00i";
    assertTrue(actual.equals(expected));
    
    //first negative, second positive
    actual = d.evaluate("-6i", "7i");
    expected = "-0.86+0.00i";
    assertTrue(actual.equals(expected));
    
    //first positive, second negative
    actual = d.evaluate("8i", "-4i");
    expected = "-2.00+0.00i";
    assertTrue(actual.equals(expected));
    
  }

  @Test
  public void testReal()
  {
    TempContext d = new TempContext(new DivisionOperator());
    
    //both negative
    String actual = d.evaluate("6", "9");
    String expected = "0.67+0.00i";
    assertTrue(actual.equals(expected));
    
    //both positive
    actual = d.evaluate("8", "3");
    expected = "2.67+0.00i";
    assertTrue(actual.equals(expected));
    
    //first negative, second positive
    actual = d.evaluate("5", "2");
    expected = "2.50+0.00i";
    assertTrue(actual.equals(expected));
    
    //first positive, second negative
    actual = d.evaluate("9", "4");
    expected = "2.25+0.00i";
    assertTrue(actual.equals(expected));
    
  }
  
  @Test
  public void testComplexImaginary()
  {
    TempContext d = new TempContext(new DivisionOperator());
    
    //first complex all positive; second positive imaginary
    String actual = d.evaluate("4+8i", "5i");
    String expected = "1.60-0.80i";
    assertTrue(actual.equals(expected));
    
    //first complex, negative real, positive imaginary; second positive imaginary
    actual = d.evaluate("-6+7i", "3i");
    expected = "2.33+2.00i";
    assertTrue(actual.equals(expected));
    
    //first complex, positive real, negative imaginary; second positive imaginary
    actual = d.evaluate("3-5i", "8i");
    expected = "-0.63-0.38i";
    assertTrue(actual.equals(expected));
    
    //first complex, all negative; second positive imaginary
    actual = d.evaluate("-2-4i", "9i");
    expected = "-0.44+0.22i";
    assertTrue(actual.equals(expected));
    
    
    //first complex all positive; second negative imaginary
    actual = d.evaluate("7+3i", "-4i");
    expected = "-0.75+1.75i";
    assertTrue(actual.equals(expected));
    
    //first complex, negative real, positive imaginary; second negative imaginary
    actual = d.evaluate("-6+2i", "-7i");
    expected = "-0.29-0.86i";
    assertTrue(actual.equals(expected));
    
    //first complex, positive real, negative imaginary; second negative imaginary
    actual = d.evaluate("9-5i", "-2i");
    expected = "2.50+4.50i";
    assertTrue(actual.equals(expected));
    
    //first complex, all negative; second negative imaginary
    actual = d.evaluate("-4-3i", "-i");
    expected = "";
    assertTrue(actual.equals(expected));
    
    
    //first positive imaginary; second complex all positive; 
    actual = d.evaluate("3i", "2+8i");
    expected = "3.00-4.00i";
    assertTrue(actual.equals(expected));
    
    //first positive imaginary; second complex, negative real, positive imaginary
    actual = d.evaluate("8i", "-5+9i");
    expected = "0.68-0.38i";
    assertTrue(actual.equals(expected));
    
    //first positive imaginary; second complex, positive real, negative imaginary
    actual = d.evaluate("4i", "7-9i");
    expected = "-0.28+0.22i";
    assertTrue(actual.equals(expected));
    
    //first positive imaginary; second complex, all negative
    actual = d.evaluate("5i", "-7-8i");
    expected = "-0.35-0.31i";
    assertTrue(actual.equals(expected));
    
    
    //first negative imaginary; second complex all positive
    actual = d.evaluate("-9i", "3+6i");
    expected = "-1.20-0.60i";
    assertTrue(actual.equals(expected));
    
    //first negative imaginary; second complex, negative real, positive imaginary
    actual = d.evaluate("-7i", "-7+9i");
    expected = "-0.48+0.38i";
    assertTrue(actual.equals(expected));
    
    //first negative imaginary; second complex, positive real, negative imaginary
    actual = d.evaluate("-2i", "5-3i");
    expected = "0.18-0.29i";
    assertTrue(actual.equals(expected));
    
    //first negative imaginary; second complex, all negative
    actual = d.evaluate("-i", "-7-5i");
    expected = "0.07+0.13i";
    assertTrue(actual.equals(expected));
    
  }
  
  @Test
  public void testComplexReal()
  {
    TempContext d = new TempContext(new DivisionOperator());
    
    //first complex all positive; second positive real
    String actual = d.evaluate("2+5i", "7");
    String expected = "0.29+0.71i";
    assertTrue(actual.equals(expected));
    
    //first complex, negative real, positive imaginary; second positive real
    actual = d.evaluate("-4+3i", "3");
    expected = "-1.33+0.00i";
    assertTrue(actual.equals(expected));
    
    //first complex, positive real, negative imaginary; second positive real
    actual = d.evaluate("7-4i", "5");
    expected = "1.40-0.8i";
    assertTrue(actual.equals(expected));
    
    //first complex, all negative; second positive real
    actual = d.evaluate("-9-5i", "2");
    expected = "-4.50-2.50i";
    assertTrue(actual.equals(expected));
    
    
    //first complex all positive; second negative real
    actual = d.evaluate("6+9i", "-8");
    expected = "-0.75-1.13i";
    assertTrue(actual.equals(expected));
    
    //first complex, negative real, positive imaginary; second negative real
    actual = d.evaluate("-8+6i", "-4");
    expected = "2.00-1.50i";
    assertTrue(actual.equals(expected));
    
    //first complex, positive real, negative imaginary; second negative real
    actual = d.evaluate("4-7i", "-6");
    expected = "-0.67+1.17i";
    assertTrue(actual.equals(expected));
    
    //first complex, all negative; second negative real
    actual = d.evaluate("-7-5i", "-9");
    expected = "0.78+0.56i";
    assertTrue(actual.equals(expected));
    
    //first positive real; second complex all positive 
    actual = d.evaluate("2", "1+9i");
    expected = "0.02-0.22i";
    assertTrue(actual.equals(expected));
    
    //first positive real; second complex, negative real, positive imaginary
    actual = d.evaluate("4", "-3+7i");
    expected = "-0.21-0.48i";
    assertTrue(actual.equals(expected));
    
    //first positive real; second complex, positive real, negative imaginary
    actual = d.evaluate("6", "5-4i");
    expected = "0.73+0.59i";
    assertTrue(actual.equals(expected));
    
    //first positive real; second complex, all negative
    actual = d.evaluate("8", "-7-3i");
    expected = "-0.97+0.41i";
    assertTrue(actual.equals(expected));
    
    
    //first negative real; second complex all positive
    actual = d.evaluate("-3", "9+i");
    expected = "-0.33+0.04i";
    assertTrue(actual.equals(expected));
    
    //first negative real; second complex, negative real, positive imaginary
    actual = d.evaluate("-5", "-2+8i");
    expected = "0.15+0.59i";
    assertTrue(actual.equals(expected));
    
    //first negative real; second complex, positive real, negative imaginary
    actual = d.evaluate("-7", "4-6i");
    expected = "-0.54-0.81i";
    assertTrue(actual.equals(expected));
    
    //first negative real; second complex, all negative
    actual = d.evaluate("-9", "-6-2i");
    expected = "1.35-0.45i";
    assertTrue(actual.equals(expected));
    
  }
  
  @Test
  public void testImginaryReal()
  {
    TempContext d = new TempContext(new DivisionOperator());
    
    //both negative; first imaginary; second real
    String actual = d.evaluate("-i", "-2");
    String expected = "0.00+0.5i";
    assertTrue(actual.equals(expected));
    
    //both positive; first imaginary; second real
    actual = d.evaluate("3i", "4");
    expected = "0.00+0.75i";
    assertTrue(actual.equals(expected));
    
    //both negative; first real; second imaginary
    actual = d.evaluate("-5", "-6i");
    expected = "0.00+0.83i";
    assertTrue(actual.equals(expected));
    
    //both positive; first real; second imaginary
    actual = d.evaluate("7", "8i");
    expected = "0.00+0.88i";
    assertTrue(actual.equals(expected));
    
    
    //first imaginary negative; second real positive
    actual = d.evaluate("-9i", "2");
    expected = "0.00-4.50i";
    assertTrue(actual.equals(expected));
    
    //first imaginary positive; second real negative
    actual = d.evaluate("2i", "-5");
    expected = "0.00-0.40i";
    assertTrue(actual.equals(expected));
    
    //first real negative; second imaginary positive
    actual = d.evaluate("-4", "7i");
    expected = "0.00-0.57i";
    assertTrue(actual.equals(expected));
    
    //first real positive; second imaginary negative
    actual = d.evaluate("6", "-9i");
    expected = "0.00-0.67i";
    assertTrue(actual.equals(expected));
    
  }
  
  @Test
  public void testDecimalOperands()
  {
    //TODO: implement
    TempContext d = new TempContext(new DivisionOperator());
    
    //complex
    String actual = d.evaluate("3.45+7.56i", "2.98+5.04i");
    String expected = "1.41+0.15i";
    assertTrue(actual.equals(expected));
    
    //imaginary
    actual = d.evaluate("6.42i", "7.75i");
    expected = "0.83+0.00i";
    assertTrue(actual.equals(expected));
    
    //real
    actual = d.evaluate("3.88", "2.94");
    expected = "1.32+0.00i";
    assertTrue(actual.equals(expected));
    
    //complex imaginary
    actual = d.evaluate("0.89+7.25i", "3.56i");
    expected = "2.04-0.25i";
    assertTrue(actual.equals(expected));
    
    //complex real
    actual = d.evaluate("3.39+6.89i", "2.09");
    expected = "1.62+3.30i";
    assertTrue(actual.equals(expected));
    
    //real imaginary
    actual = d.evaluate("9.06", "2.66i");
    expected = "0.00-3.41i";
    assertTrue(actual.equals(expected));
  }
}
