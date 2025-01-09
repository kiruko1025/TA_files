import java.util.*;
public class Apprehend {

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
    //--- a variable in which to store a position
    int position;
    StringBuilder builder;

    /*
     * initialize the builder with the template
     * obtain the position of thief and replace
     * the substring having a length of 1 at this
     * position with "T"
     * repeat the same for the police
     */
    builder = new StringBuilder( GRID_STRING );
    position = thief_row * 13 + thief_column;
    builder.replace( position, position + 1, "T" );
    position = police_row * 13 + police_column;
    builder.replace( position, position + 1, "P" );

    // print the grid and report the positions
    System.out.print( builder );

    System.out.printf( "The thief is at (%d,%d).%n",
        thief_row, thief_column );
    System.out.printf( "The officer is at (%d,%d).%n",
        police_row, police_column );
  }

  /**
   * Randomly move the thief
   */
  private static void move_thief_alt() {
    /* count the possibilities
     * assign an index to each direction
     * if the move to the direction is inpossible, assign -1
     */
    int possibilities;
    int left_index = -1, right_index = -1, up_index = -1, down_index = -1;
    int random_index;

    possibilities = 0;

    if ( thief_column > 1 ) {
      left_index = possibilities ++ ;
    }
    if ( thief_column < 10 ) {
      right_index = possibilities ++;
    }
    if ( thief_row > 1 ) {
      up_index =  possibilities ++;
    }
    if ( thief_row < 10 ) {
      down_index =  possibilities ++;
    }

    // randomly select an integer between 0 and the possibilities - 1
    random_index = (int)( Math.random() * possibilities );

//    System.out.printf( "L=%d, R=%d, U=%d, D=%d, Random=%d%n",
//      left_index, right_index, up_index, down_index, random_index );

    /* move the thief to the direction chosen
     * the direction is found by comparing the random direction
     * with the assigned direction
     */
    if ( random_index == left_index ) {
      thief_column --;
    }
    else if ( random_index == right_index ) {
      thief_column ++;
    }
    else if ( random_index == up_index ) {
      thief_row --;
    }
    else { // random_index == up_index
      thief_row ++;
    }
  }
  /**
   * Randomly move the thief
   */
  private static void move_thief() {
    int row_diff, column_diff;

    row_diff = (int)(Math.random() * 3) - 1;
    column_diff = (int)(Math.random() * 3) - 1;

    thief_column += column_diff;
    thief_row += row_diff;
    if ( thief_column == 0 ) {
      thief_column = 1;
    }
    if ( thief_column == 11 ) {
      thief_column = 10;
    }
    if ( thief_row == 0 ) {
      thief_row = 1;
    }
    if ( thief_row == 11 ) {
      thief_row = 10;
    }
  }

  /**
   * move police
   */
  private static void move_police_alt() {
    Scanner keyboard;
    String input;
    boolean can_move_left, can_move_right, can_move_up, can_move_down;

    /* Use four booleans to calculate which directions the police
     * can move
     */
    can_move_left = police_column > 1;
    can_move_right = police_column < 10;
    can_move_up = police_row > 1;
    can_move_down = police_row < 10;

    /* receive a direction from the user
     * convert the input to all uppercase
     */
    keyboard = new Scanner( System.in );
    System.out.println( "Enter the direction of your move." );
    System.out.print( "The choices are L, R, U, D, UL, UR, DL, DR, -: " );
    input = keyboard.next().toUpperCase();

    /* update position according to the direction
     * output an error message, if the selected move is impossible
     */
    if ( input.equals( "L" ) && can_move_left ) {
      police_column --;
    }
    else if ( input.equals( "R" ) && can_move_right ) {
      police_column ++;
    }
    else if ( input.equals( "U" ) && can_move_up ) {
      police_row --;
    }
    else if ( input.equals( "D" ) && can_move_down ) {
      police_row ++;
    }
    else if ( input.equals( "UL" ) && can_move_left && can_move_up ) {
      police_column --;
      police_row --;
    }
    else if ( input.equals( "UR" ) && can_move_right && can_move_up ) {
      police_column ++;
      police_row --;
    }
    else if ( input.equals( "DL" ) && can_move_left && can_move_down ) {
      police_column --;
      police_row ++;
    }
    else if ( input.equals( "DR" ) && can_move_right && can_move_down ) {
      police_column ++;
      police_row ++;
    }
    else if ( input.equals( "-" ) ) {
    }
    else {
      System.out.println(
          "An invalid input. The officer remains in the same position." );
    }
  }

  /**
   * move police
   */
  private static void move_police() {
    Scanner keyboard;
    String input;

    /* receive a direction from the user
     * convert the input to all uppercase
     */
    keyboard = new Scanner( System.in );
    System.out.println( "Enter the direction of your move." );
    System.out.print( "The choices are L, R, U, D, UL, UR, DL, DR, -: " );
    input = keyboard.next().toUpperCase();

    /* update position according to the direction
     * output an error message, if the selected move is impossible
     */
    if ( input.equals( "L" ) || 
         input.equals( "UL" ) || input.equals( "DL" ) ) {
      police_column --;
    }
    else if ( input.equals( "R" ) || 
         input.equals( "UR" ) || input.equals( "DR" ) ) {
      police_column ++;
    }
    if ( input.equals( "D" ) || 
         input.equals( "DR" ) || input.equals( "DL" ) ) {
      police_row ++;
    }
    else if ( input.equals( "U" ) || 
              input.equals( "UR" ) || input.equals( "UL" ) ) {
      police_row --;
    }
    if ( police_column == 0 ) {
      police_column = 1;
    }
    else if ( police_column == 11 ) {
      police_column = 10;
    }
    if ( police_row == 0 ) {
      police_row = 1;
    }
    else if ( police_row == 11 ) {
      police_row = 10;
    }
  }

  /**
   * main
   */
  public static void main( String[] args ) {
    // initialization
    boolean caught;
    thief_row = 5;
    thief_column = 5;
    police_row = 1;
    police_column = 1;
    if ( Math.random() >= 0.5 ) {
      police_row = 10;
    }
    if ( Math.random() >= 0.5 ) {
      police_column = 10;
    }
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
