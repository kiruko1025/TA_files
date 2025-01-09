import java.util.*;
public class LinEqPrintF {
  public static final String MESSAGE =
      "This program solves systems of linear equations\n" +
      "ax + by = p, cx + dy = q\n";

  public static void main( String[] args ) {

    double a, b, c, d, p, q, det, x, y;

    Scanner keyboard = new Scanner( System.in );

    System.out.print( MESSAGE );
    System.out.print( "Enter a, b, and p: " );
    a = keyboard.nextDouble();
    b = keyboard.nextDouble();
    p = keyboard.nextDouble();
    System.out.print( "Enter c, d, and q: " );
    c = keyboard.nextDouble();
    d = keyboard.nextDouble();
    q = keyboard.nextDouble();
    det = a * d - b * c;
    x = ( d * p - b * q ) / det;
    y = ( a * q - c * p ) / det;
    System.out.println( "The equations are:" );
    System.out.printf( "%f x + %f y = %f", a, b, p );
    System.out.print( " and " );
    System.out.printf( "%f x + %f y = %f%n", c, d, q );
    System.out.printf( "The solution is (%f, %f)%n", x, y );
  }
}
