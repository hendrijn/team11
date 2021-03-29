package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import operations.SubtractionOperator;

/**
 * Unit tests for the Subtraction class.
 * 
 * @author team 11 - may4sa
 * @version Sprint 1
 */
class SubtractionOperatorTest
{

  /*@Test
  public void testEvaluateExtraSpaces()
  {
    SubtractionOperator s = new SubtractionOperator();

    // complex
    String actual = s.evaluate("   6       +      4     i   ", "   2        +       3    i      ");
    String expected = "4+1i";
    assertTrue(actual.equals(expected));

    // imaginary
    actual = s.evaluate("         5        i  ", "         3      i   ");
    expected = "0+2i";
    assertTrue(actual.equals(expected));

    // real
    actual = s.evaluate("         5      ", "         8    ");
    expected = "-3+0i";
    assertTrue(actual.equals(expected));

    // complex and real
    actual = s.evaluate("         9   +     3   i      ", "      4     ");
    expected = "5+3i";
    assertTrue(actual.equals(expected));

    // complex and imaginary
    actual = s.evaluate("         7  + 4    i      ", "         2     i   ");
    expected = "7+2i";
    assertTrue(actual.equals(expected));

    // imaginary and real
    actual = s.evaluate("        2         i     ", "        7    ");
    expected = "-7+2i";
    assertTrue(actual.equals(expected));
  }

  @Test
  public void testEvaluateIllegalArguments()
  {
    SubtractionOperator s = new SubtractionOperator();

    // both illegal
    try
    {
      String illegal = s.evaluate("abcdefg", "hijklmn");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand illegal
    try
    {
      String illegal = s.evaluate("abc-defg", "5i");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand illegal
    try
    {
      String illegal = s.evaluate("2", "hij+klmn");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // test illegal i's
    try
    {
      String illegal = s.evaluate("2", "iiiiiiii");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // test illegal i's with numbers
    try
    {
      String illegal = s.evaluate("2ii", "3");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // single i illegal operand
    try
    {
      String illegal = s.evaluate("i love cs", "5i");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

  }*/

  @Test
  public void testEvaluateComplex()
  {
    SubtractionOperator s = new SubtractionOperator();

    /*// both operands null
    try
    {
      String bothNull = s.evaluate(null, null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand null
    try
    {
      String firstNull = s.evaluate(null, "6+3i");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand null
    try
    {
      String secondNull = s.evaluate("4+5i", null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // both operands empty
    try
    {
      String empty = s.evaluate("", "");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand empty
    try
    {
      String firstEmpty = s.evaluate("", "2+3i");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand empty
    try
    {
      String secondEmpty = s.evaluate("7+5i", "");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // both positive, positive result
    String actual = s.evaluate("4+5i", "2+3i");
    String expected = "2+2i";
    assertTrue(expected.equals(actual));

    // both positive, negative result
    actual = s.evaluate("3+15i", "5+45i");
    expected = "-2-30i";
    assertTrue(expected.equals(actual));

    // negative first operand, negative result
    actual = s.evaluate("-7-55i", "2+15i");
    expected = "-9-70i";
    assertTrue(expected.equals(actual));

    // negative second operand, positive result
    actual = s.evaluate("2+63i", "-5-45i");
    expected = "7+108i";
    assertTrue(expected.equals(actual));

    // both negative, positive result
    actual = s.evaluate("-5-57i", "-7-68i");
    expected = "2+11i";
    assertTrue(expected.equals(actual));

    // both negative, negative result
    actual = s.evaluate("-9-96i", "-2-42i");
    expected = "-7-54i";
    assertTrue(expected.equals(actual));*/
    
    String actual = s.evaluate("3+2i", "2-i");
    String expected = "1-i";
    assertTrue(expected.equals(actual));

  }

