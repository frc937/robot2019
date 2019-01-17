/*
 * Main loops and methods for the robot
 */

package frc.robot;

//Import packages
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Robot extends TimedRobot {

  //Declare variables

  //controllers
  private XboxController controller;

  //drivetrain
  private Drivetrain drivetrain;

  //solenoids
  DoubleSolenoid solenoid;
  
  //camera
  Camera leftCamera;
  Camera rightCamera;

  //Runs once when the robot turns on
  @Override
  public void robotInit() {
    
    //solenoids
    solenoid = new DoubleSolenoid(Settings.solenoidForwardPort, Settings.solenoidBackwardPort);

    //controllers
    controller = new XboxController(Settings.controllerNumber);

    //drivetrain
    drivetrain = new Drivetrain();
    //cameras
    leftCamera = new Camera();
    rightCamera = new Camera();
  }

  //Loops continuously when teleop mode is enabled
  @Override
  public void teleopPeriodic() {

    drivetrain.driverControl(controller);

    //solenoid control logic
    if(controller.getAButton()) {
      solenoid.set(DoubleSolenoid.Value.kForward);
    } else if(controller.getBButton()) {
      solenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      solenoid.set(DoubleSolenoid.Value.kOff);
    }

  }
}
