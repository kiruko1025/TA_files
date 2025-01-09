import java.util.*;
public class Taylor {

  /**
   * Approximating Square root
   * The approximation is iterative and so the number of
   * terms that added after sqrt(base) is given as well.
   * @param	base	the parameter number one
   * @param	delta	the parameter number two; desired to be small
   * @param	square_root	the square root of base
   * @param	num_terms	the number of terms, as as int
   */
  public static double approximate_square_root(
      double base, double delta, double square_root, int num_terms ) {

    /* *** variables for computing the derivative
     *
     * The initial values for the parameters are as follows:
     *   approx <- square_root
     *   factorial <- 1
     *   coefficient <- 1.0
     *   exponent <- 0.5
     *   power <- sqaure_root
     *   delta_power <- 1.0
     *
     * These quantities are updated at each round:
     *   coefficient <- multiplied by exponent
     *   exponent <- decreased by 1.0
     *   power <- divided by base
     *   derivative <- coefficient * power
     *
     *   factorial <- multiply by round
     *   delta_power <- multiply by delta
     *
     *   term <- derivative * delta_power / factorial
     *
     *   approx <- add term
     */

    //----- variable declarations
    double coefficient, exponent, power, derivative;
    long factorial;
    double delta_power, term, approx;
    double expected;
    double true_input;

    /* compute the true_input and report it
     * then compute the true value of the function
     */
    true_input = base + delta;
    System.out.printf(
        "---- the square root of %.5f + %.5f -----%n",
         base, delta );
    expected = Math.sqrt( true_input );

    // initialization
    coefficient = 1.0;
    exponent = 0.5;
    factorial = 1;
    power = square_root;
    delta_power = 1.0;
    approx = square_root;

    // iteration
    for ( int round = 1; round <= num_terms; round ++ ) {
      coefficient *= exponent;
      exponent -= 1;
      power /= base;
      derivative = coefficient * power;
      factorial *= round;
      delta_power *= delta;
      term = derivative * delta_power / factorial;
      approx += term;
      System.out.printf( "Round=%02d,approx=%.15f%n", round, approx );
    }
    // reporting
    System.out.println( "-----------------------------------------------" );
    System.out.printf( "  Expected     =%.15f%n", expected );
    System.out.printf( "  Approximation=%.15f%n%n", approx );
    return approx;
  }

  /**
   * Approximating cubic root
   * The approximation is iterative and so the number of
   * terms that added after cubic(base) is given as well.
   * @param	base	the parameter number one
   * @param	delta	the parameter number two; desired to be small
   * @param	cubic_root	the cubic root of base
   * @param	num_terms	the number of terms, as as int
   */
  public static double approximate_cubic_root(
      double base, double delta, double cubic_root, int num_terms ) {

    /* *** variables for computing the derivative
     *
     * The initial values for the parameters are as follows:
     *   approx <- square_root
     *   factorial <- 1
     *   coefficient <- 1.0
     *   exponent <- 0.333333333333333333333333333333333
     *   power <- cubic_root
     *   delta_power <- 1.0
     *
     * These quantities are updated at each round:
     *   coefficient <- multiplied by exponent
     *   exponent <- decreased by 1.0
     *   power <- divided by base
     *   derivative <- coefficient * power
     *
     *   factorial <- multiply by round
     *   delta_power <- multiply by delta
     *
     *   term <- derivative * delta_power / factorial
     *
     *   approx <- add term
     */

    //----- variable declarations
    double coefficient, exponent, power, derivative;
    long factorial;
    double delta_power, term, approx;
    double expected;
    double true_input;

    /* compute the true_input and report it
     * then compute the true value of the function
     */
    true_input = base + delta;
    System.out.printf(
        "---- the square root of %.5f + %.5f -----%n",
         base, delta );
    expected = Math.cbrt( true_input );

    // initialization
    coefficient = 1.0;
    exponent = 1.0/3.0;
    factorial = 1;
    power = cubic_root;
    delta_power = 1.0;
    approx = cubic_root;

    // iteration
    for ( int round = 1; round <= num_terms; round ++ ) {
      coefficient *= exponent;
      exponent -= 1;
      power /= base;
      derivative = coefficient * power;
      factorial *= round;
      delta_power *= delta;
      term = derivative * delta_power / factorial;
      approx += term;
      System.out.printf( "Round=%02d,approx=%.15f%n", round, approx );
    }
    // reporting
    System.out.println( "-----------------------------------------------" );
    System.out.printf( "  Expected     =%.15f%n", expected );
    System.out.printf( "  Approximation=%.15f%n%n", approx );
    return approx;
  }


