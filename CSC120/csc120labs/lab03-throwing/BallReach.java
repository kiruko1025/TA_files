import java.util.*;

public class BallReach {

  public static final double EARTH_GRAVITY = 9.807;
  public static final double MOON_GRAVITY = 1.620;

  public static void myPrint( String name, double value,
      String unit ) {
    System.out.printf(
        "%30s:%,14.4f (%s)%n", name, value, unit );
  }

  public static void message( String m ) {
    System.out.printf( "........ %s ........%n", m );
  }

  public static void compute(
      double height,
      double horizontal_speed,
      double vertical_speed,
      double gravity ) {
    double upward_time, downward_time, total_time;
    double upward_distance, downward_distance;
    double horizontal_distance;

    upward_time = vertical_speed / gravity;
    upward_distance = gravity
        * Math.pow( upward_time, 2 ) / 2;
    downward_distance = upward_distance + height;
    downward_time = Math.sqrt(
        2 * downward_distance / gravity );
    total_time = upward_time + downward_time;
    horizontal_distance = total_time * horizontal_speed;

    myPrint( "Height of the cliff", height, "m" );
    myPrint( "Horizontal speed",
        horizontal_speed, "m/s" );
    myPrint( "Initial vertical speed",
        vertical_speed, "m/s" );
    myPrint( "Gravity", gravity, "m/s^2" );
    myPrint( "Upward time", upward_time, "s" );
    myPrint( "Upward distance",
        upward_distance, "s" );
    myPrint( "Downward time", downward_time, "s" );
    myPrint( "Downward distance",
        downward_distance, "s" );
    myPrint( "Total time", total_time, "s" );
    myPrint( "Horizontal distance",
        horizontal_distance, "s" );
  }

  public static void main( String[] args ) {
    double angle, speed, height;
    double rad, hSpeed, vSpeed;

    Scanner keyboard = new Scanner( System.in );
    message( "Distance Calculation" );

    System.out.print( "Enter angle (degree): " );
    angle = keyboard.nextDouble();
    angle = Math.max( 0, Math.min( 90, angle ) );
    rad = Math.PI * angle / 180;

    System.out.print( "Enter speed (m/s): " );
    speed = keyboard.nextDouble();
    speed = Math.max( 0, speed );
    hSpeed = speed * Math.cos( rad );
    vSpeed = speed * Math.sin( rad );

    System.out.print( "Enter height (m): " );
    height = keyboard.nextDouble();
    height = Math.max( 0, height );

    message( "On the Earth" );
    compute( height, hSpeed, vSpeed, EARTH_GRAVITY );

    message( "On the Moon" );
    compute( height, hSpeed, vSpeed, MOON_GRAVITY );
  }
}
