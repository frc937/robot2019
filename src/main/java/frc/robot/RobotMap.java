/*
 * File for settings and magic numbers
 * 
 * Magic numbers are numbers with no explanation of why they are what they are.
 * Most of them are port numbers or stuff like that.
 * 
 * They are in ALL_CAPS rather than CamelCase so you know not to mess with them.
 */


package frc.robot;

public class RobotMap {

  /*
  * Drive motors
  */
  public static final int DRIVE_BACK_LEFT_PORT   = 0;
  public static final int DRIVE_BACK_RIGHT_PORT  = 1;
  public static final int DRIVE_FRONT_LEFT_PORT  = 2;
  public static final int DRIVE_FRONT_RIGHT_PORT = 3;

  /*
  * Elevator motors
  */ 
  public static final int ELEVATOR1_PORT = 4;
  public static final int ELEVATOR2_PORT = 5;

  /*
  * Encoder inputs
  */
  public static final int ENCODER_INPUT_1 = 0;
  public static final int ENCODER_INPUT_2 = 1;

  public static final double DISTANCE_PER_PULSE = 0.05;
  
  /*
  * Solenoids
  */
  public static final int CLAW_PUSH_OUT_PORT  = 0;
  public static final int CLAW_PUSH_IN_PORT = 1;
  public static final int CLAW_MOVE_OUT_PORT = 2;
  public static final int CLAW_MOVE_IN_PORT = 3;
  public static final int CLAW_GRAB_OUT_PORT = 4;
  public static final int CLAW_GRAB_IN_PORT = 5;

  /* 
  * Controller
  */
  public static final int CONTROLLER_NUMBER = 0;
  public static final double TRIGGER_PULL_THRESHOLD = 0.7;

}
