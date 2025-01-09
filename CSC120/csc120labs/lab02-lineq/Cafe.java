import java.util.*;
public class Cafe {
  public static void main( String[] args ) {

    int pastries, coffees, special_drinks, sandwiches;
    double subtotal, tax, total;

    Scanner keyboard = new Scanner( System.in );

    System.out.println( "Welcome to Caroline's!" );
    System.out.println( "Here is our menu:" );
    System.out.println( "-- Pastries are 5.5 dollars each." );
    System.out.println( "-- Coffees are 3.0 dollars each." );
    System.out.println( "-- Special Drinks are 6.0 dollars each." );
    System.out.println( "-- Sandwiches are 6.5 dollars each." );
    subtotal = 0;

    System.out.print( "How many pastries? " );
    pastries = keyboard.nextInt();
    subtotal = subtotal + pastries * 5.5;
    System.out.println( "Subtotal: " + subtotal + " dollars." );

    System.out.print( "How many coffees? " );
    coffees = keyboard.nextInt();
    subtotal = subtotal + coffees * 3.0;
    System.out.println( "Subtotal: " + subtotal + " dollars." );

    System.out.print( "How many special drinks? " );
    special_drinks = keyboard.nextInt();
    subtotal = subtotal + special_drinks * 6.0;
    System.out.println( "Subtotal: " + subtotal + " dollars." );

    System.out.print( "How many sandwiches? " );
    sandwiches = keyboard.nextInt();
    subtotal = subtotal + sandwiches * 6.5;
    System.out.println( "Subtotal: " + subtotal + " dollars." );

    tax = (int)( subtotal * 0.07 * 100) / 100.0;
    total = subtotal + tax;
    System.out.println( "Tax: " + tax + " dollars." );
    System.out.println( "Total: " + total + " dollars." );
    System.out.println( "Thank you for stopping by. Take care!" );
  }
}
