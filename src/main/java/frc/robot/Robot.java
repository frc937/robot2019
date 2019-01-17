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
  private TestSolenoid testSolenoid;
  private Camera leftCamera;
  private Camera rightCamera;

  //Runs once when the robot turns on
  @Override
  public void robotInit() {
    controller = new XboxController(Settings.controllerNumber);
    drivetrain = new Drivetrain(controller);
    testSolenoid = new TestSolenoid(controller);
    leftCamera = new Camera();
    rightCamera = new Camera();
  }

  //Loops continuously when teleop mode is enabled
  @Override
  public void teleopPeriodic() {
    drivetrain.driverControl();
    testSolenoid.update();
  }
}
