/*
Code for the push mechanism inside the claw for pushing ball or hatch
*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.XboxController;

public class ClawPush {

    //declare variables
    private DoubleSolenoid pushSolenoid;

    private XboxController controller;

    //constructor
    public ClawPush(XboxController controller) {
        pushSolenoid = new DoubleSolenoid(Settings.clawPushOutPort, Settings.clawPushInPort);

        this.controller = controller;
    }

    public void update() {
        //out is forward, in is reverse, off is off
        final Value out = DoubleSolenoid.Value.kForward;
        final Value in = DoubleSolenoid.Value.kReverse;
        final Value off = DoubleSolenoid.Value.kOff;

        //move solenoid out if the A button is pushed
        if(controller.getAButton()) {
            pushSolenoid.set(out);
            //move solenoid in if the B button is pushed
        }   else if(controller.getBButton()) {
            pushSolenoid.set(in);
            //solenoid is off if neither the A or B button is pushed
        }   else {
            pushSolenoid.set(off);
        }
    }
}