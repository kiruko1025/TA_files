import java.util.*;
public class Comparison {

  public static void report( String x, double a ) {
    System.out.printf( "%s for %.2f%n", x, a );
  }

  public static void find1st(
      String x1, double a1,
      String x2, double a2,
      String x3, double a3,
      String x4, double a4 ) {
    double m = Math.min( Math.min( a1, a2 ), Math.min( a3, a4 ) );
    if ( m == a1 ) {
      report( x1, m );
      find2nd( x2, a2, x3, a3, x4, a4 );
    }
    else if ( m == a2 ) {
      report( x2, m );
      find2nd( x1, a1, x3, a3, x4, a4 );
    }
    else if ( m == a3 ) {
      report( x3, m );
      find2nd( x1, a1, x2, a2, x4, a4 );
    }
    else { // m == a4
      report( x4, m );
      find2nd( x1, a1, x2, a2, x3, a3 );
    }
  }

  public static void find2nd(
      String x1, double a1,
      String x2, double a2,
      String x3, double a3 ) {
    double m = Math.min( Math.min( a1, a2 ), a3 );
    if ( m == a1 ) {
      report( x1, m );
      find3rdAnd4th( x2, a2, x3, a3 );
    }
    else if ( m == a2 ) {
      report( x2, m );
      find3rdAnd4th( x1, a1, x3, a3 );
    }
    else {
      report( x3, m );
      find3rdAnd4th( x1, a1, x2, a2 );
    }
  }

  public static void find3rdAnd4th(
      String x1, double a1,
      String x2, double a2 ) {
    double m = Math.min( a1, a2 );
    if ( m == a1 ) {
      report( x1, a1 );
      report( x2, a2 );
    }
    else {
      report( x2, a2 );
      report( x1, a1 );
    }
  }

  public static void main( String[] args ) {
    Scanner keyboard;
    String name1, name2, name3, name4;
    double height1, height2, height3, height4;
    double weight1, weight2, weight3, weight4;
    double bmi1, bmi2, bmi3, bmi4;

    keyboard = new Scanner( System.in );

    System.out.print( "Name, Height, Weight for Person 1: " );
    name1 = keyboard.next();
    height1 = keyboard.nextDouble();
    weight1 = keyboard.nextDouble();
    bmi1 = 703.0 * weight1 / Math.pow( height1, 2 );

    System.out.print( "Name, Height, Weight for Person 2: " );
    name2 = keyboard.next();
    height2 = keyboard.nextDouble();
    weight2 = keyboard.nextDouble();
    bmi2 = 703.0 * weight2 / Math.pow( height2, 2 );

    System.out.print( "Name, Height, Weight for Person 3: " );
    name3 = keyboard.next();
    height3 = keyboard.nextDouble();
    weight3 = keyboard.nextDouble();
    bmi3 = 703.0 * weight3 / Math.pow( height3, 2 );

    System.out.print( "Name, Height, Weight for Person 4: " );
    name4 = keyboard.next();
    height4 = keyboard.nextDouble();
    weight4 = keyboard.nextDouble();
    bmi4 = 703.0 * weight4 / Math.pow( height4, 2 );

    System.out.println( "---- Ranking by Height" );
    find1st( name1, height1, name2, height2,
        name3, height3, name4, height4 );

    System.out.println( "---- Ranking by Weight" );
    find1st( name1, weight1, name2, weight2,
        name3, weight3, name4, weight4 );

    System.out.println( "---- Ranking by BMI" );
    find1st( name1, bmi1, name2, bmi2,
        name3, bmi3, name4, bmi4 );
  }
}

