import java.util.*;
public class ColorSelect {
  /* *********************************************************
   * This is a format String with an escape sequence inside
   * for setting the foregroud color.
   * The %d is a placeholder for an integer.
   * If x is an integer, String.format( ESC_FORE, x )
   * produces a String data that changes the foreground color
   * specified by x
   * Once this is printed with System.out.print,
   * System.out.printf, or System.out.println, the foreground
   * color is changed until the color is changed to something
   * else or the color change is reset.
   * Alternatively, executing System.out.printf( ESC_FORE, x )
   * changes the color.
   * *********************************************************
   */
  private static final String ESC_FORE = "\033[38;5;%dm";

  /* *********************************************************
   * This is a format String with an escape sequence inside
   * for setting the backgroud color.
   * The %d is a placeholder for an integer.
   * If x is an integer, String.format( ESC_BACK, x )
   * produces a String data that changes the background color
   * specified by x
   * Once this is printed with System.out.print,
   * System.out.printf, or System.out.println, the background
   * color is changed until the color is changed to something
   * else or the color change is reset.
   * Alternatively, executing System.out.printf( ESC_BACK, x )
   * changes the color.
   * *********************************************************
   */
  private static final String ESC_BACK = "\033[48;5;%dm";

  /* *********************************************************
   * This is a String for resettting the color changes.
   * *********************************************************
   */
  private static final String RESET = "\033[0;0m";

  /* *********************************************************
   * This is a format String for setting the color changes
   * taking a String to print in the combination and then
   * resettting the color changes.
   * Since ESC_FORE and ESC_BACK take one int value each,
   * the resulting format String will take two int values and
   * then a String value.
   * *********************************************************
   */
  private static final String COMBO =
    ESC_FORE + ESC_BACK + "%s" + RESET;

  /** *********************************************************
   * A method for generating a color-code String
   * @return	The color coded String
   * @param	fore	the foreground color 0..ff
   * @param	back	the background color 0..ff
   * @param	text	the String to print with the setting
   * *********************************************************
   */
  public static String encode(
      int fore, int back, String text ) {
    return String.format( COMBO, fore, back, text );
  }

  /** *********************************************************
   * A method for generating 256 tiles with their unique
   * background colors with a specified foreground color.
   * The layout is 16x16, and in each tile, the color name
   * appears in hexademical.
   * @param	fore	the foreground color 0..ff
   * *********************************************************
   */
  public static void allBack( int fore ) {
    for ( int back = 0x00; back <= 0xff; back ++ ) {
      System.out.print( " " + encode( fore, back,
        String.format( "%02x", back ) ) );
        if ( back % 16 == 15 ) System.out.println();
    }
  }

  /** *********************************************************
   * A method for generating 256 tiles with their unique
   * foreground colors with a specified background color.
   * The layout is 16x16, and in each tile, the color name
   * appears in hexademical.
   * @param	back	the background color 0..ff
   * *********************************************************
   */
  public static void allFore( int back ) {
    for ( int fore = 0x00; fore <= 0xff; fore ++ ) {
      System.out.print( " " + encode( fore, back,
        String.format( "%02x", fore ) ) );
        if ( fore % 16 == 15 ) System.out.println();
    }
  }

  /** *********************************************************
   * A method for presenting a specific color combination.
   * @param	fore	the foreground color 0..ff
   * @param	back	the background color 0..ff
   * *********************************************************
   */
  public static void oneCombo( int fore, int back ) {
    System.out.println( encode( fore, back,
      String.format( "fore=%02x, back=%02x", fore, back ) ) );
  }

  public static void main( String[] args ) {
    Scanner in = new Scanner( System.in );
    int fore, back, choice;
    do {
      System.out.printf(
          "1. Fixed FG, 2. Fixed BG%n" +
          "3. One combination, 4. Quit: " );
      choice = in.nextInt();
      if ( choice == 1 ) {
        System.out.print( "Enter FG color: " );
        fore = in.nextInt( 16 );
        allBack( fore );
      }
      else if ( choice == 2 ) {
        System.out.print( "Enter BG color: " );
        back = in.nextInt( 16 );
        allFore( back );
      }
      else if ( choice == 3 ) {
        System.out.print( "Enter FG and BG colors: " );
        fore = in.nextInt( 16 );
        back = in.nextInt( 16 );
        oneCombo( fore, back );
      }
    } while ( choice != 4 );
  }
}
