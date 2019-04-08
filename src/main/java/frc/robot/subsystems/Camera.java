/*
 * Camera code
 */

package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {

  /*
  * constructor 
  */
  //(run whenever the: = new Camera() code is run)
  public Camera() {
    startCamera();
  }

  /*
  * interface methods
  */
  @Override
  protected void initDefaultCommand() {
  }

  /*
  * local methods
  */
  private void startCamera() {
    CameraServer.getInstance().startAutomaticCapture();
  }

}
