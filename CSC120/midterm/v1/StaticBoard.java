import java.util.*;
/*
 * The basic version
 * All static access
 */
public class StaticBoard {
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
  public static boolean isValidPosition( int col ) {
    return col >= 0 && col < COL_SIZE;
  }

  /**
   * @return	whether or not the column index and
		row index are valid
   * @param	col	the column index
   * @param	row	the row index
   */
  public static boolean isValidPosition( int col, int row ) {
    return col >= 0 && col < COL_SIZE
        && row >= 0 && row < ROW_SIZE;
  }

  /**
   * @return	the next available row position
   * @param	board	the board
   * @param	col	the column index
   */
  public static int nextRow( String[] board, int col ) {
    if ( isValidPosition( col ) ) {
      if ( board[ col ].length() < ROW_SIZE ) {
        return board[ col ].length();
      }
    }
    return -1;
  }

  /**
   * @return	if there is room for a new piece
   *		in a given column
   * @param	board	the board
   * @param	col	the column index
   */
  public static boolean isOpen( String[] board, int col ) {
    return nextRow( board, col ) >= 0;
  }

  /**
   * @return	if there is room for a new piece
   * @param	board	the board
   */
  public static boolean isOpen( String[] board ) {
    for ( int col = 0; col < COL_SIZE; col ++ ) {
      if ( isOpen( board, col ) ) {
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
  public static void add( String[] board, int col, int player ) {
    board[ col ] = board[ col ] + player;
  }

  /**
   * Remove a piece in the column specified
   * @param	board	the board
   * @param	col	the column index
   */
  public static void remove( String[] board, int col ) {
    board[ col ] = board[ col ].substring(
        0, board[ col ].length() - 1 );
  }

  /**
   * Obtain a column choice
   * @param	board	the board
   * @return	the column in which to place the piece
   */
  public static int inputCol( String[] board ) {
    Scanner keyboard = new Scanner( System.in );
    int col, row;
    do {
      System.out.print( "\nEnter column: " );
      col = keyboard.nextInt();
    } while ( !isOpen( board, col ) );
    return col;
  }

  /**
   * @return	an initial board
   */
  public static String[] initialize() {
    String[] board = new String[ COL_SIZE ];
    for ( int i = 0; i < COL_SIZE; i ++ ) {
      board[ i ] = "";
    }
    return board;
  }

  /**
   * functionality test
   */
  public static void main( String[] args ) {
    Scanner keyboard;
    keyboard = new Scanner( System.in );
    int col, row, selection, player;
    String[] board = initialize();
    do {
      System.out.println();
      System.out.println( "Enter your action: " );
      System.out.println( "1. add a piece" );
      System.out.println( "2. remove a piece" );
      System.out.println( "3. get a piece" );
      System.out.println( "4. column input method" );
      System.out.println( "Otherwise, the program will quite." );
      System.out.print( "Enter your choice: " );
      selection = keyboard.nextInt();
      if ( selection == 1 ) {
        System.out.print( "Enter a column and a player: " );
        col = keyboard.nextInt();
        player = keyboard.nextInt();
        if ( !isValidPosition( col ) ) {
          System.out.println( "An invalid choice." );
        }
        else if ( player != 1 && player != 2 ) {
          System.out.println( "An invalid player number." );
        }
        else if ( !isOpen( board, col ) ) {
          System.out.println( "The column is full." );
        }
        else {
          add( board, col, player );
        }
      }
      else if ( selection == 2 ) {
        System.out.print( "Enter a column: " );
        col = keyboard.nextInt();
        if ( !isValidPosition( col ) ) {
          System.out.println( "An invalid choice." );
        }
        else {
          remove( board, col );
        }
      }
      else if ( selection == 3 ) {
        System.out.print( "Enter a column and a row: " );
        col = keyboard.nextInt();
        row = keyboard.nextInt();
        if ( !isValidPosition( col ) ) {
          System.out.println( "An invalid choice." );
        }
        else if ( !isValidPosition( col, row ) ) {
          System.out.println( "An invalid position!" );
        }
        else {
          System.out.printf(
              "The piece number is %d; the string is \"%s\".",
              getPiece( board, col, row ),
              COLOR_PIECE[ getPiece( board, col, row ) ] );
        }
      }
      else if ( selection == 4 ) {
        col = inputCol( board );
      }
    } while ( selection >= 1 && selection <= 4 );
  }
}
