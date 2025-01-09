import java.util.*;

public class Birthday {

  /**
   * Randomly select a given number of people's positions
   * @param	nPeople	the number of people
   * @param	nPlace	the number of positions
   * @return	the frequency table resulting from random generations
   */
  public static int[] generateRawResult( int nPeople, int nPlaces ) {
    int[] rawResult;
    int position;

    rawResult = new int[ nPlaces ];
    for ( int i = 1; i <= nPeople; i ++ ) {
      position = (int)( Math.random() * nPlaces );
      rawResult[ position ] ++;
    }
    return rawResult;
  }

  public static boolean hasADuplicate( int[] rawResult ) {
    for ( int i = 0; i < rawResult.length; i ++ ) {
      if ( rawResult[ i ] >= 2 ) {
        return true;
      }
    }
    return false;
  }

  public static void experiment( int nPeople, int nPlaces, int nReps ) {
    int[] rawResult;
    int frequency;
    double[] probabilities;
    double average;

    probabilities = new double[ nReps ];

    for ( int i = 0; i < nReps; i ++ ) {
      frequency = 0;
      for ( int j = 0; j < nReps; j ++ ) {
        rawResult = generateRawResult( nPeople, nPlaces );
        if ( hasADuplicate( rawResult ) ) {
          frequency ++;
        }
      }
      probabilities[ i ] = frequency * 100.0 / nReps;
    }
    average = 0;
    for ( int i = 0; i < nReps; i ++ ) {
      average += probabilities[ i ] / nReps;
    }
    System.out.printf( "duplicate probability is %.3f.%n",
        average );
  }

  public static void main( String[] args ) {
    Scanner keyboard = new Scanner( System.in );
    int nPeople, nPlaces, nReps;
    String response;

    response = "";
    while ( !response.equals( "n" ) ) {
      System.out.print( "Enter the no. of people: " );
      nPeople = keyboard.nextInt();
      System.out.print( "Enter the no. of places: " );
      nPlaces = keyboard.nextInt();
      System.out.print( "Enter the no. of repetitions: " );
      nReps = keyboard.nextInt();
      experiment( nPeople, nPlaces, nReps );
      System.out.print( "Try again? " );
      response = keyboard.next();
    }
  }
}
