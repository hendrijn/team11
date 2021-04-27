package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.DivisionOperator;
import operations.TempContext;

/**
 * Unit tests for DivisionOperator.
 * 
 * @author may4sa - team11
 * @version Sprint 3
 */
class DivisonOperatorTest
{
  private final String complexOne = "-7-8i";
  private final String complexTwo = "2+8i";
  private final String complexThree = "7-4i";
  private final String complexFour = "-12-3i";
  private final String complexFive = "-4+9i";
  private final String complexSix = "5-4i";
  private final String complexSeven = "7-2i";
  private final String complexEight = "3+6i";
  private final String complexNine = "-7-5i";
  private final String complexTen = "-2+8i";
  private final String complexDecimalOne = "0.56+0.26i";
  private final String complexDecimalTwo = "0.22+0.00i";
  private final String complexDecimalThree = "2.50+0.00i";
  private final String complexDecimalFour = "2.50+4.50i";
  private final String complexDecimalFive = "-0.54-0.81i";
  private final String complexDecimalSix = "0.00-4.50i";
  private final String complexDecimalSeven = "3.45+7.56i";
  private final String complexDecimalEight = "2.98+5.04i";
  private final String imagOne = "4i";
  private final String imagTwo = "2i";
  private final String imagThree = "9i";
  private final String imagFour = "-6i";
  private final String imagFive = "7i";
  private final String imagSix = "8i";
  private final String imagSeven = "-4i";
  private final String imagEight = "5i";
  private final String imagNine = "3i";
  private final String imagTen = "-7i";
  private final String imagEleven = "-2i";
  private final String imagTwelve = "-9i";
  private final String six = "6";
  private final String seven = "7";
  private final String nine = "9";
  private final String eight = "8";
  private final String three = "3";
  private final String five = "5";
  private final String two = "2";
  private final String four = "4";
  private final String negFive = "-5";
  private final String negFour = "-4";
  private final String negNine = "-9";
  private final String parens = "()";
  private final String negI = "-i";
  
  /**
   * test operands with spaces.
   */
  @Test
  public void testSpaces()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // complex
    String actual = d.evaluate("2    +    3   i", "5    +    3 i");
    String expected = complexDecimalOne;
    assertTrue(actual.equals(expected));

    // imaginary
    actual = d.evaluate("  2  i      ", " 9    i");
    expected = complexDecimalTwo;
    assertTrue(actual.equals(expected));

    // real
    actual = d.evaluate("   5 ", " 2     ");
    expected = complexDecimalThree;
    assertTrue(actual.equals(expected));

    // complex imaginary
    actual = d.evaluate("  9    - 5   i ", " - 2       i  ");
    expected = complexDecimalFour;
    assertTrue(actual.equals(expected));

    // complex real
    actual = d.evaluate("  -    7 ", " 4      -  6 i   ");
    expected = complexDecimalFive;
    assertTrue(actual.equals(expected));

