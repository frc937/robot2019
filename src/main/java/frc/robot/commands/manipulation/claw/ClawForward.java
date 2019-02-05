/* 
* Command for entire claw to move forward
*/

package frc.robot.commands.manipulation.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotState;

public class ClawForward extends Command {
    public ClawForward() {
        requires(Robot.moveSolenoid);
        setTimeout(0.9);
    }

    @Override
    protected void initialize() {
        Robot.moveSolenoid.forward();
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
        RobotState.isExtended = true;
    }

    @Override
    protected void interrupted() {
        end();
    }
}