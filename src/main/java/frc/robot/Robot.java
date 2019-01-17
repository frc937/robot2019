/*
 * Main loops and methods for the robot
 */

package frc.robot;

//Import packages
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Robot extends TimedRobot {

  //Declare variables
  private MecanumDrive m_robotDrive;
  private Joystick m_stick;

  Talon frontLeft;
  Spark frontRight;
  Talon backLeft;
  Spark backRight;

  DoubleSolenoid solenoid;

  //Runs once when the robot turns on
  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture();
    CameraServer.getInstance().startAutomaticCapture();

    frontLeft = new Talon(Settings.frontLeftPort);
    frontRight = new Spark(Settings.frontRightPort);
    backLeft = new Talon(Settings.backLeftPort);
    backRight = new Spark(Settings.backRightPort);

    solenoid = new DoubleSolenoid(Settings.solenoidForwardPort, Settings.solenoidBackwardPort);

    // Invert the left side motors.
    // You may need to change or remove this to match your robot.
    frontLeft.setInverted(true);
    backLeft.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    m_stick = new Joystick(Settings.controllerNumber);
    m_stick.setZChannel(Settings.controllerRightStickXAxis);
  }

  //Loops continuously when teleop mode is enabled
  @Override
  public void teleopPeriodic() {

    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.
    m_robotDrive.driveCartesian(m_stick.getX(), m_stick.getY(), m_stick.getZ(), 0.0);

    if(m_stick.getRawButton(1)) {
      solenoid.set(DoubleSolenoid.Value.kForward);
    } else if(m_stick.getRawButton(2)) {
      solenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      solenoid.set(DoubleSolenoid.Value.kOff);
    }

  }
}
