public class Rectangle {
  private Range xRange, yRange;

  public Rectangle ( double xLow, double yLow,
      double xHigh, double yHigh ) {
    xRange = new Range( xLow, xHigh );
    yRange = new Range( yLow, yHigh );
  }
  public Range getXRange() {
    return xRange;
  }
  public Range getYRange() {
    return yRange;
  }
  public boolean disjoint( Rectangle o ) {
    return xRange.disjoint( o.xRange ) ||
        yRange.disjoint( o.yRange );
  }
  public boolean intersect( Rectangle o ) {
    return !disjoint( o ); }
  public boolean isIn( double x, double y ) {
    return xRange.isIn( x ) && yRange.isIn( y );
  }
  public double distance( double x, double y ) {
    return isIn( x, y ) ? 0 :
        Math.sqrt( Math.pow( xRange.distance( x ), 2 )
                 + Math.pow( yRange.distance( y ), 2 ) );
  }
}
