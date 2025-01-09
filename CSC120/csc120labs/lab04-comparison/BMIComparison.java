import java.util.*;
public class BMIComparison {

  public static void report( int rank, String name, double value ) {
    System.out.printf(
        "Rank %d is %s, with a value of %.2f%n",
        rank, name, value );
  }

  public static void find1st(
      double candidate_value1,
      double candidate_value2,
      double candidate_value3,
      double candidate_value4,
      String candidate_name1,
      String candidate_name2,
      String candidate_name3,
      String candidate_name4 ) {
    double maxValue;
    // compute the maximum among the candidate_values
    maxValue = Math.max(
        Math.max( candidate_value1, candidate_value2 ),
        Math.max( candidate_value3, candidate_value4 ) );
    if ( maxValue == candidate_value1 ) {
      report( 1, candidate_name1, candidate_value1 );
      find2nd( candidate_value2, candidate_value3, candidate_value4,
          candidate_name2, candidate_name3, candidate_name4 );
    }
    else if ( maxValue == candidate_value2 ) {
      report( 1, candidate_name2, candidate_value2 );
      find2nd( candidate_value1, candidate_value3, candidate_value4,
          candidate_name1, candidate_name3, candidate_name4 );
    }
    else if ( maxValue == candidate_value3 ) {
      report( 1, candidate_name3, candidate_value3 );
      find2nd( candidate_value1, candidate_value2, candidate_value4,
          candidate_name1, candidate_name2, candidate_name4 );
    }
    else { // maxValue == candidate_value4
      report( 1, candidate_name4, candidate_value4 );
      find2nd( candidate_value1, candidate_value2, candidate_value3,
          candidate_name1, candidate_name2, candidate_name3 );
    }
  }

  public static void find2nd(
      double candidate_value1,
      double candidate_value2,
      double candidate_value3,
      String candidate_name1,
      String candidate_name2,
      String candidate_name3 ) {
    double maxValue;
    // compute the maximum among the candidate_values
    maxValue = Math.max(
        Math.max( candidate_value1, candidate_value2 ),
            candidate_value3 );
    if ( maxValue == candidate_value1 ) {
      report( 2, candidate_name1, candidate_value1 );
      findRest( candidate_value2, candidate_value3,
          candidate_name2, candidate_name3 );
    }
    else if ( maxValue == candidate_value2 ) {
      report( 2, candidate_name2, candidate_value2 );
      findRest( candidate_value1, candidate_value3,
          candidate_name1, candidate_name3 );
    }
    else { // maxValue == candidate_value4
      report( 2, candidate_name3, candidate_value3 );
      findRest( candidate_value1, candidate_value2,
          candidate_name1, candidate_name2 );
    }
  }

  public static void findRest(
      double candidate_value1,
      double candidate_value2,
      String candidate_name1,
      String candidate_name2 ) {
    double maxValue;
    // compute the maximum among the candidate_values
    maxValue = Math.max( candidate_value1, candidate_value2 );
    if ( maxValue == candidate_value1 ) {
      report( 3, candidate_name1, candidate_value1 );
      report( 4, candidate_name2, candidate_value2 );
    }
    else { // maxValue == candidate_value2
      report( 3, candidate_name2, candidate_value2 );
      report( 4, candidate_name1, candidate_value1 );
    }
  }

  public static void main( String[] args ) {
    Scanner keyboard;
    String name1, name2, name3, name4;
    double height1, height2, height3, height4;
    double weight1, weight2, weight3, weight4;
    double bmi1, bmi2, bmi3, bmi4;

    keyboard = new Scanner( System.in );

    System.out.print( "Enter Name, Height, and Weight for Person 1: " );
    name1 = keyboard.next();
    height1 = keyboard.nextDouble();
    weight1 = keyboard.nextDouble();

    System.out.print( "Enter Name, Height, and Weight for Person 2: " );
    name2 = keyboard.next();
    height2 = keyboard.nextDouble();
    weight2 = keyboard.nextDouble();

    System.out.print( "Enter Name, Height, and Weight for Person 3: " );
    name3 = keyboard.next();
    height3 = keyboard.nextDouble();
    weight3 = keyboard.nextDouble();

    System.out.print( "Enter Name, Height, and Weight for Person 4: " );
    name4 = keyboard.next();
    height4 = keyboard.nextDouble();
    weight4 = keyboard.nextDouble();

    bmi1 = 703.0 * weight1 / Math.pow( height1, 2 );
    bmi2 = 703.0 * weight2 / Math.pow( height2, 2 );
    bmi3 = 703.0 * weight3 / Math.pow( height3, 2 );
    bmi4 = 703.0 * weight4 / Math.pow( height4, 2 );

    System.out.println( "---- Ranking by Height" );
    find1st( height1, height2, height3, height4,
        name1, name2, name3, name4 );

    System.out.println( "---- Ranking by Weight" );
    find1st( weight1, weight2, weight3, weight4,
        name1, name2, name3, name4 );

    System.out.println( "---- Ranking by BMI" );
    find1st( bmi1, bmi2, bmi3, bmi4,
        name1, name2, name3, name4 );
  }
}

