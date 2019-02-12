package frc.robot.commands.manipulation.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;
import frc.robot.Robot;

public class Lower extends Command {
    public Lower() {
        requires(Robot.elevator);
    }

    @Override
    protected void initialize() {
        setInterruptible(true);
    }

    @Override
    protected void execute() {
        Elevator.down();
    }

    @Override
    protected boolean isFinished() {
        return isCanceled();
    }

    @Override
    protected void end() {
        Elevator.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }

}