/*
* Command for entire claw to move down
*/

package frc.robot.commands.manipulation.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotState;

public class ClawDown extends Command {
    public ClawDown() {
        requires(Robot.moveSolenoid);
        setTimeout(0.9);
    }

    @Override
    protected void initialize() {
        Robot.moveSolenoid.down();
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
        RobotState.isExtended = false;
    }

    @Override
    protected void interrupted() {
        end();
    }
}