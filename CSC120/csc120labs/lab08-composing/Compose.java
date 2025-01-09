import java.util.*;
public class Compose {

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
    String input;
    long theNumber;

    System.out.print( "Enter an expression: " );

    while ( keyboard.hasNext() ) {
      input = keyboard.nextLine();
      theNumber = convert( input );
      System.out.printf( "The number is %d.%n", theNumber );
      System.out.print( "Enter an expression: " );
    }
    System.out.println();
  }
}
