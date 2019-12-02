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
import edu.wpi.first.wpilibj.PowerDistributionPanel;


public class Robot extends TimedRobot {

  /*
  * Declare variables
  */
  public static XboxController controller;
  public static Drivetrain drivetrain;
  private Camera leftCamera;
  private Camera rightCamera;
  public static ClawPush pushSolenoid;
  public static Elevator elevator;
  public static OperatingInterface oi;
  private DriveRoboOriented drive;
  private Lift lift;
  private Lower lower;
  private PowerDistributionPanel pdp;


  /*
  * Constructor
  */
  @Override
  public void robotInit() {
    controller = new XboxController(RobotMap.CONTROLLER_NUMBER);

    drivetrain = new Drivetrain();

    pushSolenoid = new ClawPush();

    leftCamera = new Camera();
    
    elevator = new Elevator();

    oi = new OperatingInterface();

    Elevator.init();

    drive = new DriveRoboOriented();

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
    Scheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    pdp = new PowerDistributionPanel();
    pdp.clearStickyFaults();
  }
}
