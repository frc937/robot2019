/*
* field oriented drive command
*/

package frc.robot.commands.motion;

import frc.robot.Robot;

import java.util.Vector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.IMU.*;

public class DriveFieldOriented extends Command {
    public DriveFieldOriented() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize() {
        setInterruptible(true);
        SmartDashboard.putString("Drive Mode", "Field Oriented");
    }

    @Override
    protected void execute() {
        //get direction from joystick
        double x = -Robot.oi.getLeftXAxis();
        double y = Robot.oi.getLeftYAxis();
        Vector3D joystickVector = new Vector3D(x, y, 0);






        Robot.drivetrain.move(
            -Robot.oi.getScaledLeftXAxis(), 
            Robot.oi.getScaledLeftYAxis(), 
            Robot.oi.getScaledRightXAxis()
        );
    }

    @Override
    protected boolean isFinished() {
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