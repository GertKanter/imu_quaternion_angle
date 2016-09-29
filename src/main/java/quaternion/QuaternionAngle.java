package quaternion;

public class QuaternionAngle {

  public Point rotatePoint(Point point, Quaternion rotation) {
    double w = rotation.getW(); // r
    double x = rotation.getX(); // i
    double y = rotation.getY(); // j
    double z = rotation.getZ(); // k

    double r11 = 1 - 2 * y * y - 2 * z * z;
    double r12 = 2 * (x * y - z * w);
    double r13 = 2 * (x * z + y * w);
    double r21 = 2 * (x * y + z * w);
    double r22 = 1 - 2 * x * x - 2 * z * z;
    double r23 = 2 * (y * z - x * w);
    double r31 = 2 * (x * z - y * w);
    double r32 = 2 * (y * z + x * w);
    double r33 = 1 - 2 * x * x - 2 * y * y;

    double px = point.getX();
    double py = point.getY();
    double pz = point.getZ();

    return  new Point(r11 * px + r12 * py + r13 * pz, r21 * px + r22 * py + r23 * pz, r31 * px + r32 * py + r33 * pz);
  }

  public double getAngle(Point after, Point axisOfInterest) {
    // axisOfInterest - unit vector, either for X = (1, 0, 0), Y = (0, 1, 0), Z = (0, 0, 1)
    // we are interested how much the rotation was on this axis (e.g., if it was pointing to the wall and now is pointing to the ceiling => 90 degrees)
    return Math.acos(after.getX() * axisOfInterest.getX() + after.getY() * axisOfInterest.getY() + after.getZ() * axisOfInterest.getZ());
  }

}
