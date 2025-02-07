import java.util.*;
/*
 * The basic version
 */
public class ConnectNew {
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
  static boolean isOpen( String[] board, int col ) {
    return nextRow( board, col ) >= 0;
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
    } while ( !isOpen( board, col ) );
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
   */
  static void present( String[] board ) {
    System.out.println( "+-+-+-+-+-+-+-+");
    for ( int row = ROW_SIZE - 1; row >= 0; row -- ) {
      for ( int col = 0; col < COL_SIZE; col ++ ) {
        // System.out.print( PIECE[ getPiece( board, col, row ) ] );
        System.out.printf( "|%s", COLOR_PIECE[ getPiece( board, col, row ) ] );
      }
      System.out.println("|");
    }
    System.out.println( "+-+-+-+-+-+-+-+");
    for ( int col = 0; col < COL_SIZE; col ++ ) {
      System.out.printf( "%2d", col );
    }
    System.out.println();
  }


  /**
   * @return	if the player has won the game
   * @param	board	the board
   * @param	player	the int representing the player
   */
  static boolean isWinner( String[] board, int player ) {
    // column-wise win check
    for ( int col = 0; col < COL_SIZE; col ++ ) {
      for ( int row = 0; row < ROW_SIZE - 3; row ++ ) {
        if (
          getPiece( board, col, row ) == player &&
          getPiece( board, col, row + 1 ) == player &&
          getPiece( board, col, row + 2 ) == player &&
          getPiece( board, col, row + 3 ) == player ) {
            return true;
        }
      }
    }
    // row-wise win check
    for ( int row = 0; row < ROW_SIZE; row ++ ) {
      for ( int col = 0; col < COL_SIZE - 3; col ++ ) {
        if (
          getPiece( board, col, row ) == player &&
          getPiece( board, col + 1, row ) == player &&
          getPiece( board, col + 2, row ) == player &&
          getPiece( board, col + 3, row ) == player ) {
            return true;
        }
      }
    }
    // diagonal win check
    for ( int col = 0; col < COL_SIZE - 3; col ++ ) {
      for ( int row = 0; row < ROW_SIZE - 3; row ++ ) {
        if (
          getPiece( board, col, row ) == player &&
          getPiece( board, col + 1, row + 1 ) == player &&
          getPiece( board, col + 2, row + 2 ) == player &&
          getPiece( board, col + 3, row + 3 ) == player ) {
            return true;
        }
      }
    }
    // anti diagonal win check
    for ( int col = 0; col < COL_SIZE - 3; col ++ ) {
      for ( int row = 0; row < ROW_SIZE - 3; row ++ ) {
        if (
          getPiece( board, col, row + 3 ) == player &&
          getPiece( board, col + 1, row + 2 ) == player &&
          getPiece( board, col + 2, row + 1 ) == player &&
          getPiece( board, col + 3, row ) == player ) {
            return true;
        }
      }
    }
    return false;
  }

  /**
   * The method for executing one player
   * Applicable to both players
   * @param	board	the board
   * @param	player	the player number
   * 1. Present the board
   * 2. Annouce the player number
   * 3. Call inputCol( board ) to obtain a column index
   * 4. Place the piece for the player
   * 5. Evaluate and report if the player has won
   */
  static boolean playerManual( String[] board, int player ) {
    int col;

    present( board );
    System.out.printf( "%n----- Player %d -----%n", player );
    col = inputCol( board );
    // int row = nextRow( board, col );
    // System.out.println( col + ":" + row );
    add( board, col, player );
    return isWinner( board, player );
  }

  /**
   * Finding a winning column
   * @param	board	the board
   * @param	player	the player number
   * @return	the first column that is a winning column
   *		-1 if no winning column
   */
  static int winningColumn( String[] board, int player ) {
    int col, row;
    boolean win, found;
    found = false;
    for ( col = 0; col < COL_SIZE; col ++ ) {
      // int row = nextRow( board, col );
      // System.out.println( col + ":" + row );
      if ( isOpen( board, col ) ) {
        add( board, col, player );
        win = isWinner( board, player );
        remove( board, col );
        if ( win ) { return col; }
      }
    }
    return -1;
  }

  /**
   * Select column not resulting in an immediate loss
   * @param	board	the board
   * @param	player	the player number
   * @return	the chosen column
   */
  static int notLosingColumn( String[] board, int player ) {
    int col2;
    for ( int col = 0; col < COL_SIZE; col ++ ) {
      if ( isOpen( board, col ) ) {
        add( board, col, player );
        col2 = winningColumn( board, 3 - player );
        remove( board, col );
        if ( col2 < 0 ) {
          return col;
        }
      }
    }
    return -1;
  }

  /**
   * Select a random column
   * @param	board	the board
   * @return	random available column
   */
  static int randomColumn( String[] board ) {
    int col;
    do {
      col = ( int )( Math.random() * COL_SIZE );
    } while ( !isOpen( board, col ) );
    return col;
  }

  /**
   * Play logically
   * If a winning column exists, choose the first one
   * Otherwise, select a random open column
   *
   * @param	board	the board
   * @param	player	the player number
   * @return	the first column that is a winning column
   *		-1 if no winning column
   */
  static boolean playerLogic( String[] board, int player ) {
    int col;
    boolean win;

    present( board );

    col = winningColumn( board, player );
    if ( col < 0 ) {
      col = winningColumn( board, 3 - player);
      if ( col < 0 ) {
        col = notLosingColumn( board, player );
        if ( col < 0 ) {
          col = randomColumn( board );
        }
      }
        
    }
    System.out.println( "The program chooses: " + col );

    add( board, col, player );
    win = isWinner( board, player );
    return win;
  }

  /**
   * the main() method
   */
  public static void main( String[] args ) {
    String[] board;
    int row, col, player = 0;
    boolean win;

    board = initialize();
    win = false;

    while ( !win && isOpen( board ) ) {
      player = 1;
      win = playerManual( board, player );
      if ( !win ) {
        player = 2;
        win = playerLogic( board, player );
      }
    }

    present( board );
    if ( win ) {
        System.out.printf( "%nPlayer %d has won.%n", player );
    }
    else {
      System.out.println( "\nNo winner!" );
    }
  }
}
