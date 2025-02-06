import java.util.*;
/*
 * The basic version
 */
public class ConnectTemplate {
  /*
   * constants about size parameters
   */
  public static final int COL_SIZE = 7;
  public static final int ROW_SIZE = 6;

  public static final String[] PIECE
      = new String[]{ " ", "X", "O" };

  public static final String[] COLOR_PIECE
      = new String[]{ " ",
        "\033[38;5;00m\033[48;5;10mX\033[0;0m",
        "\033[38;5;15m\033[48;5;9mO\033[0;0m"
  };

  /**
   * @return	whether or not the column index is valid
   * @param	col	the column index
   */
  static boolean isValidPosition( int col ) {
    return col >= 0 && col < COL_SIZE;
  }

  /**
   * @return	whether or not the column index and
		row index are valid
   * @param	col	the column index
   * @param	row	the row index
   */
  static boolean isValidPosition( int col, int row ) {
    return col >= 0 && col < COL_SIZE
        && row >= 0 && row < ROW_SIZE;
  }

  /**
   * @return	the next available row position
   * @param	board	the board
   * @param	col	the column index
   */
  static int nextRow( String[] board, int col ) {
    if ( isValidPosition( col ) ) {
      if ( board[ col ].length() < ROW_SIZE - 1 ) {
        return board[ col ].length();
      }
    }
    return -1;
  }

  /**
   * @return	if there is room for a new piece
   * @param	board	the board
   */
  static boolean isOpen( String[] board ) {
    for ( int col = 0; col < COL_SIZE; col ++ ) {
      if ( nextRow( board, col ) >= 0 ) {
        return true;
      }
    }
    return false;
  }

  /**
   * @return	the char corresponding to the position
   * @param	board	String[]
   * @param	int	column index
   * @param	int	row index
   */
  public static int getPiece( String[] board, int col, int row ) {
    if ( isValidPosition( col, row ) ) {
      if ( row >= board[ col ].length() ) { return 0; }
      return board[ col ].charAt( row ) - '0';
    }
    return -1;
  }

  /**
   * Add a piece in the column specified
   * @param	board	the board
   * @param	col	the column index
   * @param	player	the player number
   */
  static void add( String[] board, int col, int player ) {
    board[ col ] = board[ col ] + player;
  }

  /**
   * Remove a piece in the column specified
   * @param	board	the board
   * @param	col	the column index
   */
  static void remove( String[] board, int col ) {
    board[ col ] = board[ col ].substring(
        0, board[ col ].length() - 1 );
  }

  /**
   * Obtain a column choice
   * @param	board	the board
   * @return	the column in which to place the piece
   */
  static int inputCol( String[] board ) {
    Scanner keyboard = new Scanner( System.in );
    int col, row;
    do {
      System.out.print( "\nEnter column: " );
      col = keyboard.nextInt();
      row = nextRow( board, col );
    } while ( row < 0 );
    return col;
  }

  /**
   * @return	an initial board
   */
  private static String[] initialize() {
    String[] board = new String[ COL_SIZE ];
    for ( int i = 0; i < COL_SIZE; i ++ ) {
      board[ i ] = "";
    }
    return board;
  }

  /* ***************************************************
   * ***************************************************
   * ***************************************************
   * ***************************************************
   *
   * THE STUDENTS MUST WRITE THE REST OF THE CODE.
   * 
   * ***************************************************
   * ***************************************************
   * ***************************************************
   * *************************************************** */

  /**
   * Present the board on the screen
   *
   * The parameter is a String[] variable board, which is
   * instantiated in the main().
   *
   * Execute a double for-loop, where
   *   the external loop is for the column index
   *   the internal loop is for the row index (backwards).
   *
   * For each column-row index pair,
   * 1. obtain the board element using getNumber method
   * 2. obtain the String corresponding to the element
   *   in the PIECE array (this is a static constant)
   * 3. print the String obtained in (2)
   * 4. print a newline when an internal loop is complete
   * Print dashes and the column numbers
   */
  static void present( String[] board ) {
    /**
     * @TODO print out the board by printing a PIECE, find location with getPiece() method
     **/
    
  }

  /**
   * @return	if the player has won the game
   * @param	board	the board
   * @param	player	the int representing the player
   *
   * Using four double loops, conduct searches in the
   * four directions. In each direction do the following:
   * Use a double-loop to generate a starting position of
   * the search. For each position,
   * . use the method getNumber to obtain four numbers
   * . return true if the obtained the numbers are
   *   equal to the player number
   * If none of the searches resulted in finding four
   * consecutive elements equal to the player number,
   * return false.
   */
  static boolean isWinner( String[] board, int player ) {
    /**
     * @TODO column-wise win check
     */

    /**
     * @TODO row-wise win check
     */


    /**
     * @TODO diagonal win check
     */


    /**
     * @TODO anti diagonal win check
     */


    return false;
  }


  /**
   * the main() method
   * initialize the board
   *
   * As long as the board is open and the winner does
   * not exist, do the following:
   * 1. Present the board
   * 2. Receive, from the user, a valid column number
   *    choice for Player 1.
   * 3. Play the piece on the board using the method add().
   * 4. Use isWinner() to determine if Player 1 has won.
   * 5. If Player 1 has won,
   *      present the board, report that Player 1 has won,
   *      and terminate the game.
   * 6. If Player 1 has not won, repeat 1 - 5 for Player 2.
   * When the board is not open and the winner does not
   * exist, present the board and reports that the game
   * was a draw.
   */
  public static void main( String[] args ) {
    String[] board;
    board = initialize();
    //---- rest of the game
  }
}
