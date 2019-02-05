/*
 * Main loops and methods for the robot
 */

package frc.robot;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.RobotState;
import edu.wpi.first.wpilibj.Talon;

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
  public static Talon elevator;

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
    elevator = new Talon(RobotMap.ELEVATOR_PORT);

    // change these three to whatever the robot's starting position for these is when you know
    RobotState.isExtended = false;
    RobotState.isOpen = false;
    RobotState.isPushed = false;
    RobotState.elevatorLevel = 0;

    Elevator.init();
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
