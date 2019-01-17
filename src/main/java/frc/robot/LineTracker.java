/*
 * Logic for the robot's line tracking system

To actually hook these components up, ask Tom, he probably knows what to do

we got a new ultrasonic rangefinder this year in the kit of parts
rangefinder datasheet: https://www.maxbotix.com/documents/HRLV-MaxSonar-EZ_Datasheet.pdf

the vex line trackers should work on 5V analog, so if you can get a wire for it,
you can plug the line sensors right into the roborio analog sensors
I couldn't find a datasheet for the line trackers
 */

package frc.robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.AnalogInput;

public class LineTracker {

  //Declare variables
  AnalogInput frontLeft;
  AnalogInput frontRight;
  AnalogInput backLeft;
  AnalogInput backRight;

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
    frontLeft = new AnalogInput(Settings.lineTrackFrontLeftPort);
    frontLeft = new AnalogInput(Settings.lineTrackFrontRightPort);
    frontLeft = new AnalogInput(Settings.lineTrackBackLeftPort);
    frontLeft = new AnalogInput(Settings.lineTrackBackRightPort);
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
    final boolean onLine = frontLeft.getValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean getFrontRight() {
    final boolean onLine = frontRight.getValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean getBackLeft() {
    final boolean onLine = backLeft.getValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }

  private boolean getBackRight() {
    final boolean onLine = backRight.getValue() > Settings.lineTrackThreshold;
    //frontLeftFlag = onLine;
    return onLine;
  }
}
