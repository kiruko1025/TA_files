import java.util.*;
/**
 * Decompose a number
 */
public class Factor {

  /**
   * Return a string reporting all the prime factors
   * @param	input	the input integer (>= 2 )
   */
  public static String  factor( int input ) {
    StringBuilder builder;
    int need_to_factor, divisor;

    builder = new StringBuilder();
    builder.append( "The factorization is: " );

    need_to_factor = input;	// the input number to be reduced to 1
    divisor = 2;	// the starting candidate factor
    while ( need_to_factor > 1 ) {
      while ( need_to_factor % divisor == 0 ) {
        if ( need_to_factor < input ) {
          builder.append( " * " );
        }
        // the * is needed for the second factor on
        builder.append( divisor );
        need_to_factor /= divisor;
      }
      divisor ++;
    }
    return builder.toString();
  }

  /**
   * Return a string reporting all the prime factors
   * @param	input	the input integer (>= 2 )
   */
  public static String factor2( int input ) {
    StringBuilder builder;
    int need_to_factor, divisor, exponent;

    builder = new StringBuilder();
    builder.append( "The compact factorization is: " );

    need_to_factor = input;	// the input number to be reduced to 1
    divisor = 2;	// the starting candidate factor
    while ( need_to_factor > 1 ) {
      if ( need_to_factor % divisor == 0 ) {
        if ( need_to_factor < input ) {
          builder.append( " * " );
        }
        exponent = 0;
        while ( need_to_factor % divisor == 0 ) {
          need_to_factor /= divisor;
          exponent ++;
        }
        builder.append( divisor );
        if ( exponent > 1 ) builder.append( "^" + exponent );
      }
      divisor ++;
    }
    return builder.toString();
  }

  /**
   * Find all nontrival divisors
   * @param	input	the input integer (>= 2 )
   * @return 	expression
   */
  public static String allDivisors( int input ) {
    StringBuilder builder;
    int divisor_count;

    builder = new StringBuilder();
    builder.append( " nontrivial divisors: " );

    divisor_count = 0;

    /* Use a simple iteration of divisor candidates, from
     * 2 to the input minus 1. Report the divisors as they
     * are found with their indices.
     */
    for ( int candidate = 2; candidate <= input - 1; candidate ++ ) {
      if ( input % candidate == 0 ) {
        divisor_count ++;
        if ( divisor_count > 1 ) {
          builder.append( ", " );
        }
        builder.append( candidate );
      }
    }
    builder.insert( 0, divisor_count );

    return builder.toString();
  }

  public static void main( String[] args ) {
    Scanner keyboard;
    int input;
    String result;

    keyboard = new Scanner( System.in );
    input = 2;

    while ( input >= 2 ) {
      System.out.println();
      System.out.println(
           "Enter an integer (an integer <= 1 will stop the program)" );
      System.out.print(
           "Your number: " );
      input = keyboard.nextInt();
      if ( input >= 2 ) {
        result = factor( input );
        System.out.println( result );
        result = factor2( input );
        System.out.println( result );
        result = allDivisors( input );
        System.out.println( result );
      }
    }
  }
}
