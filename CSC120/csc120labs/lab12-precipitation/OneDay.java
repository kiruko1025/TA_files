public class OneDay implements OneDayInt {
  private int year, month, day;
  private double amount;

  public OneDay( int y, int m, int d, double a ) {
    year = y;
    month = m;
    day = d;
    amount = a;
  }
  public double getAmount() {
    return amount;
  }
  public String toString() {
    return String.format( "%.3f on %4d-%02d-%02d",
        amount, year, month, day );
  }
}
