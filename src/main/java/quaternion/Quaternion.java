package quaternion;

public class Quaternion {
  
  private double w;
  private double x;
  private double y;
  private double z;

  public Quaternion(double w, double x, double y, double z) {
    this.w = w;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public double getW() {
    return w;
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
  public String toString() {
    return w + " " + x + " " + y + " " + z;
  }
}
