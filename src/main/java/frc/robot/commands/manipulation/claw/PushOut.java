/* 
* Command for push mechanism to push out
*/

package frc.robot.commands.manipulation.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotState;

public class PushOut extends Command {
    public PushOut() {
        requires(Robot.moveSolenoid);
        setTimeout(0.9);
    }

    @Override
    protected void initialize() {
        Robot.pushSolenoid.forward();
        System.out.println("pushout");
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
        RobotState.isPushed = true;
    }

    @Override
    protected void interrupted() {
        end();
    }
}