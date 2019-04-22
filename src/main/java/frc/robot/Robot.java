/*
 * Main loops and methods for the robot
 */

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.subsystems.*;
import frc.robot.commands.motion.DriveRoboOriented;
import frc.robot.commands.manipulation.elevator.*;


public class Robot extends TimedRobot {

  /*
  * Variables
  */
  public static XboxController controller;

  public static Drivetrain drivetrain;

  private Camera leftCamera;
  private Camera rightCamera;

  public static ClawGrab grabSolenoid;
  public static ClawMove moveSolenoid;
  public static ClawPush pushSolenoid;

  public static Elevator elevator;

  public static OperatingInterface oi;

  private DriveRoboOriented drive;


  /*
  * Constructor
  */
  @Override
  public void robotInit() {
    controller = new XboxController(RobotMap.CONTROLLER_NUMBER);

    drivetrain = new Drivetrain();

    grabSolenoid = new ClawGrab();
    moveSolenoid = new ClawMove();
    pushSolenoid = new ClawPush();

    leftCamera = new Camera();
    rightCamera = new Camera();

    elevator = new Elevator();

    oi = new OperatingInterface();

    Elevator.init();

    drive = new DriveRoboOriented();

  }

  
  /*
  * Interface methods
  */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
}
