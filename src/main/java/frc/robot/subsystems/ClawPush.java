/*
* Code for push mechanism inside the claw
*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

public class ClawPush extends Subsystem {

    /*
    * variables
    */
    private DoubleSolenoid pushSolenoid;

    /*
    * constructor
    */
    public ClawPush() {
        pushSolenoid = new DoubleSolenoid(RobotMap.CLAW_PUSH_OUT_PORT, RobotMap.CLAW_PUSH_IN_PORT);
        backward();
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
    public void forward() {
        System.out.println("pushforward");
        pushSolenoid.set(Value.kForward);
    }

    public void backward() {
        System.out.println("pushback");
        pushSolenoid.set(Value.kReverse);
    }

    public void off() {
        pushSolenoid.set(Value.kOff);
    }
}