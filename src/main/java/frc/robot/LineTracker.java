/*
 * Logic for the robot's line tracking system

To actually hook these components up, ask Tom, he probably knows what to do

 */

package frc.robot;

//import whatever we need for line sensors
//import whatever we need for the ultrasonic rangefinder

public class LineTracker {

  //Declare variables
  LineSensor frontLeft;
  LineSensor frontRight;
  LineSensor backLeft;
  LineSensor backRight;

  boolean frontLeftFlag = false;
  boolean frontRightFlag = false;
  boolean backLeftFlag = false;
  boolean backRightFlag = false;

  UltrasonicRangefinder rangefinder;

  Drivetrain drivetrain;

  //Constructor
  public LineTracker(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
  }

  //resets variables
  public resetLine() {
    frontLeftFlag = false;
    frontRightFlag = false;
    backLeftFlag = false;
    backRightFlag = false;
  }

  //needs to be called continuously
  public void followLine() {
    if(!shouldStop()) {
      //zero values
      double sideways = 0;
      double turn = 0;

      //correction logic
      if(isAimedLeft()) turn = Settings.lineTrackTurnSpeed;
      if(isAimedRight()) turn = -Settings.lineTrackTurnSpeed;
      if(isTooLeft()) sideways = Settings.lineTrackSidewaysSpeed;
      if(isTooRight()) sideways = -Settings.lineTrackSidewaysSpeed;

      //move
      drivetrain.move(sideways, Settings.lineTrackMoveSpeed, turn);
    }
  }

  private boolean isAimedLeft() {
    return false;
  }

  private boolean isAimedRight() {
    return false;
  }

  private boolean isTooLeft() {
    return false;
  }

  private boolean isTooRight() {
    return false;
  }

  private boolean shouldStop() {
    return rangefinder.methodToGetDistance() < Settings.lineTrackStopDistance;
  }

  private boolean checkFrontLeft() {
    final boolean onLine = frontLeft.methodToGetSensorValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean checkFrontRight() {
    final boolean onLine = frontRight.methodToGetSensorValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean checkBackLeft() {
    final boolean onLine = backLeft.methodToGetSensorValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean checkBackRight() {
    final boolean onLine = backRight.methodToGetSensorValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }
}
