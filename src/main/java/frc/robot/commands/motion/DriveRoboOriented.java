/*
* drive command
*/

package frc.robot.commands.motion;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveRoboOriented extends Command {
    public DriveRoboOriented() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize() {
        setInterruptible(true);
        SmartDashboard.putString("Drive Mode", "Robot Oriented");
    }

    @Override
    protected void execute() {
        Robot.drivetrain.move(
            -Robot.oi.getScaledLeftXAxis(), 
            Robot.oi.getScaledLeftYAxis(), 
            Robot.oi.getScaledRightXAxis()
        );
    }

    @Override
    protected boolean isFinished() {
        //return isCanceled();
        return false;
    }

    @Override
    protected void end() {
        Robot.drivetrain.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}