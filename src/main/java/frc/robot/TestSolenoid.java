/*
 * Test solenoid class
 */

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
//never used message
/* import edu.wpi.first.wpilibj.DoubleSolenoid.Value; */
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class TestSolenoid {

  //Declare variables
  private DoubleSolenoid solenoid1;
  private DoubleSolenoid solenoid2;
  private DoubleSolenoid solenoid3;

  private XboxController controller;

  //contructor
  public TestSolenoid(XboxController controller) {
    solenoid1 = new DoubleSolenoid(Settings.solenoidForwardPort1, Settings.solenoidBackwardPort1);
    solenoid2 = new DoubleSolenoid(Settings.solenoidForwardPort2, Settings.solenoidBackwardPort2);
    solenoid3 = new DoubleSolenoid(Settings.solenoidForwardPort3, Settings.solenoidBackwardPort3);

    this.controller = controller;
  }

  public void update() {
    if(controller.getAButton()) {
      solenoid1.set(DoubleSolenoid.Value.kForward);
    } else if(controller.getBButton()) {
      solenoid1.set(DoubleSolenoid.Value.kReverse);
    } else {
      solenoid1.set(DoubleSolenoid.Value.kOff);
    }

    if(controller.getBumper(Hand.kLeft)) {
      solenoid2.set(DoubleSolenoid.Value.kForward);
    } else if(controller.getXButton()) {
      solenoid2.set(DoubleSolenoid.Value.kReverse);
    } else {
      solenoid2.set(DoubleSolenoid.Value.kOff);
    }
    
    if(controller.getBumper(Hand.kRight)) {
      solenoid3.set(DoubleSolenoid.Value.kForward);
    } else if(controller.getYButton()) {
      solenoid3.set(DoubleSolenoid.Value.kReverse);
    } else {
      solenoid3.set(DoubleSolenoid.Value.kOff);
    }
    
  }

}
