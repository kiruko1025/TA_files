import java.util.*;
import java.io.*;

public class Historical {
  private OneDay[][][] data;

  public Historical() throws IOException {
    File f = new File( Const.FILE_NAME );
    Scanner in = new Scanner( f );
    data = new OneDay[ Const.LENGTH ][ 12 ][ 31 ];
    for ( int i = 0; i < Const.LENGTH; i ++ ) {
      for ( int j = 0; j < 12; j ++ ) {
        int year = in.nextInt();
        int month = in.nextInt();
        for ( int k = 0; k < 31; k ++ ) {
          double amount = in.nextDouble();
          data[ i ][ j ][ k ]
            = new OneDay( year, month, k+1, amount );
        }
      }
    }
    in.close();
  }

  public void explore( int yLow, int yHigh, int mLow, int mHigh,
      int dLow, int dHigh ) {
    int count = 0;
    double sum = 0, amount;
    OneDay d, theMax = null, theMin = null;
    for ( int i = yLow; i <= yHigh; i ++ ) {
      for ( int j = mLow; j <= mHigh; j ++ ) {
        for ( int k = dLow; k <= dHigh; k ++ ) {
          d = data[ i - Const.FIRST_YEAR ][ j - 1 ][ k - 1 ];
          if ( d.getAmount() != Const.NODATA ) {
            count++;
            amount = d.getAmount();
            sum += amount;
            if ( theMax == null ) {
              theMax = d;
              theMin = d;
            }
            else {
              if ( amount > theMax.getAmount() ) theMax = d;
              if ( amount < theMin.getAmount() ) theMin = d;
            }
          }
        }
      }
    }
    System.out.printf( "The number of days is %d%n", count );
    if ( count >= 1 ) {
      System.out.printf( "The average Precipitation is %.3f%n", sum / count );
      System.out.printf( "The maximum precipitation is %s%n", theMax.toString() );
      System.out.printf( "The minimum precipitation is %s%n", theMin.toString() );
    }
  }
}
