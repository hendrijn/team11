package gui;

import java.util.ArrayList;
import java.util.List;

/**
 * Houses all finals for the interface.
 * 
 * @author jacquelynhendricks
 *
 */
public interface Finals
{
  static final String RESET = "R";
  static final String CLEAR = "C";
  static final String ADD = "+";
  static final String BACKSPACE = "←";
  static final String SUBTRACT = "-";
  static final String MULTIPLY = "×";
  static final String PMULTIPLY = "*";
  static final String DIVIDE = "÷";
  static final String PDIVIDE = "/";
  static final String EQUALS = "=";
  static final String SIGN = "±";
  static final String INVERSE = "Inv";
  static final String RPARTS = "Real";
  static final String IPARTS = "Imag";
  static final String LPAREN = "(";
  static final String RPAREN = ")";
  static final String DECIMAL = ".";
  static final String SP = " ";
  static final String EMPTY = "";
  static final String I = "<i>i</i>";
  static final String HTML = "<html>";
  static final String FILE = "File";
  static final String ADDTOREC = "Add to Recording";
  static final String START = "Start Recording";
  static final String PAUSE = "Pause Recording";
  static final String STOP = "Stop Recording";
  static final String ABOUT = "About";

  static final String[] FILEMENUITEMS = {ADDTOREC, START, PAUSE, STOP};

  static final String[] FUNCTIONS = {ADD, RESET, SUBTRACT, INVERSE, MULTIPLY, LPAREN, DIVIDE,
      RPAREN, EQUALS, DECIMAL};

}
