/*
 * Main loops and methods for the robot
 */

package frc.robot;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.subsystems.*;
import frc.robot.commands.motion.DriveRoboOriented;
//import frc.robot.RobotState;
import frc.robot.commands.manipulation.elevator.*;


public class Robot extends TimedRobot {

  /*
  * Declare variables
  */
  public static XboxController controller;
  public static Drivetrain drivetrain;
  private Camera leftCamera;
  private Camera rightCamera;
  public static ClawPush pushSolenoid;

  //solenoids

  //private DoubleSolenoid grabSolenoid = new DoubleSolenoid(RobotMap.CLAW_GRAB_OUT_PORT, RobotMap.CLAW_GRAB_IN_PORT);

  //private DoubleSolenoid moveSolenoid = new DoubleSolenoid(RobotMap.CLAW_MOVE_OUT_PORT, RobotMap.CLAW_MOVE_IN_PORT);

  //private DoubleSolenoid pushSolenoid = new DoubleSolenoid(RobotMap.CLAW_PUSH_OUT_PORT, RobotMap.CLAW_PUSH_IN_PORT);




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
    controller = new XboxController(RobotMap.CONTROLLER_NUMBER);

    drivetrain = new Drivetrain();

    pushSolenoid = new ClawPush();

    leftCamera = new Camera();
    rightCamera = new Camera();

    //elevator = new Talon(RobotMap.ELEVATOR_PORT);
    elevator = new Elevator();

    //oi = new OperatingInterface(controller);
    oi = new OperatingInterface();

    // change these three to whatever the robot's starting position for these is when you know
    /*RobotState.isUp = true;
    RobotState.isOpen = false;
    RobotState.isPushed = false;
    RobotState.elevatorLevel = 0;
*/
    Elevator.init();

    drive = new DriveRoboOriented();
    //lift = new Lift();
    //lower = new Lower();

  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();

  }
  /*
  * Interface methods
  */
  @Override
  public void teleopPeriodic() {
    //drivetrain.driverControl();
    //grabSolenoid.update();
/*
    //grabber control
    if(controller.getBumper(Hand.kLeft)) {
      grabSolenoid.set(Value.kForward);
    } else if(controller.getBumper(Hand.kRight)) {
      grabSolenoid.set(Value.kReverse);
    } else {
      grabSolenoid.set(Value.kOff);
    }

    //MOVEer control
    if(controller.getPOV(0) == 270) {
      moveSolenoid.set(Value.kForward);
    } else if(controller.getPOV(0) == 90) {
      moveSolenoid.set(Value.kReverse);
    } else {
      moveSolenoid.set(Value.kOff);
    }

    //grabber control
    if(controller.getAButton()) {
      pushSolenoid.set(Value.kForward);
    } else if(controller.getBButton()) {
      pushSolenoid.set(Value.kReverse);
    } else {
      pushSolenoid.set(Value.kOff);
    }
*/
    Scheduler.getInstance().run();
  }
}
