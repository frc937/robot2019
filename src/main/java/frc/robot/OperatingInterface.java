/*
* Code for buttons and what they do
*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotState;
import frc.robot.commands.manipulation.claw.*;
import frc.robot.commands.manipulation.elevator.*;

public class OperatingInterface {

    /*
    * variables
    */
    private XboxController controller;

    private Button aButton;
    private Button bButton;
    private Button xButton;
    private Button yButton;
    private Button leftBumper;
    private Button rightBumper;
    private Button backButton;
    private Button startButton;
    private Button leftStick;
    private Button rightStick;
    private Button leftTrigger;
    private Button rightTrigger;

    private POVButton dpadLeft;
    private POVButton dpadRight;
    private POVButton dpadUp;
    private POVButton dpadDown;

    private double leftXAxis;
    private double leftYAxis;
    private double rightXAxis;
    private double rightYAxis;

    private double xLeft;
    private double yLeft;
    private double xRight;
    private double yRight;

    /*
    * constructor
    */
    public OperatingInterface() {
        controller = new XboxController(RobotMap.CONTROLLER_NUMBER);

        aButton = new JoystickButton(controller, RobotMap.A_NUMBER);
        bButton = new JoystickButton(controller, RobotMap.B_NUMBER);
        xButton = new JoystickButton(controller, RobotMap.X_NUMBER);
        yButton = new JoystickButton(controller, RobotMap.Y_NUMBER);
        leftBumper = new JoystickButton(controller, RobotMap.LEFT_BUMPER_NUMBER);
        rightBumper = new JoystickButton(controller, RobotMap.RIGHT_BUMPER_NUMBER);
        backButton = new JoystickButton(controller, RobotMap.BACK_NUMBER);
        startButton = new JoystickButton(controller, RobotMap.START_NUMBER);
        leftStick = new JoystickButton(controller, RobotMap.LEFT_STICK_NUMBER);
        rightStick = new JoystickButton(controller, RobotMap.RIGHT_STICK_NUMBER);
        leftTrigger = new JoystickButton(controller, RobotMap.LEFT_TRIGGER);
        rightTrigger = new JoystickButton(controller, RobotMap.RIGHT_TRIGGER);
        dpadUp = new POVButton(controller, 0);
        dpadRight = new POVButton(controller, 90);
        dpadDown = new POVButton(controller, 180);
        dpadLeft = new POVButton(controller, 270);

        leftBumper.whenPressed(new ClawOpen());
        rightBumper.whenPressed(new ClawClose());
        aButton.whenPressed(new PushOut());
        bButton.whenPressed(new PushIn());
        dpadLeft.whenPressed(new ClawUp());
        dpadRight.whenPressed(new ClawDown());
        
       dpadUp.whileHeld(new Lift());
        dpadDown.whileHeld(new Lower());

    }

    /*
    * methods
    */
    public void stickValues() {
        leftXAxis = controller.getX(Hand.kLeft);
        leftYAxis = controller.getY(Hand.kLeft);
        rightXAxis = controller.getX(Hand.kRight);
        rightYAxis = controller.getY(Hand.kRight);
        xLeft = Math.signum(xLeft) * Math.pow(xLeft, 2);
        yLeft = Math.signum(yLeft) * Math.pow(yLeft, 2);
        xRight = Math.signum(xRight) * Math.pow(xRight, 2);
        yRight = Math.signum(yRight) * Math.pow(yRight, 2);
    }

    // Joysticks
    public double getLeftXAxis() {
        return controller.getX(Hand.kLeft);
    }

    public double getScaledLeftXAxis() {
        return scaleAxis(getLeftXAxis());
       }


    public double getLeftYAxis() {
        return controller.getY(Hand.kLeft);
    }

    public double getScaledLeftYAxis() {
       return scaleAxis(getLeftYAxis());
    }


    public double getRightXAxis() {
        return controller.getX(Hand.kRight);
    }

    public double getScaledRightXAxis() {
        return scaleAxis(getRightXAxis());
    }


    public double getRightYAxis() {
        return controller.getY(Hand.kRight);
    }

    public double getScaledRightYAxis() {
        return scaleAxis(getRightYAxis());
    }


    private double scaleAxis(double a) {
        return Math.signum(a) * Math.pow(a, 4);
    }

}
