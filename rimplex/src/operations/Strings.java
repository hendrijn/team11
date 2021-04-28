package operations;

import gui.NewMainInterface;

/**
 * String literals used by the operations in the operation package.
 * 
 * @author may4sa
 * @version Sprint 3
 */
public interface Strings
{
  /**
   * invalid operand error message.
   */
  static final String INVALID = "NOT_VALID_OPERAND";
  /**
   * no operand error message.
   */
  static final String NO_OPERAND = "NO_OPERAND";
  /**
   * simplify operand error message.
   */
  static final String SIMPLIFY = "VALID_OR_SIMPLIFY";
  /**
   * provide two operands error message.
   */
  static final String TWO_OPERANDS = "TWO_OPERANDS";
  /**
   * format string for doubles.
   */
  static final String FORM = "%.2f";
  /**
   * plus sign String literal.
   */
  static final String PLUS = "+";
  /**
   * i String literal.
   */
  static final String I = "i";
  /**
   * negative i String literal.
   */
  static final String NEGATIVE_I = "-i";
  /**
   * minus String literal.
   */
  static final String MINUS = "-";
  /**
   * plus minus String literal.
   */
  static final String PLUS_MINUS = "+-";
  /**
   * space String literal.
   */
  static final String SPACE = " ";
  /**
   * open parentheses String literal.
   */
  static final String OPEN_PAREN = "(";
  /**
   * closed parentheses String literal.
   */
  static final String CLOSED_PAREN = ")";
  /**
   * base of one with a zero imaginary number.
   */
  static final String ZERO_BASE = "1.00+0.00i";
  /**
   * the String literal of the integer one.
   */
  static final String ONE = "1";
  /**
   * the String literal of the integer negative one.
   */
  static final String NEG_ONE = "-1";
  /**
   * the main interface used to access the STRINGS attribute of the NewMainInterface class.
   */
  static NewMainInterface UI = NewMainInterface.getInstance();
}
