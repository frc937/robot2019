package frc.robot.commands.manipulation.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

public class Lift extends Command {
    public Lift() {
        requires(Robot.elevator);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}