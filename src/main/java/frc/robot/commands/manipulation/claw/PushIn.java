/* 
* Command for push mechanism to retract
*/

package frc.robot.commands.manipulation.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotState;

public class PushIn extends Command {
    public PushIn() {
        requires(Robot.moveSolenoid);
        setTimeout(0.9);
    }

    @Override
    protected void initialize() {
        Robot.pushSolenoid.backward();
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
        RobotState.isPushed = false;
    }

    @Override
    protected void interrupted() {
        end();
    }
}