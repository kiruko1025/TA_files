public class Range {
  double low, high;
  public Range( double l, double h ) {
    low = Math.min( l, h );
    high = Math.max( l, h );
  }
  public double getLow() {
    return low;
  }
  public double getHigh() {
    return high;
  }
  public boolean disjoint( Range o ) {
    return ( high < o.low ) || ( o.high < low );
  }
  public boolean intersect( Range o ) {
    return !disjoint( o );
  }
  public boolean isIn( double p ) {
    return p >= low && p <= high;
  }
  public double distance( double p ) {
    return ( isIn( p ) ) ? 0 :
        ( ( p < low ) ? low - p : p - high );
  }
}
