import java.util.*;

public class GCD {
  public static int compute( int number1, int number2 ) {
    int smaller, bigger, temporary;

    if ( number1 <= 0 || number2 <= 0 ) {
      return 0;
    }
    smaller = number1;
    bigger = number2;
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

  public static void main( String[] args ) {
    Scanner keyboard;
    int number1, number2, theGCD;

    keyboard = new Scanner( System.in );
    System.out.print( "Enter two integers: " );
    number1 = keyboard.nextInt();
    number2 = keyboard.nextInt();
    theGCD = compute( number1, number2 );
    System.out.printf( "The GCD of %d and %d is %d.%n",
         number1, number2, theGCD );
  }
}
