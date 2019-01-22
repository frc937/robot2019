/*
Code for the claw to grab things
*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.XboxController;

public class ClawGrab {

    //declare variables
    private DoubleSolenoid grabSolenoid;

    private XboxController controller;

    //constructor
    public ClawGrab(XboxController controller) {
        grabSolenoid = new DoubleSolenoid(Settings.clawGrabOutPort, Settings.clawGrabInPort);

        this.controller = controller;
    }

    public void update() {
        //forward is out, reverse is in, off is off
        final Value out = DoubleSolenoid.Value.kForward;
        final Value in = DoubleSolenoid.Value.kReverse;
        final Value off = DoubleSolenoid.Value.kOff;

        //move solenoid out if the X button is pressed
        if(controller.getXButton()) {
            grabSolenoid.set(out);
            //move solenoid in if the Y button is pressed
        }   else if(controller.getYButton()) {
            grabSolenoid.set(in);
            //solenoid is off if neither button is pressed
        }   else {
            grabSolenoid.set(off);
        }
    }
}