package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  public static final int kFrontLeftChannel = 2;
  public static final int kRearLeftChannel = 3;
  public static final int kFrontRightChannel = 1;
  public static final int kRearRightChannel = 0;

  public static final int kJoystickChannel = 0;
  public static final int kJoystickZChannel = 4;

  Camera camera;
  Controller controller;

  @Override
  public void robotInit() {
    camera = new Camera();
    controller = new Controller();

  }

  @Override
  public void teleopPeriodic() {
    
    
  }
}