  /**
   * Approximating logarithm
   * The parameter to the root function is one value, diff;
   * that is, we need to approximate the logarithmic of 1 + diff.
   * This value is given as the first parameter.
   * The approximation is iterative and so the number of terms.
   * @param	diff	the parameter number two; desired to be small
   * @param	num_terms	the number of terms, as as int
   */
  public static double approximate_logarithm(
      double diff, int num_terms ) {
    double diff_power, term, approx;
    double expected;
    double true_input;

    /* *** variables for computing the derivative
     *
     * The initial values for the parameters are as follows:
     *   approx <- 0, which is Math.log( 1.0 )
     *   diff_power <- 1.0
     *
     * These quantities are updated at each round:
     *   diff_power = diff^round, so
     *   diff_power <- multiplied by diff
     *
     *   term <- diff_power / round
     *
     *   approx <- add term if round is even, subtract term o.w.
     */
    /* compute the true_input and report it
     * then compute the true value of the function
     */
    true_input = 1.0 + diff;
    System.out.printf(
        "---- the logarithm of %.5f + %.5f -----%n",
         1.0, diff );
    expected = Math.log( 1.0 + diff );

    // initialization
    diff_power = 1.0;
    approx = 0.0;

    // iteration
    for ( int round = 1; round <= num_terms; round ++ ) {
      diff_power = diff_power * diff;
      term = diff_power / round;
      if ( round % 2 == 0 ) {
        approx = approx - term;
      }
      else {
        approx = approx + term;
      }
      System.out.printf( "Round=%02d,approx=%.15f%n", round, approx );
    }
    // reporting
    System.out.println( "-----------------------------------------------" );
    System.out.printf( "  Expected     =%.15f%n", expected );
    System.out.printf( "  Approximation=%.15f%n%n", approx );
    return approx;
  }

  /**
   * Process one approximation
   * The user chooses from th three functions to use.
   */
  public static void oneChoice() {
    Scanner keyboard;
    int choice, num_terms;
    double base, delta;

    keyboard = new Scanner( System.in );

    System.out.println( "Which approximation do you want to compute?" );
    System.out.println( "1. Square Root" );
    System.out.println( "2. Cubic Root" );
    System.out.println( "3. Logarithm" );

    System.out.print( "Enter your choice: " );
    choice = keyboard.nextInt();
    if ( choice < 1 || choice > 3 ) {
      System.out.println( "An invalid choice." );
    }
    else {
      if ( choice != 3 ) {
        System.out.print( "Enter the value of base: " );
        base = keyboard.nextDouble();
      }
      else {
        base = 1.0;
      }
      System.out.print( "Enter the value of delta: " );
      delta = keyboard.nextDouble();
      System.out.print( "Enter the number of terms: " );
      num_terms = keyboard.nextInt();
      switch ( choice ) {
        case 1: approximate_square_root(
            base, delta, Math.sqrt(base), num_terms ); break;
        case 2: approximate_cubic_root(
            base, delta, Math.cbrt(base), num_terms ); break;
        case 3: approximate_logarithm( delta, num_terms ); break;
      }
    }
  }

  /**
   * the main
   */
  public static void main( String[] args ) {
    oneChoice();
  }
}
