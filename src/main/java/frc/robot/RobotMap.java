/*
 * File for settings and magic numbers
 */

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class RobotMap {

  private static XboxController controller;

  //drive motors
  public static final int FRONT_LEFT_PORT  = 2;
  public static final int FRONT_RIGHT_PORT = 3;
  public static final int BACK_LEFT_PORT   = 0;
  public static final int BACK_RIGHT_PORT  = 1;

  //elevator motor
  public static final int ELEVATOR_PORT = 4;

  //encoder inputs
  public static final int ENCODER_INPUT_1 = 0;
  public static final int ENCODER_INPUT_2 = 1;

  public static final double DISTANCE_PER_PULSE = 0.05;
  
  //solenoid
  public static final int CLAW_PUSH_OUT_PORT  = 0;
  public static final int CLAW_PUSH_IN_PORT = 1;
  public static final int CLAW_MOVE_OUT_PORT = 2;
  public static final int CLAW_MOVE_IN_PORT = 3;
  public static final int CLAW_GRAB_OUT_PORT = 4;
  public static final int CLAW_GRAB_IN_PORT = 5;

  //controller
  public static final int CONTROLLER_NUMBER = 0;

  public static final int A_NUMBER = 1;
  public static final int B_NUMBER = 2;
  public static final int X_NUMBER = 3;
  public static final int Y_NUMBER = 4;
  public static final int LEFT_BUMPER_NUMBER = 5;
  public static final int RIGHT_BUMPER_NUMBER = 6;
  public static final int BACK_NUMBER = 7;
  public static final int START_NUMBER = 8;
  public static final int LEFT_STICK_NUMBER = 9;
  public static final int RIGHT_STICK_NUMBER = 10;

  //public static final int DPAD_LEFT = controller.getPOV(270);
  //public static final int DPAD_RIGHT = controller.getPOV(90);
  //public static final int DPAD_UP = controller.getPOV(0);
  //public static final int DPAD_DOWN = controller.getPOV(180);

  public static final int LEFT_X_AXIS = 0;
  public static final int LEFT_Y_AXIS = 1;
  public static final int RIGHT_X_AXIS = 4;
  public static final int RIGHT_Y_AXIS = 5;

  public static final int LEFT_TRIGGER = 2;
  public static final int RIGHT_TRIGGER = 3;
  public static final double TRIGGER_PULL_THRESHOLD = 0.7;

}
