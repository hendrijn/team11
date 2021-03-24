package operations;


/**
 * This is class that provides context for swapping between Operators, following the Strategy
 * pattern. This class may or may not prove to be redudant and therefore was named tempContext
 * at its inception.
 * @author pgleb
 * @version 1.0.
 *
 */
public class TempContext
{
  
  private Operator operator;
  
  
  /**
   * Constructs a context with a certain operator (addition or subtraction).
   * @param operator Addition or subtraction operator.
   */
  public TempContext(Operator operator) 
  {
    this.operator = operator;
  }
  
  
  /**
   * Performs the necessary operator evaluation.
   * @param leftOperand The left operand the operation is to be performed on. 
   * @param rightOperand The right operand the operation is to be performed on. 
   * @return The result of the performing the evaluation on the two operands as a String.
   */
  public String evaluate(String leftOperand, String rightOperand) 
  {
    return operator.evaluate(leftOperand, rightOperand);
  }

}
