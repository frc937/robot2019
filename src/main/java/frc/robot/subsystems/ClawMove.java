/*
* Code for entire claw to move up and down
*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

public class ClawMove extends Subsystem {

    /*
    * variables
    */
    private DoubleSolenoid moveSolenoid;

    /*
    * constructor
    */
    public ClawMove() {
        moveSolenoid = new DoubleSolenoid(RobotMap.CLAW_MOVE_OUT_PORT, RobotMap.CLAW_MOVE_IN_PORT);
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
    public void up() {
        moveSolenoid.set(Value.kReverse);
    }

    public void down() {
        moveSolenoid.set(Value.kForward);
    }

    public void off() {
        moveSolenoid.set(Value.kOff);
    }
}