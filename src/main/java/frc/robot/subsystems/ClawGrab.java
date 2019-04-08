 /*
 * Code for claw to grab things
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;


public class 
ClawGrab extends Subsystem { 

  /*
  * variables
  */
  private DoubleSolenoid grabSolenoid;

  /*
  * contructor
  */
  public ClawGrab() {
    grabSolenoid = new DoubleSolenoid(RobotMap.CLAW_GRAB_OUT_PORT, RobotMap.CLAW_GRAB_IN_PORT);
    close();
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
    System.out.println("open");
    grabSolenoid.set(Value.kReverse);
  }

  public void close() {
    System.out.println("close");
    grabSolenoid.set(Value.kForward);
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
