/*
 * claw controller class
 */

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value; //this was used to specify the direction of the solenoid
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Claw {

  //Declare variables
  private DoubleSolenoid clawSolenoid;

  private XboxController controller;

  //contructor
  public Claw(XboxController controller) {
    clawSolenoid = new DoubleSolenoid(Settings.clawOutPort, Settings.clawInPort);
    
    this.controller = controller;
  }

  public void update() {
    //move solenoid out if right bumper pressed
    //move solenoid in if left bumper pressed
    final DoubleSolenoid.Value out = DoubleSolenoid.Value.kForward;
    final DoubleSolenoid.Value in = DoubleSolenoid.Value.kReverse;
    final DoubleSolenoid.Value off = DoubleSolenoid.Value.kOff;

    if(controller.getBumperPressed(Hand.kRight)) {
      clawSolenoid.set(out);
    } else if(controller.getBumperPressed(Hand.kLeft)) {
      clawSolenoid.set(in);
    } else {
      clawSolenoid.set(off);
    }
    
  }

}
