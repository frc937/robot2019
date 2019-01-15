package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {
    private Joystick m_stick;

    public Controller() {
        m_stick = new Joystick(Robot.kJoystickChannel);
        m_stick.setZChannel(Robot.kJoystickZChannel);
    }

    public double getX() {
        return m_stick.getX();
    }
}