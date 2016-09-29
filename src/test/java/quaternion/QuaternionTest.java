package quaternion;

import org.testng.annotations.*;
import org.testng.Assert;

public class QuaternionTest {

  private QuaternionAngle qa;
  
  @BeforeClass
  public void setUp() {
    qa = new QuaternionAngle();
  }

  @Test(timeOut=100)
  public void test180degX() {
    Assert.assertEquals(qa.rotatePoint(new Point(1, 0, 0), new Quaternion(0, 0, 1, 0)), new Point(-1, 0, 0));
  }
  
  @Test(timeOut=100)
  public void test180degZ() {
    Assert.assertEquals(qa.rotatePoint(new Point(1, 0, 0), new Quaternion(0, 0, 0, 1)), new Point(-1, 0, 0));
  }

  @Test(timeOut=100)
  public void testAngle() {
    double angle = 0.5; // rad
    // this assumes that if IMU is flat on the table then one side parallel to one side is x-axis and the side perpendicular to it is y-axis, z-axis points up
    // we get the angle of rotation about the y-axis (how much X axis is now pointing toward the ceiling)

    Quaternion rotation = new Quaternion(Math.cos(angle / 2), 0, Math.sin(angle / 2), 0); // this is the new position of the IMU (i.e., live reading) - in this case, we rotate it to point up 0.5 rads
    Point rotatedPoint = qa.rotatePoint(new Point(1, 0, 0), rotation); // rotating a point on X axis 0.5 rads around Y-axis
    System.out.println(rotatedPoint);
    Assert.assertEquals(qa.getAngle(rotatedPoint, new Point(0, 0, 1)), angle, 0.01);

  }
  
}
