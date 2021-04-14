package testing;

import gui.InterfaceController;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for parentheses handling.
 * 
 * @author willmsca
 * @version Sprint 2
 */
public class ParenthesesTest
{

  /**
   * test paren handling.
   */
  @Test
  public void parenthesesTest()
  {
    String s1 = "3";
    String s2 = "(3+2i)";
    String s3 = "(3";
    String s4 = "((()";

    assertFalse(InterfaceController.inParentheses(s1));
    assertFalse(InterfaceController.inParentheses(s2));
    assertTrue(InterfaceController.inParentheses(s3));
    assertTrue(InterfaceController.inParentheses(s4));
    assertTrue(InterfaceController.inParentheses("<html>(3"));
  }
}
