package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import operations.SubtractionOperator;
import operations.TempContext;

/**
 * Unit tests for the Subtraction class.
 * 
 * @author team 11 - may4sa
 * @version Sprint 3
 */
class SubtractionOperatorTest
{
  private final String imagOne = "5i";
  private final String imagTwo = "3i";
  private final String imagThree = "15i";
  private final String imagFour = "45i";
  private final String imagFive = "2i";
  private final String imagSix = "-3i";
  private final String imagSeven = "6i";
  private final String imagEight = "-2i";
  private final String imagNine = "-7i";
  private final String negEight = "-8";
  private final String negSeven = "-7";
  private final String negSix = "-6";
  private final String negFive = "-5";
  private final String two = "2";
  private final String three = "3";
  private final String five = "5";
  private final String eight  = "8";
  private final String nine = "9";
  private final String fifteen = "15";
  private final String fortyFive = "45";
  private final String random = "hij+klmn";
  private final String complexOne = "4+5i";
  private final String complexTwo = "2+3i";
  private final String complexThree = "5+2i";
  private final String complexFive = "-2-3i";
  private final String complexSix = "5+6i";
  private final String complexSeven = "-4-2i";
  private final String complexEight = "-2-7i";
  
  /**
   * tests for operands with spaces.
   */
  @Test
  public void testEvaluateExtraSpaces()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // complex
    String actual = s.evaluate("   6       +      4     i   ", "   2        +       3    i      ");
    String expected = "4.00+1.00i";
    assertTrue(actual.equals(expected));

    // imaginary
    actual = s.evaluate("         5        i  ", "         3      i   ");
    expected = "0.00+2.00i";
    assertTrue(actual.equals(expected));

    // real
    actual = s.evaluate("         5      ", "         8    ");
    expected = "-3.00+0.00i";
    assertTrue(actual.equals(expected));

    // complex and real
    actual = s.evaluate("         9   +     3   i      ", "      4     ");
    expected = "5.00+3.00i";
    assertTrue(actual.equals(expected));

    // complex and imaginary
    actual = s.evaluate("         7  + 4    i      ", "         2     i   ");
    expected = "7.00+2.00i";
    assertTrue(actual.equals(expected));

