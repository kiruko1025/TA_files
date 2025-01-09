import java.util.*;
import java.io.*;
public class PrecMain {
  public static void main( String[] args )
      throws IOException {
    Historical data = new Historical();
    int yLow, yHigh;
    int mLow, mHigh;
    int dLow, dHigh;
    String w;
    Scanner keyboard = new Scanner( System.in );
    do {
      System.out.print( "Start & end years: " );
      yLow = keyboard.nextInt();
      yHigh = keyboard.nextInt();
      yLow = Math.max( yLow, Const.FIRST_YEAR );
      yHigh = Math.min( yHigh, Const.LAST_YEAR );

      System.out.print( "Start & end months: " );
      mLow = keyboard.nextInt();
      mHigh = keyboard.nextInt();
      mLow = Math.max( 1, mLow );
      mHigh = Math.min( 12, mHigh );

      System.out.print( "Start & end days: " );
      dLow = keyboard.nextInt();
      dHigh = keyboard.nextInt();
      dLow = Math.max( 1, dLow );
      dHigh = Math.min( 31, dHigh );

      data.explore( yLow, yHigh, mLow, mHigh, dLow, dHigh );
      System.out.print( "Try again (y/n)? " );
      w = keyboard.next().toLowerCase();
    } while ( w.startsWith( "y" ) );
  }
}
