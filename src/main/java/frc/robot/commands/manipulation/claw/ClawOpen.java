/*
* Claw open command
*/

package frc.robot.commands.manipulation.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotState;

public class ClawOpen extends Command {
    public ClawOpen() {
        requires(Robot.grabSolenoid);
        setTimeout(0.9);
    }

    @Override
    protected void initialize() {
        Robot.grabSolenoid.open();
        System.out.println("clawopen");
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
        RobotState.isOpen = true;
    }

    @Override 
    protected void interrupted() {
        end();
    }
}