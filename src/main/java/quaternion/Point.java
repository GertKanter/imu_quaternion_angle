package quaternion;

public class Point {
  
  private double x;
  private double y;
  private double z;

  public Point(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    Point other = (Point) obj;
    if (other.getX() == x && other.getY() == y && other.getZ() == z) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return x + " " + y + " " + z;
  }
}
