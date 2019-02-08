/*
 * Mecanum drivetrain code
 */

package frc.robot;

  import edu.wpi.first.wpilibj.Talon;
  import edu.wpi.first.wpilibj.XboxController;
  import edu.wpi.first.wpilibj.Spark;
  import edu.wpi.first.wpilibj.drive.MecanumDrive;
  import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Drivetrain {

  //Declare variables
  private Talon frontLeft;
  private Spark frontRight;
  private Talon backLeft;
  private Spark backRight;

  private MecanumDrive drivetrain;

  private XboxController controller;

  private double r;
  private double robotAngle;
  private double rightX;

  //constructor (run whenever the: = new Drivetrain() code is run)
  public Drivetrain(XboxController controller) {
    frontLeft = new Talon(Settings.frontLeftPort);
    frontRight = new Spark(Settings.frontRightPort);
    backLeft = new Talon(Settings.backLeftPort);
    backRight = new Spark(Settings.backRightPort);

    frontLeft.setInverted(false);
    backLeft.setInverted(false);

    drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    this.controller = controller;
  }

  public void driverControl() {
    r = Math.hypot(controller.getX(Hand.kLeft), controller.getY(Hand.kLeft));
    robotAngle = Math.atan2(controller.getY(Hand.kLeft), controller.getX(Hand.kLeft)) - Math.PI / 4;
    rightX = controller.getX(Hand.kRight);
    final double v1 = r * Math.cos(robotAngle) + rightX;
    final double v2 = r * Math.sin(robotAngle) - rightX;
    final double v3 = r * Math.sin(robotAngle) + rightX;
    final double v4 = r * Math.cos(robotAngle) - rightX;

    frontLeft.setSpeed(v1);
    frontRight.setSpeed(v2);
    backLeft.setSpeed(v3);
    backRight.setSpeed(v4);
    
    // Use the joystick X axis for lateral movement, Y axis for forward movement, and Z axis for rotation.
    //final double x = controller.getX(Hand.kLeft);
    //final double y = controller.getY(Hand.kLeft);
    //final double z = controller.getX(Hand.kRight);

    //drivetrain.driveCartesian(x, y, z, 0.0);
  }

}
