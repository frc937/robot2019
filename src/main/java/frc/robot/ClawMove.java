/*
Code for the entire claw to move back and forth
*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class ClawMove {

    //declare variables
    private DoubleSolenoid moveSolenoid;

    private XboxController controller;

    //constructor
    public ClawMove(XboxController controller) {
        moveSolenoid = new DoubleSolenoid(Settings.clawMoveOutPort, Settings.clawMoveInPort);

        this.controller = controller;
    }

    public void update() {
        //forward is out, reverse is in, off is off
        final Value out = DoubleSolenoid.Value.kForward;
        final Value in = DoubleSolenoid.Value.kReverse;
        final Value off = DoubleSolenoid.Value.kOff;

        //move solenoid out if the left bumper is pressed
        if(controller.getBumper(Hand.kLeft)) {
            moveSolenoid.set(out);
            //move solenoid in if right bumper is pressed
        }   else if(controller.getBumper(Hand.kRight)) {
            moveSolenoid.set(in);
            //solenoid is off if neither bumper is pushed
        }   else {
            moveSolenoid.set(off);
        }
    }
}