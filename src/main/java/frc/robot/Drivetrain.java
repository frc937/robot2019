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

  //constructor (run whenever the: = new Drivetrain() code is run)
  public Drivetrain(XboxController controller) {
    frontLeft = new Talon(Settings.frontLeftPort);
    frontRight = new Spark(Settings.frontRightPort);
    backLeft = new Talon(Settings.backLeftPort);
    backRight = new Spark(Settings.backRightPort);

    frontLeft.setInverted(true);
    backLeft.setInverted(true);

    drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    this.controller = controller;
  }

  public void driverControl() {
    // Use the joystick X axis for lateral movement, Y axis for forward movement, and Z axis for rotation.
    private final double x = controller.getX(Hand.kLeft);
    private final double y = controller.getY(Hand.kLeft);
    private final double z = controller.getX(Hand.kRight);

    drivetrain.driveCartesian(x, y, z, 0.0);
  }

}