    // imaginary and real
    actual = s.evaluate("        2         i     ", "        7    ");
    expected = "-7.00+2.00i";
    assertTrue(actual.equals(expected));
  }

  /**
   * tests for illegal arguments.
   */
  @Test
  public void testEvaluateIllegalArguments()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // both illegal
    try
    {
      s.evaluate("abcdefg", "hijklmn");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand illegal
    try
    {
      s.evaluate("abc-defg", imagOne);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand illegal
    try
    {
      s.evaluate(two, random);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // test illegal i's
    try
    {
      s.evaluate(two, "iiiiiiii");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // test illegal i's with numbers
    try
    {
      s.evaluate("2ii", three);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // single i illegal operand
    try
    {
      s.evaluate("i love cs", imagOne);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }
  }

  /**
   * tests for complex numbers as operands.
   */
  @Test
  public void testEvaluateComplex()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // both operands null
    try
    {
      s.evaluate(null, null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand null
    try
    {
      s.evaluate(null, "6+3i");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand null
    try
    {
      s.evaluate(complexOne, null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // both operands empty
    try
    {
      s.evaluate("", "");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand empty
    try
    {
      s.evaluate("", complexTwo);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand empty
    try
    {
      s.evaluate("7+5i", "");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // both positive, positive result
    String actual = s.evaluate(complexOne, complexTwo);
    String expected = "2.00+2.00i";
    assertTrue(expected.equals(actual));

    // both positive, negative result
    actual = s.evaluate("3+15i", "5+45i");
    expected = "-2.00-30.00i";
    assertTrue(expected.equals(actual));

    // negative first operand, negative result
    actual = s.evaluate("-7-55i", "2+15i");
    expected = "-9.00-70.00i";
    assertTrue(expected.equals(actual));

    // negative second operand, positive result
    actual = s.evaluate("2+63i", "-5-45i");
    expected = "7.00+108.00i";
    assertTrue(expected.equals(actual));

    // both negative, positive result
    actual = s.evaluate("-5-57i", "-7-68i");
    expected = "2.00+11.00i";
    assertTrue(expected.equals(actual));

    // both negative, negative result
    actual = s.evaluate("-9-96i", "-2-42i");
    expected = "-7.00-54.00i";
    assertTrue(expected.equals(actual));

    // just i
    actual = s.evaluate("3+2i", "2-i");
    expected = "1.00+3.00i";
    assertTrue(expected.equals(actual));
  }

  /**
   * tests for imaginary numbers as operands.
   */
  @Test
  public void testEvaluateImaginary()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // first operand null
    try
    {
      s.evaluate(null, imagTwo);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand null
    try
    {
      s.evaluate(imagOne, null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand empty
    try
    {
      s.evaluate("", imagTwo);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand empty
    try
    {
      s.evaluate(imagOne, "");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // both positive, positive result
    String actual = s.evaluate("35i", "12i");
    String expected = "0.00+23.00i";
    assertTrue(expected.equals(actual));

    // both positive, negative result
    actual = s.evaluate(imagThree, imagFour);
    expected = "0.00-30.00i";
    assertTrue(expected.equals(actual));

    // negative first operand, positive result
    actual = s.evaluate("-25i", "69i");
    expected = "0.00-94.00i";
    assertTrue(expected.equals(actual));

    // negative first operand, negative result
    actual = s.evaluate("-55i", imagThree);
    expected = "0.00-70.00i";
    assertTrue(expected.equals(actual));

    // negative second operand, positive result
    actual = s.evaluate("63i", "-45i");
    expected = "0.00+108.00i";
    assertTrue(expected.equals(actual));

    // both negative, positive result
    actual = s.evaluate("-57i", "-68i");
    expected = "0.00+11.00i";
    assertTrue(expected.equals(actual));

    // both negative, negative result
    actual = s.evaluate("-96i", "-42i");
    expected = "0.00-54.00i";
    assertTrue(expected.equals(actual));
  }

  /**
   * tests for real numbers as operands.
   */
  @Test
  public void testEvaluateReal()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // first operand null
    try
    {
      s.evaluate(null, three);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand null
    try
    {
      s.evaluate(five, null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand empty
    try
    {
      s.evaluate("", three);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand empty
    try
    {
      s.evaluate(five, "");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // both positive, positive result
    String actual = s.evaluate("35", "12");
    String expected = "23.00+0.00i";
    assertTrue(expected.equals(actual));

    // both positive, negative result
    actual = s.evaluate(fifteen, fortyFive);
    expected = "-30.00+0.00i";
    assertTrue(expected.equals(actual));

    // negative first operand, positive result
    actual = s.evaluate("-25", "69");
    expected = "-94.00+0.00i";
    assertTrue(expected.equals(actual));

    // negative first operand, negative result
    actual = s.evaluate("-55", fifteen);
    expected = "-70.00+0.00i";
    assertTrue(expected.equals(actual));

    // negative second operand, positive result
    actual = s.evaluate("63", "-45");
    expected = "108.00+0.00i";
    assertTrue(expected.equals(actual));

    // both negative, positive result
    actual = s.evaluate("-57", "-68");
    expected = "11.00+0.00i";
    assertTrue(expected.equals(actual));

    // both negative, negative result
    actual = s.evaluate("-96", "-42");
    expected = "-54.00+0.00i";
    assertTrue(expected.equals(actual));
  }

  /**
   * tests for complex numbers and real numbers as operands.
   */
  @Test
  public void testEvaluateComplexReal()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // both positive, first operand complex, second operand real
    String actual = s.evaluate("5+3i", three);
    String expected = "2.00+3.00i";
    assertTrue(expected.equals(actual));

    
    // both positive, first operand real, second operand complex
    actual = s.evaluate(eight, complexThree);
    expected = "3.00-2.00i";
    assertTrue(expected.equals(actual));

 // AHHHHHHHHHHH
    // first operand complex and negative, second operand real and positive
    actual = s.evaluate(complexFive, three);
    expected = "-5.00-3.00i";
    assertTrue(expected.equals(actual));

    // first operand real and negative, second operand complex and positive
    actual = s.evaluate(negSeven, complexSix);
    expected = "-12.00-6.00i";
    assertTrue(expected.equals(actual));

    // first operand complex and positive, second operand real and negative
    actual = s.evaluate("4+6i", negEight);
    expected = "12.00+6.00i";
    assertTrue(expected.equals(actual));

    // first operand real and positive, second operand complex and negative
    actual = s.evaluate(nine, complexSeven);
    expected = "13.00+2.00i";
    assertTrue(expected.equals(actual));

    // both negative, first operand complex, second operand real
    actual = s.evaluate(complexFive, negFive);
    expected = "3.00-3.00i";
    assertTrue(expected.equals(actual));

    // both negative, first operand real, second operand complex
    actual = s.evaluate(negSix, complexEight);
    expected = "-4.00+7.00i";
    assertTrue(expected.equals(actual));
  }

  /**
   * tests for imaginary numbers and real numbers as operands.
   */
  @Test
  public void testEvaluateImaginaryReal()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // both positive, first operand imaginary, second operand real
    String actual = s.evaluate(imagTwo, three);
    String expected = "-3.00+3.00i";
    assertTrue(expected.equals(actual));

    // both positive, first operand real, second operand imaginary
    actual = s.evaluate(eight, imagFive);
    expected = "8.00-2.00i";
    assertTrue(expected.equals(actual));

    // first operand imaginary and negative, second operand real and positive
    actual = s.evaluate(imagSix, three);
    expected = "-3.00-3.00i";
    assertTrue(expected.equals(actual));

    // first operand real and negative, second operand imaginary and positive
    actual = s.evaluate(negSeven, imagSeven);
    expected = "-7.00-6.00i";
    assertTrue(expected.equals(actual));

    // first operand imaginary and positive, second operand real and negative
    actual = s.evaluate(imagSeven, negEight);
    expected = "8.00+6.00i";
    assertTrue(expected.equals(actual));

    // first operand real and positive, second operand imaginary and negative
    actual = s.evaluate(nine, imagEight);
    expected = "9.00+2.00i";
    assertTrue(expected.equals(actual));

    // both negative, first operand imaginary, second operand real
    actual = s.evaluate(imagSix, negFive);
    expected = "5.00-3.00i";
    assertTrue(expected.equals(actual));

    // both negative, first operand real, second operand imaginary
    actual = s.evaluate(negSix, imagNine);
    expected = "-6.00+7.00i";
    assertTrue(expected.equals(actual));
  }

  /**
   * tests for complex numbers and imaginary numbers as operands.
   */
  @Test
  public void testEvaluateImaginaryComplex()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // both positive, first operand imaginary, second operand complex
    String actual = s.evaluate(imagTwo, "9+6i");
    String expected = "-9.00-3.00i";
    assertTrue(expected.equals(actual));

    // both positive, first operand complex, second operand imaginary
    actual = s.evaluate("8+4i", imagFive);
    expected = "8.00+2.00i";
    assertTrue(expected.equals(actual));

    // first operand imaginary and negative, second operand complex and positive
    actual = s.evaluate(imagSix, "3+6i");
    expected = "-3.00-9.00i";
    assertTrue(expected.equals(actual));

    // first operand complex and negative, second operand imaginary and positive
    actual = s.evaluate("-7-5i", imagSeven);
    expected = "-7.00-11.00i";
    assertTrue(expected.equals(actual));

    // first operand imaginary and positive, second operand complex and negative
    actual = s.evaluate(imagSeven, "-8-3i");
    expected = "8.00+9.00i";
    assertTrue(expected.equals(actual));

    // first operand complex and positive, second operand imaginary and negative
    actual = s.evaluate("9+5i", imagEight);
    expected = "9.00+7.00i";
    assertTrue(expected.equals(actual));

    // both negative, first operand imaginary, second operand complex
    actual = s.evaluate(imagSix, "-5-9i");
    expected = "5.00+6.00i";
    assertTrue(expected.equals(actual));

    // both negative, first operand complex, second operand imaginary
    actual = s.evaluate("-6-4i", imagNine);
    expected = "-6.00+3.00i";
    assertTrue(expected.equals(actual));
  }

  /**
   * tests decimal operands.
   */
  @Test
  public void testDecimalOperands()
  {
    TempContext s = new TempContext(new SubtractionOperator());

    // complex
    String actual = s.evaluate("3.45+7.56i", "2.98+5.04i");
    String expected = "0.47+2.52i";
    assertTrue(actual.equals(expected));

    // imaginary
    actual = s.evaluate("6.42i", "7.75i");
    expected = "0.00-1.33i";
    assertTrue(actual.equals(expected));

    // real
    actual = s.evaluate("3.88", "2.94");
    expected = "0.94+0.00i";
    assertTrue(actual.equals(expected));

    // complex imaginary
    actual = s.evaluate("0.89+7.25i", "3.56i");
    expected = "0.89+3.69i";
    assertTrue(actual.equals(expected));

    // complex real
    actual = s.evaluate("3.39+6.89i", "2.09");
    expected = "1.30+6.89i";
    assertTrue(actual.equals(expected));

    // real imaginary
    actual = s.evaluate("9.06", "2.66i");
    expected = "9.06-2.66i";
    assertTrue(actual.equals(expected));
  }
}
