import java.util.*;
public class LinEq{
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
    System.out.print( a + " x + " + b + " y = " + p );
    System.out.print( " and " );
    System.out.println( c + " x + " + d + " y = " + q );
    System.out.println( "The solution is (" + x + ", " + y + ")" );
  }
}
