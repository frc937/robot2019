/*
 * File for settings and magic numbers
 */

package frc.robot;

public class Settings {

  //drive motors
  public static final int frontLeftPort  = 0;
  public static final int frontRightPort = 1;
  public static final int backLeftPort   = 2;
  public static final int backRightPort  = 3;

  //solenoid
  public static final int solenoidForwardPort  = 0;
  public static final int solenoidBackwardPort = 1;

  //controller
  public static final int controllerNumber = 0;

  //line tracking
  public static final double lineTrackStopDistance  = 1.0;
  public static final double lineTrackTurnSpeed     = 0.3;
  public static final double lineTrackThreshold     = 0.5;
  public static final double lineTrackMoveSpeed     = 0.4;
  public static final double lineTrackSidewaysSpeed = 0.3;
  public static final int ultrasonicPingPort = 0;
  public static final int ultrasonicEchoPort = 1;
}
