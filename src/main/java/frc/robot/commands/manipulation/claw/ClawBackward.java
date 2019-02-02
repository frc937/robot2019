/*
* Command for entire claw to move backward
*/

package frc.robot.commands.manipulation.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ClawBackward extends Command {
    public ClawBackward() {
        requires(Robot.moveSolenoid);
        setTimeout(0.9);
    }

    @Override
    protected void initialize() {
        Robot.moveSolenoid.backward();
    }
    
    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.moveSolenoid.off();
    }

    @Override
    protected void interrupted() {
        end();
    }
}