package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;

public class Camera {
    public Camera() {
        CameraServer.getInstance().startAutomaticCapture();
        CameraServer.getInstance().startAutomaticCapture();
    }
}