/*
 * Test solenoid class
 */

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;

public class TestSolenoid {

  //Declare variables
  private DoubleSolenoid testSolenoid;

  //contructor
  public TestSolenoid() {
    testSolenoid = new DoubleSolenoid(Settings.solenoidForwardPort, Settings.solenoidBackwardPort);
  }

  public void update(XboxController controller) {
    if(controller.getAButton()) {
      testSolenoid.set(DoubleSolenoid.Value.kForward);
    } else if(controller.getBButton()) {
      testSolenoid.set(DoubleSolenoid.Value.kReverse);
    } else {
      testSolenoid.set(DoubleSolenoid.Value.kOff);
    }
  }

}