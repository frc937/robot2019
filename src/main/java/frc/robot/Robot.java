/*
 * Main loops and methods for the robot
 */

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {

  //Declare variables
  private XboxController controller;
  private Drivetrain drivetrain;
  private Arm arm;
  private Claw claw;
  private Camera leftCamera;
  private Camera rightCamera;

  //Runs once when the robot turns on
  @Override
  public void robotInit() {
    controller = new XboxController(Settings.controllerNumber);
    
    drivetrain = new Drivetrain(controller);
    
    arm = new Arm(controller);
    
    claw = new Claw(controller);
    
    leftCamera = new Camera();
    rightCamera = new Camera();
  }

  //Loops continuously when teleop mode is enabled
  @Override
  public void teleopPeriodic() {
    drivetrain.driverControl();
    
    arm.update();
    claw.update();
  }
}