  /*@Test
  public void testEvaluateImaginary()
  {
    SubtractionOperator s = new SubtractionOperator();

    // first operand null
    try
    {
      String firstNull = s.evaluate(null, "3i");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand null
    try
    {
      String secondNull = s.evaluate("5i", null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand empty
    try
    {
      String firstEmpty = s.evaluate("", "3i");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand empty
    try
    {
      String secondEmpty = s.evaluate("5i", "");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // both positive, positive result
    String actual = s.evaluate("35i", "12i");
    String expected = "0+23i";
    assertTrue(expected.equals(actual));

    // both positive, negative result
    actual = s.evaluate("15i", "45i");
    expected = "0-30i";
    assertTrue(expected.equals(actual));

    // negative first operand, positive result
    actual = s.evaluate("-25i", "69i");
    expected = "0-94i";
    assertTrue(expected.equals(actual));

    // negative first operand, negative result
    actual = s.evaluate("-55i", "15i");
    expected = "0-70i";
    assertTrue(expected.equals(actual));

    // negative second operand, positive result
    actual = s.evaluate("63i", "-45i");
    expected = "0+108i";
    assertTrue(expected.equals(actual));

    // both negative, positive result
    actual = s.evaluate("-57i", "-68i");
    expected = "0+11i";
    assertTrue(expected.equals(actual));

    // both negative, negative result
    actual = s.evaluate("-96i", "-42i");
    expected = "0-54i";
    assertTrue(expected.equals(actual));

  }

  @Test
  public void testEvaluateReal()
  {
    SubtractionOperator s = new SubtractionOperator();

    // first operand null
    try
    {
      String firstNull = s.evaluate(null, "3");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand null
    try
    {
      String secondNull = s.evaluate("5", null);
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // first operand empty
    try
    {
      String firstEmpty = s.evaluate("", "3");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // second operand empty
    try
    {
      String secondEmpty = s.evaluate("5", "");
      assertTrue(false);
    }
    catch (IllegalArgumentException e)
    {
      assertTrue(true);
    }

    // both positive, positive result
    String actual = s.evaluate("35", "12");
    String expected = "23+0i";
    assertTrue(expected.equals(actual));

    // both positive, negative result
    actual = s.evaluate("15", "45");
    expected = "-30+0i";
    assertTrue(expected.equals(actual));

    // negative first operand, positive result
    actual = s.evaluate("-25", "69");
    expected = "-94+0i";
    assertTrue(expected.equals(actual));

    // negative first operand, negative result
    actual = s.evaluate("-55", "15");
    expected = "-70+0i";
    assertTrue(expected.equals(actual));

    // negative second operand, positive result
    actual = s.evaluate("63", "-45");
    expected = "108+0i";
    assertTrue(expected.equals(actual));

    // both negative, positive result
    actual = s.evaluate("-57", "-68");
    expected = "11+0i";
    assertTrue(expected.equals(actual));

    // both negative, negative result
    actual = s.evaluate("-96", "-42");
    expected = "-54+0i";
    assertTrue(expected.equals(actual));

  }

  @Test
  public void testEvaluateComplexReal()
  {
    SubtractionOperator s = new SubtractionOperator();

    // both positive, first operand complex, second operand real
    String actual = s.evaluate("5+3i", "3");
    String expected = "2+3i";
    assertTrue(expected.equals(actual));

    // both positive, first operand real, second operand complex
    actual = s.evaluate("8", "5+2i");
    expected = "3-2i";
    assertTrue(expected.equals(actual));

    // first operand complex and negative, second operand real and positive
    actual = s.evaluate("-2-3i", "3");
    expected = "-5-3i";
    assertTrue(expected.equals(actual));

    // first operand real and negative, second operand complex and positive
    actual = s.evaluate("-7", "5+6i");
    expected = "-12-6i";
    assertTrue(expected.equals(actual));

    // first operand complex and positive, second operand real and negative
    actual = s.evaluate("4+6i", "-8");
    expected = "12+6i";
    assertTrue(expected.equals(actual));

    // first operand real and positive, second operand complex and negative
    actual = s.evaluate("9", "-4-2i");
    expected = "13+2i";
    assertTrue(expected.equals(actual));

    // both negative, first operand complex, second operand real
    actual = s.evaluate("-2-3i", "-5");
    expected = "3-3i";
    assertTrue(expected.equals(actual));

    // both negative, first operand real, second operand complex
    actual = s.evaluate("-6", "-2-7i");
    expected = "-4+7i";
    assertTrue(expected.equals(actual));

  }

  @Test
  public void testEvaluateImaginaryReal()
  {
    SubtractionOperator s = new SubtractionOperator();

    // both positive, first operand imaginary, second operand real
    String actual = s.evaluate("3i", "3");
    String expected = "-3+3i";
    assertTrue(expected.equals(actual));

    // both positive, first operand real, second operand imaginary
    actual = s.evaluate("8", "2i");
    expected = "8-2i";
    assertTrue(expected.equals(actual));

    // first operand imaginary and negative, second operand real and positive
    actual = s.evaluate("-3i", "3");
    expected = "-3-3i";
    assertTrue(expected.equals(actual));

    // first operand real and negative, second operand imaginary and positive
    actual = s.evaluate("-7", "6i");
    expected = "-7-6i";
    assertTrue(expected.equals(actual));

    // first operand imaginary and positive, second operand real and negative
    actual = s.evaluate("6i", "-8");
    expected = "8+6i";
    assertTrue(expected.equals(actual));

    // first operand real and positive, second operand imaginary and negative
    actual = s.evaluate("9", "-2i");
    expected = "9+2i";
    assertTrue(expected.equals(actual));

    // both negative, first operand imaginary, second operand real
    actual = s.evaluate("-3i", "-5");
    expected = "5-3i";
    assertTrue(expected.equals(actual));

    // both negative, first operand real, second operand imaginary
    actual = s.evaluate("-6", "-7i");
    expected = "-6+7i";
    assertTrue(expected.equals(actual));

  }

  @Test
  public void testEvaluateImaginaryComplex()
  {
    SubtractionOperator s = new SubtractionOperator();

    // both positive, first operand imaginary, second operand complex
    String actual = s.evaluate("3i", "9+6i");
    String expected = "-9-3i";
    assertTrue(expected.equals(actual));

    // both positive, first operand complex, second operand imaginary
    actual = s.evaluate("8+4i", "2i");
    expected = "8+2i";
    assertTrue(expected.equals(actual));

    // first operand imaginary and negative, second operand complex and positive
    actual = s.evaluate("-3i", "3+6i");
    expected = "-3-9i";
    assertTrue(expected.equals(actual));

    // first operand complex and negative, second operand imaginary and positive
    actual = s.evaluate("-7-5i", "6i");
    expected = "-7-11i";
    assertTrue(expected.equals(actual));

    // first operand imaginary and positive, second operand complex and negative
    actual = s.evaluate("6i", "-8-3i");
    expected = "8+9i";
    assertTrue(expected.equals(actual));

    // first operand complex and positive, second operand imaginary and negative
    actual = s.evaluate("9+5i", "-2i");
    expected = "9+7i";
    assertTrue(expected.equals(actual));

    // both negative, first operand imaginary, second operand complex
    actual = s.evaluate("-3i", "-5-9i");
    expected = "5+6i";
    assertTrue(expected.equals(actual));

    // both negative, first operand complex, second operand imaginary
    actual = s.evaluate("-6-4i", "-7i");
    expected = "-6+3i";
    assertTrue(expected.equals(actual));
  }

  @Test
  public void testDistribute()
  {
    SubtractionOperator s = new SubtractionOperator();

    // both positive, first operand complex, second operand real
    String actual = s.distribute("6+3i");
    String expected = "-6+-3i";
    assertTrue(expected.equals(actual));
  }

  @Test
  public void testFormat()
  {
    SubtractionOperator s = new SubtractionOperator();

    String actual = s.format("3-6i");
    String expected = "3+-6i";
    assertTrue(actual.equals(expected));

    actual = s.format("3+6i");
    expected = "3+6i";
    assertTrue(actual.equals(expected));

    actual = s.format("3");
    expected = "3+0i";
    assertTrue(actual.equals(expected));

    actual = s.format("3i");
    expected = "0+3i";
    assertTrue(actual.equals(expected));

    actual = s.format("-3");
    expected = "-3+0i";
    assertTrue(actual.equals(expected));

    actual = s.format("-3i");
    expected = "0+-3i";
    assertTrue(actual.equals(expected));
  }*/

}
