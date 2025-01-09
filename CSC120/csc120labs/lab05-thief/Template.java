import java.util.*;
public class Template {

  //----- a template for the grid
  private static final String GRID_STRING = 
      "+----------+\n" +
      "|..........|\n" +
      "|..........|\n" +
      "|..........|\n" +
      "|..........|\n" +
      "|..........|\n" +
      "|..........|\n" +
      "|..........|\n" +
      "|..........|\n" +
      "|..........|\n" +
      "|..........|\n" +
      "+----------+\n";

  //---- static variables representing the positions
  //---- the thief and the police
  private static int police_row, police_column;
  private static int thief_row, thief_column;

  /**
   * Present the locations of the thief and police
   * as a grid and numbers
   */
  private static void present() {
    System.out.println( "Present the locations." );
  }

  /**
   * Randomly move the thief
   */
  private static void move_thief() {
    /* count the possibilities
     * assign an index to each direction
     * if the move to the direction is inpossible, assign -1
     */
    System.out.println( "Move the thief" );
  }


  /**
   * move police
   */
  private static void move_police() {
    System.out.println( "Move the police " );
  }

  /**
   * main
   */
  public static void main( String[] args ) {
    // initialization
    boolean caught;
    thief_row = 5;
    thief_column = 5;
    police_row = 10;
    police_column = 10;
    caught = false;

    // The max no. of rounds is 20
    for ( int round = 1; round <= 20; round ++ ) {
      /* if not caught, present the position and
       * move the thief
       * move the police
       * update the boolean variable caught
       * after update, if caught, congratulation the user
       */
      if ( !caught ) {
        System.out.printf( "------ Round = %d ----------%n", round );
        present();
        move_thief();
        move_police();
        caught = Math.abs( thief_row - police_row ) +
            Math.abs( thief_column - police_column ) <= 1;
        if ( caught ) {
          System.out.println( "You've caught the thief." );
        }
      }
    }
    System.out.println( "--------- The final positions ---------" );
    present();
  }

}
