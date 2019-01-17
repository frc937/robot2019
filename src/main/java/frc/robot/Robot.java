/*
 * Main loops and methods for the robot
 */

package frc.robot;

//Import packages
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Robot extends TimedRobot {

  //Declare variables
  private MecanumDrive drivetrain;
  private XboxController controller;

  Talon frontLeft;
  Spark frontRight;
  Talon backLeft;
  Spark backRight;

  DoubleSolenoid solenoid;

  //Runs once when the robot turns on
  @Override
  public void robotInit() {
    
    Camera leftCamera = new Camera();
    Camera rightCamera = new Camera();

    frontLeft = new Talon(Settings.frontLeftPort);
    frontRight = new Spark(Settings.frontRightPort);
    backLeft = new Talon(Settings.backLeftPort);
    backRight = new Spark(Settings.backRightPort);

    solenoid = new DoubleSolenoid(Settings.solenoidForwardPort, Settings.solenoidBackwardPort);

    // Invert the left side motors.
    // You may need to change or remove this to match your robot.
    frontLeft.setInverted(true);
    backLeft.setInverted(true);

    drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    controller = new XboxController(Settings.controllerNumber);
  }

  //Loops continuously when teleop mode is enabled
  @Override
  public void teleopPeriodic() {

    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.
    drivetrain.driveCartesian(controller.getX(Hand.kLeft), controller.getY(Hand.kLeft), controller.getX(Hand.kRight), 0.0);

    if(controller.getAButton()) {
      solenoid.set(DoubleSolenoid.Value.kForward);
    } else if(controller.getBButton()) {
      solenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      solenoid.set(DoubleSolenoid.Value.kOff);
    }

  }
}
