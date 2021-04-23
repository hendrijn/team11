package operations;

public class ImaginaryPartOperator
{
  private final String FORM = "%.2f";

  public String evaluate(String operand)
  {

    if (operand == null || operand.equals(""))
    {
      throw new IllegalArgumentException("Please enter an operand");
    }

    String alteredOp = ((operand.replaceAll(" ", "")).replace("(", "")).replace(")", "");
    String result = "";
    if (alteredOp.equals(""))
    {
      throw new IllegalArgumentException("Please enter an operand");
    }

    long iCount = alteredOp.chars().filter(ch -> ch == 'i').count();
    if (iCount > 1 || alteredOp.isEmpty() || alteredOp.equals("()"))
    {
      throw new IllegalArgumentException("Please provide a valid operand, or simplify it.");
    }

    try
    {
      Double.parseDouble(((alteredOp.replace("i", "")).replace("+", "")).replaceAll("-", ""));
    }
    catch (NumberFormatException nfe)
    {
      throw new IllegalArgumentException("Please provide a valid operand, or simplify it.");
    }

    boolean isComplex = TempContext.isComplex(alteredOp);
    boolean isImaginary = TempContext.isImaginary(alteredOp);
    boolean isReal = TempContext.isReal(alteredOp);

    int negativeMinus = alteredOp.indexOf('-');
    int minus = alteredOp.indexOf('-', negativeMinus + 1);

    if (isComplex)
    {
      if (alteredOp.contains("-") && minus != -1)
      {

        result = String.format(FORM, Double.parseDouble(alteredOp.substring(minus, alteredOp.indexOf('i')))) + "i";

      }
      else if (alteredOp.contains("+"))
      {
        result = String.format(FORM,
            Double.parseDouble(alteredOp.substring(alteredOp.indexOf('+') + 1, alteredOp.indexOf('i')))) + "i";
      }
      else
      {
        result = String.format(FORM, Double.parseDouble(alteredOp.substring(negativeMinus, alteredOp.indexOf('i')))) + "i";
      }
    }

    if (isImaginary)
    {
      result = String.format(FORM, Double.parseDouble(alteredOp.substring(0, alteredOp.indexOf('i')))) + "i";
    }

    if (isReal)
    {
      result = String.format(FORM, 0.0) + "i";
    }
    return result;
  }
}
