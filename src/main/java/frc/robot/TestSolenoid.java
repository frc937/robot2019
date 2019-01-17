/*
 * Test solenoid class
 */

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;

public class TestSolenoid {

  //Declare variables
  private DoubleSolenoid testSolenoid;

  private XboxController controller;

  //contructor
  public TestSolenoid(XboxController controller) {
    testSolenoid = new DoubleSolenoid(Settings.solenoidForwardPort, Settings.solenoidBackwardPort);

    this.controller = controller;
  }

  public void update() {
    if(controller.getAButton()) {
      testSolenoid.set(DoubleSolenoid.Value.kForward);
    } else if(controller.getBButton()) {
      testSolenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      testSolenoid.set(DoubleSolenoid.Value.kOff);
    }
  }

}
