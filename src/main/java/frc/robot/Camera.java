/*
 * Camera code
 */

package frc.robot;

//Import packages
import edu.wpi.first.cameraserver.CameraServer;

public class Camera {

  //constructor (run whenever the: = new Camera() code is run)
  public Camera() {
    startCamera();
  }

  private void startCamera() {
    CameraServer.getInstance().startAutomaticCapture();
  }

}
