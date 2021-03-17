package util;

import java.util.List;

/**
 * A utility class that performs checks of various kinds.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version 1.2 See Git commit history - Bob
 */
public class Check
{
  /**
   * Check to see if an array of String objects contains a particular
   * String.
   * 
   * @param haystack  The array of String objects to search through
   * @param needle The String object to search for
   * @return true if haystack contains needle; false otherwise
   */
  public static boolean forContains(final String[] haystack, final String needle)
  {
    for (int i=0; i<haystack.length; i++)
    {

      if (haystack[i].equals(needle)) return true;

      if (haystack[i].equalsIgnoreCase(needle)) return true;
    }
    return false;
  }
  //Create a method named forContains() that is passed a 
  //List<String> and String and uses the equals() method.
  public static boolean forContains(List<String> list, String s) 
  {
	  for (int i=0; i<list.size(); i++)
	    {
	      if (list.get(i).equals(s)) return true;

	      if (list.get(i).equalsIgnoreCase(s)) return true;
	    }
	  return false;
  }
}