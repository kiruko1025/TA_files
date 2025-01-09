import java.util.*;
import java.io.*;
public class Election {
  //-- find an index of name in nameArray
  public static int find( String[] nameArray, String name ) {
    for ( int index = 0; index < nameArray.length; index ++ ) {
      if ( nameArray[index].toLowerCase().compareTo(
           name.toLowerCase() ) == 0 )
        return index;
    }
    return -1;
  }

  //-- add newName to the names list at the end
  public static String[] addName( String[] names,
      String newName ) {
    String[] revised = new String[ names.length + 1 ];
    for ( int index = 0; index < names.length; index ++ )
      revised[ index ] = names[ index ];
    revised[ names.length ] = newName;
    return revised;
  }

  //-- add count of 1 at the end of counts
  public static int[] addNewCount( int[] counts ) {
    int[] revised = new int[ counts.length + 1 ];
    for ( int index = 0; index < counts.length; index ++ )
      revised[ index ] = counts[ index ];
    revised[ counts.length ] = 1;
    return revised;
  }

  //-- find the winner
  public static void findWinner( String[] names,
      int[] counts ) {
    int maxCount = 0;
    String theWinner = "";
    for ( int index = 0; index < names.length; index ++ ) {
      System.out.printf( "%s received %d votes.%n",
          names[ index ], counts[ index ] );
      if ( counts[ index ] > maxCount ) {
        theWinner = names[ index ];
        maxCount = counts[ index ];
      }
    }
    System.out.printf( "--------\nThe winner is %s!\n",
        theWinner );
  }
  
  public static void main( String[] args ) throws IOException {
    Scanner keyboard = new Scanner( System.in );
    String[] names = new String[ 0 ];
    int[] counts = new int[ 0 ];
    String name;
    int position;
    Scanner in;
    System.out.printf( "Use a file? " );
    boolean useFile = keyboard.nextLine().toLowerCase()
        .startsWith( "y" );
    if ( useFile ) {
      String fileName;
      System.out.print( "Enter a file name: " );
      fileName = keyboard.nextLine();
      File f = new File( fileName );
      in = new Scanner( f );
    }
    else {
      in = keyboard;
      System.out.printf(
            "###########################################%n"
          + "# Enter the votes, one vote per line.     #%n"
          + "###########################################%n" );
    }
    while ( in.hasNext() ) {
      name = in.nextLine();
      position = find( names, name );
      if ( position >= 0 ) counts[ position ] ++;
      else {
        names = addName( names, name );
        counts = addNewCount( counts );
      }
    }
    findWinner( names, counts );
    if ( useFile ) in.close();
  }
}
