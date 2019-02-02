/*
 * Main loops and methods for the robot
 */

package frc.robot;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {

  /*
  * Declare variables
  */
  public static XboxController controller;
  public static Drivetrain drivetrain;
  private Camera leftCamera;
  private Camera rightCamera;
  public static ClawGrab grabSolenoid;
  public static ClawMove moveSolenoid;
  public static ClawPush pushSolenoid;

  /*
  * Constructor
  */
  @Override
  public void robotInit() {
    controller = new XboxController(RobotMap.CONTROLLER_NUMBER);
    drivetrain = new Drivetrain(controller);
    grabSolenoid = new ClawGrab();
    leftCamera = new Camera();
    rightCamera = new Camera();
  }

  /*
  * Interface methods
  */
  @Override
  public void teleopPeriodic() {
    drivetrain.driverControl();
    //grabSolenoid.update();
  }
}
