/*
 * Mecanum drivetrain code
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.motion.*;

public class Drivetrain extends Subsystem {

  /*
  * Declare variables
  */
  public static Talon frontLeft;
  public static Talon frontRight;
  public static Talon backLeft;
  public static Talon backRight;

  private static MecanumDrive drivetrain;


  /*
  * constructor (run whenever the: = new Drivetrain() code is run)
  */
  public Drivetrain() {
    frontLeft = new Talon(RobotMap.DRIVE_FRONT_LEFT_PORT);
    frontRight = new Talon(RobotMap.DRIVE_FRONT_RIGHT_PORT);
    backLeft = new Talon(RobotMap.DRIVE_BACK_LEFT_PORT);
    backRight = new Talon(RobotMap.DRIVE_BACK_RIGHT_PORT);

    frontLeft.setInverted(false);
    frontRight.setInverted(false);
    backLeft.setInverted(false);
    backRight.setInverted(false);

    drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

  }

  /*
  * interface methods
  */
  // default command is drive command
  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveRoboOriented());
  }

  /*
  * local methods
  */
  
  public void move(double x, double y, double z) {
    drivetrain.driveCartesian(x, y, z);
  }

  public void moveRelative(double x, double y, double z, double gyro) {
    drivetrain.driveCartesian(x, y, z, gyro);
  }

  public void stop() {
    frontLeft.set(0.0);
    frontRight.set(0.0);
    backLeft.set(0.0);
    backRight.set(0.0);
  }

}