    // imaginary real
    actual = d.evaluate(" -   9    i ", "        2 ");
    expected = complexDecimalSix;
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for Illegal Arguments.
   */
  @Test
  public void testIllegalArgs()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // empty L
    try
    {
      d.evaluate("", six);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // empty R
    try
    {
      d.evaluate(six, "");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // null L
    try
    {
      d.evaluate(null, six);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // null R
    try
    {
      d.evaluate(six, null);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // empty both
    try
    {
      d.evaluate("", "");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // null both
    try
    {
      d.evaluate(null, null);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // just parens L
    try
    {
      d.evaluate(parens, seven);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // just paren R
    try
    {
      d.evaluate(seven, parens);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // random chars
    try
    {
      d.evaluate("nfouuvboa", "kleroiweygp");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // numbers and operators with random chars
    try
    {
      d.evaluate("5+heuq", "6++jbiogh");
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // too many i's
    try
    {
      d.evaluate("5+6ii", imagOne);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // one i in invalid string
    try
    {
      d.evaluate("ilovecs", six);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  /**
   * tests division with complex operands.
   */
  @Test
  public void testComplex()
  {
    DivisionOperator d = new DivisionOperator();

    // both positive
    String actual = d.evaluate("2+3i", "5+3i");
    String expected = complexDecimalOne;
    assertTrue(actual.equals(expected));

    // both negative
    actual = d.evaluate("-6-3i", complexOne);
    expected = "0.58-0.24i";
    assertTrue(actual.equals(expected));

    // first positive real, negative imaginary; second all positive
    actual = d.evaluate("8-2i", "4+9i");
    expected = "0.14-0.82i";
    assertTrue(actual.equals(expected));

    // negative real, positive imaginary; second all positive
    actual = d.evaluate("-7+3i", complexTwo);
    expected = "0.15+0.91i";
    assertTrue(actual.equals(expected));

    // first positive real, negative imaginary; second all negative
    actual = d.evaluate(complexThree, complexFour);
    expected = "-0.47+0.45i";
    assertTrue(actual.equals(expected));

    // negative real, positive imaginary; second all negative
    actual = d.evaluate("-2+4i", "-3-6i");
    expected = "-0.40-0.53i";
    assertTrue(actual.equals(expected));

    // first all positive; second positive real, negative imaginary
    actual = d.evaluate("4+7i", "6-2i");
    expected = "0.25+1.25i";
    assertTrue(actual.equals(expected));

    // first all positive; second negative real, positive imaginary
    actual = d.evaluate("3+8i", complexFive);
    expected = "0.62-0.61i";
    assertTrue(actual.equals(expected));

    // first all negative; second positive real, negative imaginary
    actual = d.evaluate("-2-5i", "6-8i");
    expected = "0.28-0.46i";
    assertTrue(actual.equals(expected));

    // first all negative; second negative real, positive imaginary
    actual = d.evaluate("-5-7i", "-4+6i");
    expected = "-0.42+1.12i";
    assertTrue(actual.equals(expected));

    // first positive real, negative imaginary; second positive real, negative imaginary
    actual = d.evaluate(complexSix, complexSeven);
    expected = "0.81-0.34i";
    assertTrue(actual.equals(expected));

    // first negative real, positive imaginary; second negative real, positive imaginary
    actual = d.evaluate("-6+9i", "-2+5i");
    expected = "1.97+0.41i";
    assertTrue(actual.equals(expected));

    // first negative real, positive imaginary; second positive real, negative imaginary
    actual = d.evaluate(complexFive, "8-7i");
    expected = "-0.84+0.39i";
    assertTrue(actual.equals(expected));

    // first positive real, negative imaginary; second negative real, positive imaginary
    actual = d.evaluate("4-3i", "-5+7i");
    expected = "-0.55-0.18i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests division with imaginary operands.
   */
  @Test
  public void testImaginary()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // both negative
    String actual = d.evaluate("-3i", "-5i");
    String expected = "0.60+0.00i";
    assertTrue(actual.equals(expected));

    // both positive
    actual = d.evaluate(imagTwo, imagThree);
    expected = complexDecimalTwo;
    assertTrue(actual.equals(expected));

    // first negative, second positive
    actual = d.evaluate(imagFour, imagFive);
    expected = "-0.86+0.00i";
    assertTrue(actual.equals(expected));

    // first positive, second negative
    actual = d.evaluate(imagSix, imagSeven);
    expected = "-2.00+0.00i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests division with real operands.
   */
  @Test
  public void testReal()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // both negative
    String actual = d.evaluate(six, nine);
    String expected = "0.67+0.00i";
    assertTrue(actual.equals(expected));

    // both positive
    actual = d.evaluate(eight, three);
    expected = "2.67+0.00i";
    assertTrue(actual.equals(expected));

    // first negative, second positive
    actual = d.evaluate(five, two);
    expected = complexDecimalThree;
    assertTrue(actual.equals(expected));

    // first positive, second negative
    actual = d.evaluate(nine, four);
    expected = "2.25+0.00i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests division with complex and imaginary operands.
   */
  @Test
  public void testComplexImaginary()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // first complex all positive; second positive imaginary
    String actual = d.evaluate("4+8i", imagEight);
    String expected = "1.60-0.80i";
    assertTrue(actual.equals(expected));

    // first complex, negative real, positive imaginary; second positive imaginary
    actual = d.evaluate("-6+7i", imagNine);
    expected = "2.33+2.00i";
    assertTrue(actual.equals(expected));

    // first complex, positive real, negative imaginary; second positive imaginary
    actual = d.evaluate("3-5i", imagSix);
    expected = "-0.63-0.38i";
    assertTrue(actual.equals(expected));

    // first complex, all negative; second positive imaginary
    actual = d.evaluate("-2-4i", imagThree);
    expected = "-0.44+0.22i";
    assertTrue(actual.equals(expected));

    // first complex all positive; second negative imaginary
    actual = d.evaluate("7+3i", imagSeven);
    expected = "-0.75+1.75i";
    assertTrue(actual.equals(expected));

    // first complex, negative real, positive imaginary; second negative imaginary
    actual = d.evaluate("-6+2i", imagTen);
    expected = "-0.29-0.86i";
    assertTrue(actual.equals(expected));

    // first complex, positive real, negative imaginary; second negative imaginary
    actual = d.evaluate("9-5i", imagEleven);
    expected = complexDecimalFour;
    assertTrue(actual.equals(expected));

    // first complex, all negative; second negative imaginary
    actual = d.evaluate("-4-3i",negI);
    expected = "3.00-4.00i";
    assertTrue(actual.equals(expected));

    // first positive imaginary; second complex all positive;
    actual = d.evaluate(imagNine, complexTwo);
    expected = "0.35+0.09i";
    assertTrue(actual.equals(expected));

    // first positive imaginary; second complex, negative real, positive imaginary
    actual = d.evaluate(imagSix, "-5+9i");
    expected = "0.68-0.38i";
    assertTrue(actual.equals(expected));

    // first positive imaginary; second complex, positive real, negative imaginary
    actual = d.evaluate(imagOne, "7-9i");
    expected = "-0.28+0.22i";
    assertTrue(actual.equals(expected));

    // first positive imaginary; second complex, all negative
    actual = d.evaluate(imagEight, complexOne);
    expected = "-0.35-0.31i";
    assertTrue(actual.equals(expected));

    // first negative imaginary; second complex all positive
    actual = d.evaluate(imagTwelve, complexEight);
    expected = "-1.20-0.60i";
    assertTrue(actual.equals(expected));

    // first negative imaginary; second complex, negative real, positive imaginary
    actual = d.evaluate(imagTen, "-7+9i");
    expected = "-0.48+0.38i";
    assertTrue(actual.equals(expected));

    // first negative imaginary; second complex, positive real, negative imaginary
    actual = d.evaluate(imagEleven, "5-3i");
    expected = "0.18-0.29i";
    assertTrue(actual.equals(expected));

    // first negative imaginary; second complex, all negative
    actual = d.evaluate(negI, complexNine);
    expected = "0.07+0.09i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests division with complex and real operands.
   */
  @Test
  public void testComplexReal()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // first complex all positive; second positive real
    String actual = d.evaluate("2+5i", seven);
    String expected = "0.29+0.71i";
    assertTrue(actual.equals(expected));

    // first complex, negative real, positive imaginary; second positive real
    actual = d.evaluate("-4+3i", three);
    expected = "-1.33+1.00i";
    assertTrue(actual.equals(expected));

    // first complex, positive real, negative imaginary; second positive real
    actual = d.evaluate(complexThree, five);
    expected = "1.40-0.80i";
    assertTrue(actual.equals(expected));

    // first complex, all negative; second positive real
    actual = d.evaluate("-9-5i", two);
    expected = "-4.50-2.50i";
    assertTrue(actual.equals(expected));

    // first complex all positive; second negative real
    actual = d.evaluate("6+9i", "-8");
    expected = "-0.75-1.13i";
    assertTrue(actual.equals(expected));

    // first complex, negative real, positive imaginary; second negative real
    actual = d.evaluate("-8+6i", negFour);
    expected = "2.00-1.50i";
    assertTrue(actual.equals(expected));

    // first complex, positive real, negative imaginary; second negative real
    actual = d.evaluate("4-7i", "-6");
    expected = "-0.67+1.17i";
    assertTrue(actual.equals(expected));

    // first complex, all negative; second negative real
    actual = d.evaluate(complexNine, negNine);
    expected = "0.78+0.56i";
    assertTrue(actual.equals(expected));

    // first positive real; second complex all positive
    actual = d.evaluate(two, "1+9i");
    expected = "0.02-0.22i";
    assertTrue(actual.equals(expected));

    // first positive real; second complex, negative real, positive imaginary
    actual = d.evaluate(four, "-3+7i");
    expected = "-0.21-0.48i";
    assertTrue(actual.equals(expected));

    // first positive real; second complex, positive real, negative imaginary
    actual = d.evaluate(six, complexSix);
    expected = "0.73+0.59i";
    assertTrue(actual.equals(expected));

    // first positive real; second complex, all negative
    actual = d.evaluate(eight, "-7-3i");
    expected = "-0.97+0.41i";
    assertTrue(actual.equals(expected));

    // first negative real; second complex all positive
    actual = d.evaluate("-3", "9+i");
    expected = "-0.33+0.04i";
    assertTrue(actual.equals(expected));

    // first negative real; second complex, negative real, positive imaginary
    actual = d.evaluate(negFive, complexTen);
    expected = "0.15+0.59i";
    assertTrue(actual.equals(expected));

    // first negative real; second complex, positive real, negative imaginary
    actual = d.evaluate("-7", "4-6i");
    expected = complexDecimalFive;
    assertTrue(actual.equals(expected));

    // first negative real; second complex, all negative
    actual = d.evaluate(negNine, "-6-2i");
    expected = "1.35-0.45i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests division with imaginary and real operands.
   */
  @Test
  public void testImginaryReal()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // both negative; first imaginary; second real
    String actual = d.evaluate(negI, "-2");
    String expected = "0.00+0.50i";
    assertTrue(actual.equals(expected));

    // both positive; first imaginary; second real
    actual = d.evaluate(imagNine, four);
    expected = "0.00+0.75i";
    assertTrue(actual.equals(expected));

    // both negative; first real; second imaginary
    actual = d.evaluate(negFive, imagFour);
    expected = "0.00-0.83i";
    assertTrue(actual.equals(expected));

    // both positive; first real; second imaginary
    actual = d.evaluate(seven, "i");
    expected = "0.00-7.00i";
    assertTrue(actual.equals(expected));

    // first imaginary negative; second real positive
    actual = d.evaluate(imagTwelve, two);
    expected = complexDecimalSix;
    assertTrue(actual.equals(expected));

    // first imaginary positive; second real negative
    actual = d.evaluate(imagTwo, negFive);
    expected = "0.00-0.40i";
    assertTrue(actual.equals(expected));

    // first real negative; second imaginary positive
    actual = d.evaluate(negFour, imagFive);
    expected = "0.00+0.57i";
    assertTrue(actual.equals(expected));

    // first real positive; second imaginary negative
    actual = d.evaluate(six, imagTwelve);
    expected = "0.00+0.67i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests division with decimal operands.
   */
  @Test
  public void testDecimalOperands()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // complex
    String actual = d.evaluate(complexDecimalSeven, complexDecimalEight);
    String expected = "1.41+0.15i";
    assertTrue(actual.equals(expected));

    // imaginary
    actual = d.evaluate("6.42i", "7.75i");
    expected = "0.83+0.00i";
    assertTrue(actual.equals(expected));

    // real
    actual = d.evaluate("3.88", "2.94");
    expected = "1.32+0.00i";
    assertTrue(actual.equals(expected));

    // complex imaginary
    actual = d.evaluate("0.89+7.25i", "3.56i");
    expected = "2.04-0.25i";
    assertTrue(actual.equals(expected));

    // complex real
    actual = d.evaluate("3.39+6.89i", "2.09");
    expected = "1.62+3.30i";
    assertTrue(actual.equals(expected));

    // real imaginary
    actual = d.evaluate("9.06", "2.66i");
    expected = "0.00-3.40i";
    assertTrue(actual.equals(expected));
  }

  @Test
  public void testZeros()
  {
    TempContext d = new TempContext(new DivisionOperator());

    // complex 0 decimal
    try
    {
      d.evaluate(complexDecimalSeven, "0.00+0.00i");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // imaginary 0
    try
    {
      d.evaluate(complexDecimalSeven, "0i");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // imaginay 0 decimal
    try
    {
      d.evaluate(complexDecimalSeven, "0.00i");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // complex 0, negative imaginary 0
    try
    {
      d.evaluate(complexDecimalSeven, "0-0i");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // complex 0
    try
    {
      d.evaluate(complexDecimalSeven, "0+0i");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // real 0
    try
    {
      d.evaluate(complexDecimalSeven, "0");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }

    // real 0 decimal
    try
    {
      d.evaluate(complexDecimalSeven, "0.00");
      assertTrue(false);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }
}
