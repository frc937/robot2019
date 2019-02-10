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

  private double leftX;
  private double leftY;
  private double rightX;

  private double x;
  private double y;
  private double z;

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
    // Use the joystick X axis for lateral movement, Y axis for forward movement, and Z axis for rotation.
    leftX = controller.getX(Hand.kLeft);
    leftY = controller.getY(Hand.kLeft);
    rightX  = controller.getX(Hand.kRight);
    x = Math.signum(leftX) * Math.pow(leftX, 2);
    y = Math.signum(leftY) * Math.pow(leftY, 2);
    z = Math.signum(rightX) * Math.pow(rightX, 2);
    
    drivetrain.driveCartesian(x, y, z, 0.0);
  }

}
