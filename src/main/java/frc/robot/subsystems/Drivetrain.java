/*
 * Mecanum drivetrain code
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Spark;
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
  public static Spark frontRight;
  public static Talon backLeft;
  public static Spark backRight;

  private static MecanumDrive drivetrain;

  private static XboxController controller;

  /*
  * constructor (run whenever the: = new Drivetrain() code is run)
  */
  public Drivetrain(XboxController controller) {
    frontLeft = new Talon(RobotMap.FRONT_LEFT_PORT);
    frontRight = new Spark(RobotMap.FRONT_RIGHT_PORT);
    backLeft = new Talon(RobotMap.BACK_LEFT_PORT);
    backRight = new Spark(RobotMap.BACK_RIGHT_PORT);

    frontLeft.setInverted(true);
    backLeft.setInverted(true);

    drivetrain = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

    this.controller = controller;
  }

  /*
  * interface methods
  */
  // default command is drive command
  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new Drive());

  }

  /*
  * local methods
  */
  public static void driverControl() {
    // Use the joystick X axis for lateral movement, Y axis for forward movement, and Z axis for rotation.
    final double x = controller.getX(Hand.kLeft);
    final double y = controller.getY(Hand.kLeft);
    final double z = controller.getX(Hand.kRight);

    drivetrain.driveCartesian(x, y, z, 0.0);
  }

}
