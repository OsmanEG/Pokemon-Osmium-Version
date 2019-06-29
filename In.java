import java.io.*;
import java.text.*;

public class In
{
  static InputStreamReader r = new InputStreamReader(System.in);
  static BufferedReader br = new BufferedReader(r);

  // Read a String from standard system input
  public static String getString()
  {
    try
    {
      return br.readLine();
    }
    catch (Exception e)
    {
      return "";
    }
  }

  // Read a Number as a String from standard system input
  // Return the Number
  public static Number getNumber()
  {
    String numberString = getString();
    try
    {
      numberString = numberString.trim().toUpperCase();
      return NumberFormat.getInstance().parse(numberString );
    }
    catch (Exception e)
    {
      // If any exception occurs, just return zero
      return new Integer(0);
    }
  }

  // Read an int from standard system input
  public static int getInt ()
  {
    return getNumber().intValue();
  }

  // Read a long from standard system input
  public static long getLong ()
  {
    return getNumber().longValue();
  }

  // Read a float from standard system input
  public static float getFloat ()
  {
    return getNumber().floatValue();
  }

  // Read a double from standard system input
  public static double getDouble ()
  {
    return getNumber().doubleValue();
  }

  // Read a char from standard system input
  public static char getChar ()
  {
    String s = getString();
    if (s.length() >= 1)
      return s.charAt(0);
    else
      return '\n';
  }

}

