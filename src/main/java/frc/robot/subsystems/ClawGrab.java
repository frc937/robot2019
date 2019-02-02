 /*
 * Code for claw to grab things
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;


public class ClawGrab extends Subsystem { 

  /*
  * variables
  */
  private DoubleSolenoid grabSolenoid;

  /*
  * contructor
  */
  public ClawGrab() {
    grabSolenoid = new DoubleSolenoid(RobotMap.CLAW_GRAB_OUT_PORT, RobotMap.CLAW_GRAB_IN_PORT);
  }

  /*
  * interface methods
  */
  @Override
  protected void initDefaultCommand() {
  }

  /*
  * local methods
  */
  public void open() {
    grabSolenoid.set(Value.kForward);
  }

  public void close() {
    grabSolenoid.set(Value.kReverse);
  }

  public void off() {
    grabSolenoid.set(Value.kOff);
  }

  // old but don't want to delete
  //public void update() {
    //if(controller.getAButton()) {
      //grabSolenoid.set(DoubleSolenoid.Value.kForward);
    //} else if(controller.getBButton()) {
      //grabSolenoid.set(DoubleSolenoid.Value.kReverse);
    //} else {
      //grabSolenoid.set(DoubleSolenoid.Value.kOff);
    //}
  //}
}
