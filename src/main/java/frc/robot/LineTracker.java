/*
 * Logic for the robot's line tracking system

To actually hook these components up, ask Tom, he probably knows what to do

 */

package frc.robot;

//import whatever we need for line sensors
import edu.wpi.first.wpilibj.Ultrasonic;

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

  Ultrasonic rangefinder;

  Drivetrain drivetrain;

  //Constructor
  public LineTracker(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;

    //setup rangefinder to use inches
    rangefinder = new Ultrasonic(Settings.ultrasonicPingPort, Settings.ultrasonicEchoPort, Ultrasonic.Unit.kInches);

    //setup line trackers

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
    final SIDE side = getFrontSide();

    return side == SIDE.left;
  }

  private boolean isAimedRight() {
    final SIDE side = getFrontSide();

    return side == SIDE.right;
  }

  private boolean isTooLeft() {
    final SIDE front = getFrontSide();
    final SIDE back = getBackSide();

    return front == SIDE.left && back == SIDE.left;
  }

  private boolean isTooRight() {
    final SIDE front = getFrontSide();
    final SIDE back = getBackSide();

    return front == SIDE.right && back == SIDE.right;
  }

  private enum SIDE {
    left, center, right
  }

  //get which side of the line the front sensor is on
  private SIDE getFrontSide() {
    return SIDE.center;
  }

  //get which side of the line the back sensor is on
  private SIDE getBackSide() {
    return SIDE.center;
  }

  private boolean shouldStop() {
    return rangefinder.getRangeInches() < Settings.lineTrackStopDistance;
  }

  private boolean getFrontLeft() {
    final boolean onLine = frontLeft.methodToGetSensorValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean getFrontRight() {
    final boolean onLine = frontRight.methodToGetSensorValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean getBackLeft() {
    final boolean onLine = backLeft.methodToGetSensorValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean getBackRight() {
    final boolean onLine = backRight.methodToGetSensorValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }
}
