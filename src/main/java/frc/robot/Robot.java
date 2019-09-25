/*
* This class contains
* Main loops and methods for the robot
*/

/*
* Some valuable info:
* 
* If you need help, this directory is a good place to start
* https://wpilib.screenstepslive.com/s/4485
*
* Here's a whole index of classes and methods in them that you can 
* import and use as I've done below. 
* https://first.wpi.edu/FRC/roborio/release/docs/java/index-all.html#
*
* Use those links. They will help you.
*
* Google is also a valuable tool. Use it to your advantage.
*
* Don't shy away from digging through FRC java programming forums
* to see other people's solutions to problems similar to yours.
*/
/*
* This class contains
* Main loops and methods for the robot
*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import frc.robot.commands.motion.DriveRoboOriented;


public class Robot extends TimedRobot {

  /**
   * Declare Variables
   * so we can use them in this file later
   */  
  
   //public variables
  public static XboxController controller;

  public static OperatingInterface oi;

  public static Drivetrain drivetrain;

  public static Elevator elevator;

  public static ClawGrab grabSolenoid;
  public static ClawMove moveSolenoid;
  public static ClawPush pushSolenoid;

  //private variables
  private Camera leftCamera;
  private Camera rightCamera;
  private DriveRoboOriented drive;

  /**
   * <h2>Robot Initialization</h2>
   * <p>
   * This code is run whenever the robot first starts up.
   * It is mostly used to initialize (start up) each part
   * of the robot.
   */
  @Override
  public void robotInit() {
    //initialize controller
    controller = new XboxController(RobotMap.CONTROLLER_NUMBER);

    //initialize drivetrain
    drivetrain = new Drivetrain();
    drive = new DriveRoboOriented();

    //initialize elevator
    elevator = new Elevator();
    Elevator.init();

    //initialize claw
    grabSolenoid = new ClawGrab();
    moveSolenoid = new ClawMove();
    pushSolenoid = new ClawPush();

    //initialize cameras
    leftCamera = new Camera();
    rightCamera = new Camera();

    //initialize action mappings
    oi = new OperatingInterface();

  }

  /**
   * Runs over and over while the robot is on. Useful for
   * things that stay on through all of the possible modes.
   * <p><b>DO NOT USE AS THE MAIN PLACE FOR CODE!</b>
   */
  @Override
  public void robotPeriodic() {
    
  }

  /**
   * This code runs once every time the robot is disabled.
   * Useful for stopping things that shouldn't move after
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    
  }

  /**
   * This code runs over and over when the robot is disabled.
   */
  @Override
  public void disabledPeriodic() {
    
  }
  
  /**
   * Runs once when autonomous is enabled. Can be useful
   * for resetting values of things before going.
   */
  @Override
  public void autonomousInit() {
    
  }

  /**
   * <h1>Robot Automatic Mode</h1> <h3>(autonomous)</h3>
   * <p>
   * This code is run over and over while the robot is
   * in its autonomous mode. Mostly used for running
   * scheduled tasks. It's generally not a great idea
   * to use this directly for code.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * Runs once when teleop is enabled. Can be useful
   * for resetting values of things before going.
   */
  @Override
  public void teleopInit() {
    
  }

  /**
   * <h1>Robot Manual Mode</h1> <h3>(teleoperated / teleop)</h3>
   * <p>
   * This code is run over and over while the robot is
   * in its teleop mode. Mostly used for running
   * scheduled tasks. It's generally not a great idea
   * to use this directly for code.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * Runs once at the beginning of test mode.
   */
  @Override
  public void testInit() {
    
  }

  /**
   * Runs over and over during test mode.
   */
  @Override
  public void testPeriodic() {
    
  }

}
