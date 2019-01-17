/*
 * Logic for the robot's line tracking system

To actually hook these components up, ask Tom, he probably knows what to do

we got a new ultrasonic rangefinder this year in the kit of parts
rangefinder datasheet: https://www.maxbotix.com/documents/HRLV-MaxSonar-EZ_Datasheet.pdf

the vex line trackers should work on 5V analog, so if you can get a wire for it,
you can plug the line sensors right into the roborio analog sensors
I couldn't find a datasheet for the line trackers

PS. All of this code is completely untested it probably doesn't all work
 */

package frc.robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.AnalogInput;

public class LineTracker {

  //Declare variables
  private AnalogInput frontLeft;
  private AnalogInput frontRight;
  private AnalogInput backLeft;
  private AnalogInput backRight;

  private boolean frontLeftFlag = false;
  private boolean frontRightFlag = false;
  private boolean backLeftFlag = false;
  private boolean backRightFlag = false;

  private boolean frontOnLeft = false;
  private boolean frontOnRight = false;
  private boolean backOnLeft = false;
  private boolean backOnRight = false;

  private Ultrasonic rangefinder;

  private Drivetrain drivetrain;

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
  //THIS IS WHERE IT'S PROBABLY BROKEN
  private SIDE getFrontSide() {

    //check if it's moving to the side
    if(frontLeftFlag && frontRightFlag) {
      if(!frontOnRight) {
        if(!getFrontRight()) {
          frontOnRight = true;
        }
      } else if (!frontOnLeft) {
        if(!getFrontLeft()) {
          frontOnLeft = true;
        }
      }
    }

    //check if it's moving to the center
    if(frontOnLeft || frontOnRight) {
      if(frontLeftFlag && !getFrontLeft()) {
        frontOnLeft = false;
      } else if(frontOnRight && !getFrontRight()) {
        frontOnRight = false;
      }
    }

    //set flags
    frontLeftFlag = getFrontLeft();
    frontRightFlag = getFrontRight();

    //return answer
    if(frontOnLeft) {
      return SIDE.left
    } else if (frontOnRight) {
      return SIDE.right
    } else {
      return SIDE.center;
    }
  }

  //get which side of the line the back sensor is on
  //THIS IS WHERE IT'S PROBABLY BROKEN
  private SIDE getBackSide() {

    //check if it's moving to the side
    if(backLeftFlag && backRightFlag) {
      if(!backOnRight) {
        if(!getBackRight()) {
          backOnRight = true;
        }
      } else if (!backOnLeft) {
        if(!getBackLeft()) {
          backOnLeft = true;
        }
      }
    }

    //check if it's moving to the center
    if(backOnLeft || backOnRight) {
      if(backLeftFlag && !getBackLeft()) {
        backOnLeft = false;
      } else if(backOnRight && !getBackRight()) {
        backOnRight = false;
      }
    }

    //set flags
    backLeftFlag = getBackLeft();
    backRightFlag = getBackRight();

    //return answer
    if(backOnLeft) {
      return SIDE.left
    } else if (backOnRight) {
      return SIDE.right
    } else {
      return SIDE.center;
    }
  }

  private boolean shouldStop() {
    return rangefinder.getRangeInches() < Settings.lineTrackStopDistance;
  }

  private boolean getFrontLeft() {
    final boolean onLine = frontLeft.getValue() > Settings.lineTrackThreshold;
    return onLine;
  }

  private boolean getFrontRight() {
    final boolean onLine = frontRight.getValue() > Settings.lineTrackThreshold;
    return onLine;
  }

  private boolean getBackLeft() {
    final boolean onLine = backLeft.getValue() > Settings.lineTrackThreshold;
    return onLine;
  }

  private boolean getBackRight() {
    final boolean onLine = backRight.getValue() > Settings.lineTrackThreshold;
    return onLine;
  }
}
