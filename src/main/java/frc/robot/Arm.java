/*
 * arm controller class
 */

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//never used message
/* import edu.wpi.first.wpilibj.DoubleSolenoid.Value; */

public class Arm {

  //Declare variables
  private DoubleSolenoid armLRSolenoid;
  private DoubleSolenoid armUDSolenoid;

  private XboxController controller;

  //contructor
  public Arm(XboxController controller) {
    armLRSolenoid = new DoubleSolenoid(Settings.armLROutPort, Settings.armLRInPort);
    armUDSolenoid = new DoubleSolenoid(Settings.armUDOutPort, Settings.armUDInPort);

    this.controller = controller;
  }

  public void update() {
    //control the "arm" with the d-pad
    final DoubleSolenoid.Value out = DoubleSolenoid.Value.kForward;
    final DoubleSolenoid.Value in = DoubleSolenoid.Value.kReverse;
    final DoubleSolenoid.Value off = DoubleSolenoid.Value.kOff;
    
    final int dPad = controller.getPOV();
    
    //big honkin' thing to deal with every direction the D-Pad can be pushed
    switch(dPad) {
      case 0: 
        armLRSolenoid.set(off);
        armUDSolenoid.set(out);
      break;
      case 45: 
        armLRSolenoid.set(out);
        armUDSolenoid.set(out);
      break;
      case 90: 
        armLRSolenoid.set(out);
        armUDSolenoid.set(off);
      break;
      case 135: 
        armLRSolenoid.set(out);
        armUDSolenoid.set(in);
      break;
      case 180: 
        armLRSolenoid.set(off);
        armUDSolenoid.set(in);
      break;
      case 225: 
        armLRSolenoid.set(in);
        armUDSolenoid.set(in);
      break;
      case 270: 
        armLRSolenoid.set(in);
        armUDSolenoid.set(off);
      break;
      case 315: 
        armLRSolenoid.set(in);
        armUDSolenoid.set(out);
      break;
    }
    
  }

}
