/*
 * Main loops and methods for the robot
 */

package frc.robot;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.subsystems.*;
import frc.robot.commands.motion.DriveRoboOriented;
import frc.robot.RobotState;
import frc.robot.commands.manipulation.elevator.*;


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
  //public static Talon elevator;
  public static Elevator elevator;

  public static OperatingInterface oi;

  private DriveRoboOriented drive;
  private Lift lift;
  private Lower lower;


  /*
  * Constructor
  */
  @Override
  public void robotInit() {
    //controller = new XboxController(RobotMap.CONTROLLER_NUMBER);

    drivetrain = new Drivetrain();

    grabSolenoid = new ClawGrab();
    moveSolenoid = new ClawMove();
    pushSolenoid = new ClawPush();

    leftCamera = new Camera();
    rightCamera = new Camera();

    //elevator = new Talon(RobotMap.ELEVATOR_PORT);
    elevator = new Elevator();

    //oi = new OperatingInterface(controller);
    oi = new OperatingInterface();

    // change these three to whatever the robot's starting position for these is when you know
    RobotState.isUp = true;
    RobotState.isOpen = false;
    RobotState.isPushed = false;
    RobotState.elevatorLevel = 0;

    Elevator.init();

    drive = new DriveRoboOriented();
    //lift = new Lift();
    //lower = new Lower();

  }

  /*
  * Interface methods
  */
  @Override
  public void teleopPeriodic() {
    //drivetrain.driverControl();
    //grabSolenoid.update();

    Scheduler.getInstance().run();
  }
}
