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
* Google is an extremely valuable tool. Use it to your advantage.
* This can help:
* https://lmgtfy.com/?q=how+to+use+google&iie=1
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
  *
  * It's always nice to declare your variables right off the bat.
  * It'll help you keep organized and ease the whole process
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
  * 
  * This is what initializes objects when they are created.
  *
  * Notice that here it is called robotInit. In all the other
  * classes it will share its name with the class it is in.
  * (See any other class if you aren't sure what I mean by that.)
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
