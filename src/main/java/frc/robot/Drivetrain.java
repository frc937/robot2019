/*
 * Mecanum drivetrain code
 */

package frc.robot;

//Import packages
  import edu.wpi.first.wpilibj.Talon;
  import edu.wpi.first.wpilibj.XboxController;
  import edu.wpi.first.wpilibj.Spark;
  import edu.wpi.first.wpilibj.drive.MecanumDrive;
  import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Drivetrain {

  //Declare variables
  Talon frontLeft;
  Spark frontRight;
  Talon backLeft;
  Spark backRight;

  private MecanumDrive drivetrain;

  //constructor (run whenever the: = new Drivetrain() code is run)
  public Drivetrain() {
    frontLeft = new Talon(Settings.frontLeftPort);
    frontRight = new Spark(Settings.frontRightPort);
    backLeft = new Talon(Settings.backLeftPort);
    backRight = new Spark(Settings.backRightPort);

    frontLeft.setInverted(true);
    backLeft.setInverted(true);

    drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
  }

  public void driverControl(XboxController controller) {

    // Use the joystick X axis for lateral movement, Y axis for forward movement, and Z axis for rotation.
    drivetrain.driveCartesian(controller.getX(Hand.kLeft), controller.getY(Hand.kLeft), controller.getX(Hand.kRight), 0.0);
  }

}
