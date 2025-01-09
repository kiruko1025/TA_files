import java.util.*;
public class TaylorAll {

  public static void expandExp( double x, int n ) {
    System.out.printf( "---Approximation of exp(%f)---%n", x );
    double fraction = x;
    double sum = 1.0 + x;
    for ( int k = 2; k <= n; k ++ ) {
      fraction = fraction * x / k;
      sum += fraction;
      System.out.printf( "%3d:%.15f%n", k, sum );
    }
    System.out.printf( "Math.exp(%f): %.15f%n", x, Math.exp( x ) );
  }

  public static void expandSin( double x, int n ) {
    System.out.printf( "---Approximation of sin(%f)---%n", x );
    double fraction = x;
    double sum = x;
    for ( int k = 2; k <= n; k ++ ) {
      fraction = fraction * x / k;
      if ( k % 4 == 1 ) sum += fraction;
      else if ( k % 4 == 3 ) sum -= fraction;
      System.out.printf( "%3d:%.15f%n", k, sum );
    }
    System.out.printf( "Math.sin(%f): %.15f%n", x, Math.sin( x ) );
  }

  public static void expandLog( double x, int n ) {
    System.out.printf( "---Approximation of log(1+%f)---%n", x );
    double fraction = x; 
    double sum = x;
    double derivative = 1.0;
    for ( int k = 2; k <= n; k ++ ) {
      derivative *= -( k - 1 );
      fraction = fraction * x / k;
      sum += fraction * derivative;
      System.out.printf( "%3d:%.15f%n", k, sum );
    }
    System.out.printf( "Math.log(1+%f): %.15f%n", x, Math.log(1+x) );
  }
  public static void main( String[] args ) {
    Scanner keyboard = new Scanner( System.in );
    double x;
    int n;
    for ( int m = 1; m <= 3; m ++ ) {
      switch ( m ) {
        case 1: System.out.print( "For exp(x), " ); break;
        case 2: System.out.print( "For sin(x), " ); break;
        case 3: System.out.print( "For log(1 + x), " ); break;
      }
      System.out.print( "enter x (|x|<1.0) and n: " );
      x = keyboard.nextDouble();
      n = keyboard.nextInt();
      if ( Math.abs( x ) >= 1.0 ) System.out.println( "|x| >= 1.0" );
      else {
        switch ( m ) {
          case 1: expandExp( x, n ); break;
          case 2: expandSin( x, n ); break;
          case 3: expandLog( x, n ); break;
        }
      }
    }
  }
}
