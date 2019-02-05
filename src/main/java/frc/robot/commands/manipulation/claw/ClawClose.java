/*
* Claw close command
*/

package frc.robot.commands.manipulation.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotState;

public class ClawClose extends Command {
    public ClawClose() {
        requires(Robot.grabSolenoid);
        setTimeout(0.9);
    }
    
    @Override
    protected void initialize() {
        Robot.grabSolenoid.close();
    }
    
    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.grabSolenoid.off();
        RobotState.isOpen = false;
    }

    @Override
    protected void interrupted() {
        end();
    }
}
