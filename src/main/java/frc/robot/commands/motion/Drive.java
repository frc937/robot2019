/*
* drive command
*/

package frc.robot.commands.motion;

import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Command {
    public Drive() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize() {
        setInterruptible(true);
        SmartDashboard.putString("Drive Mode", "Mechanum Drive");
    }

    @Override
    protected void execute() {
        Drivetrain.driverControl();
    }

    @Override
    protected boolean isFinished() {
        return isCanceled();
    }

    @Override
    protected void end() {
        Drivetrain.frontLeft.set(0.0);
        Drivetrain.frontRight.set(0.0);
        Drivetrain.backLeft.set(0.0);
        Drivetrain.backRight.set(0.0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}