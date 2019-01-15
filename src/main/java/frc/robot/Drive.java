package frc.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive {

    private MecanumDrive m_robotDrive;
    private Talon frontLeft;
    private Talon rearLeft;
    private Spark frontRight;
    private Spark rearRight; 
    
    public Drive() {
        frontLeft = new Talon(Robot.kFrontLeftChannel);
        rearLeft = new Talon(Robot.kRearLeftChannel);
        frontRight = new Spark(Robot.kFrontRightChannel);
        rearRight = new Spark(Robot.kFrontLeftChannel);

        frontLeft.setInverted(true);
        rearLeft.setInverted(true);

        m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    }
    
    public void update() {
        m_robotDrive.driveCartesian(Robot.controller.getX(), 0, 0, 0.0);

    }
    
}