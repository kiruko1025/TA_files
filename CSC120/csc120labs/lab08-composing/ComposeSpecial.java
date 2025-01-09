import java.util.*;
public class ComposeSpecial {
  /**
   * Compute the GCD
   * @param	number1	input 1
   * @param	number2 input 2
   * @return	the gcd of the two numbers
   */
  public static long compute_gcd( long number1, long number2 ) {
    long smaller, bigger, temporary;
    //---- trivial cases
    if ( number1 <= 0 || number2 <= 0 ) {
      return 0;
    }
    //---- initialization
    smaller = number1;
    bigger = number2;
    //---- the main loop
    while ( smaller != 0 ) {
      if ( smaller >= bigger ) {
        smaller = smaller % bigger;
      }
      else {
        temporary = smaller;
        smaller = bigger;
        bigger = temporary;
      }
    }
    return bigger;
  }

  /**
   * @return	whether or not the input number is a prime
   * @param	base_integer	the number to be tested.
   */
  private static boolean isPrime( int base_integer ) {
    int divisor;

    divisor = 2;
    while ( divisor < base_integer && base_integer % divisor != 0 ) {
      divisor ++;
    }
    return divisor == base_integer;
  }

  /**
   * @return	a long value equal to the base^exponent
   * @param	base_integer	the base number
   * @param	exponent	the exponent number
   */
  private static long power( int base_integer, int exponent ) {
    long x;

    x = 1;
    for ( int j = 1; j <= exponent; j ++ ) {
      x *= base_integer;
    }
    return x;
  }

  /**
   *  Convert an expression to a long value
   * @return	the value represented in the expression
   * @param	w	the input expression
   */
  private static long convert( String w ) {
    /* w will be reused
     * w is preprocessed
     * replace "**" with "^"
     * replace "*" with " * " and "^" with " ^ " to separate tokens
     * append " *" at the end as an endmarker
     */
    w = w.replace( "**", "^" );
    w = w.replace( "*", " * " ).replace( "^", " ^ " );
    w = w + " *";

    Scanner sc;
    long result;
    int prevBase, base_integer, exponent;
    String operand;

    // initialization
    result = 1;
    sc = new Scanner( w );
    prevBase = 1;
    base_integer = 1;

    /*
     * each number block is either
     *     base_integer_integer * or
     *     base_integer_integer ^ exponent *
     * the base_integer_integer must be a prime number, and
     * exponent must be a positive integer
     */

    // the loop
    while ( sc.hasNext() ) {
      // read an integer and an operation
      base_integer = sc.nextInt();
      operand = sc.next();
      /* if the operation is caret, read exponenti
       * and an operation
       * otherwise, set exponent to 1
       */
      if ( operand.equals( "^" ) ) {
        exponent = sc.nextInt();
        operand = sc.next();
      }
      else if ( operand.equals( "*" ) ) {
        exponent = 1;
      }
      else {
        throw new IllegalArgumentException(
            "Unsupported operation " + operand );
      }

      // error checks
      if ( exponent <= 0 ) {
        throw new IllegalArgumentException(
            "Non-positive exponent " + exponent );
      }
      if ( !isPrime( base_integer ) ) {
        throw new IllegalArgumentException(
            "Non-prime base_integer " + base_integer );
      }
      if ( prevBase >= base_integer ) {
        throw new IllegalArgumentException(
            "No increase in the base_integer " +
                prevBase + " >= " + base_integer );
      }

      // update and result
      result = result * power( base_integer, exponent );

      // update prevBase and result
      prevBase = base_integer;
    }  
    return result;
  }

  public static void main( String[] args ) {
    Scanner keyboard = new Scanner( System.in );
    String input, numerator_input, denominator_input;
    int div_position;

    long numerator, denominator, gcd;

    System.out.print( "Enter an expression: " );

    while ( keyboard.hasNext() ) {
      input = keyboard.nextLine();
      div_position = input.indexOf( "/" );
      if ( div_position < 0 ) {
        numerator_input = input;
        denominator_input = "";
      }
      else {
        numerator_input = input.substring( 0, div_position );
        denominator_input = input.substring( div_position + 1 );
      }
      numerator = convert( numerator_input );
      denominator = convert( denominator_input );
      gcd = compute_gcd( numerator, denominator );
      numerator /= gcd;
      denominator /= gcd;
      System.out.printf( "The number is %d / %d.%n",
          numerator, denominator );
      System.out.print( "Enter an expression: " );
    }
    System.out.println();
  }
}
