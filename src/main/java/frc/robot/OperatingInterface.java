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
    //private POVButton dpadX;
    //private POVButton dpadY;

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
    //public OperatingInterface(XboxController controller) {
        //this.controller = controller;

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
        //dPadLeft = new JoystickButton(controller, RobotMap.DPAD_LEFT);
        //dPadRight = new JoystickButton(controller, RobotMap.DPAD_RIGHT);
        //dPadUp = new JoystickButton(controller, RobotMap.DPAD_UP);
        //dPadDown = new JoystickButton(controller, RobotMap.DPAD_DOWN);
        dpadUp = new POVButton(controller, 0);
        dpadRight = new POVButton(controller, 90);
        dpadDown = new POVButton(controller, 180);
        dpadLeft = new POVButton(controller, 270);

        /*
        int dpadAngle = controller.getPOV(RobotMap.POV_NUMBER);
        switch (dpadAngle) {
            case 0:
                new Lift();
                //dpadUp = true;
                //dpadX = 0;
                //dpadY = 1;
                break;
            case 45:
                dpadUp = true;
                dpadRight = true;
                dpadX = 0.5;
                dpadY = 0.5;
                break;
            case 90:
                dpadRight = true;
                dpadX = 1;
                dpadY = 0;
                break;
            case 135:
                dpadRight = true;
                dpadDown = true;
                dpadX = 0.5;
                dpadY = -0.5;
                break;
            case 180:
                dpadDown = true;
                dpadX = 0;
                dpadY = -1;
                break;
            case 225:
                dpadDown = true;
                dpadLeft = true;
                dpadX = -0.05;
                dpadY = -0.05;
                break;
            case 270:
                dpadLeft = true;
                dpadX = -1;
                dpadY = 0;
                break;
            case 315:
                dpadLeft = true;
                dpadUp = true;
                dpadX = -0.5;
                dpadY = 0.5;
                break;
            default:
                dpadX = 0;
                dpadY = 0;
                break;
        }
        */

        if(RobotState.isOpen = false) {
            leftBumper.whenPressed(new ClawOpen());
        }
        
        if(RobotState.isOpen = true) {
            leftBumper.whenPressed(new ClawClose());
        }

        if(RobotState.isPushed = false) {
            rightBumper.whenPressed(new PushOut());
        }

        if(RobotState.isPushed = true) {
            rightBumper.whenPressed(new PushIn());
        }

        dpadLeft.whenPressed(new ClawUp());
        dpadRight.whenPressed(new ClawDown());
        dpadUp.whileActive(new Lift());
        dpadDown.whileActive(new Lower());

        /*
        while(dpadAngle == 0) {
            new Lift();
        }

        while(dpadAngle == 180) {
            new Lower();
        }

        if(dpadAngle == 270) {
            new ClawUp();
        }

        if(dpadAngle == 90) {
            new ClawDown();
        }
        */
    }

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



    /*
    * All the stuff that's commented out is how it's recomended to do it.
    * I prefer to declare variables before the constructor, rather than inside it, 
    * but I don't know if this works for this so yeah.
    */

    //public static XboxController controller = new XboxController(RobotMap.CONTROLLER_NUMBER);

    //Button aButton = new JoystickButton(controller, RobotMap.A_NUMBER),
        //bButton = new JoystickButton(controller, RobotMap.B_NUMBER),
        //xButton = new JoystickButton(controller, RobotMap.X_NUMBER),
        //yButton = new JoystickButton(controller, RobotMap.Y_NUMBER),
        //leftBumper = new JoystickButton(controller, RobotMap.LEFT_BUMPER_NUMBER),
        //rightBumper = new JoystickButton(controller, RobotMap.RIGHT_BUMPER_NUMBER),
        //backButton = new JoystickButton(controller, RobotMap.BACK_NUMBER),
        //startButton = new JoystickButton(controller, RobotMap.START_NUMBER),
        //leftStick = new JoystickButton(controller, RobotMap.LEFT_STICK_NUMBER),
        //rightStick = new JoystickButton(controller, RobotMap.RIGHT_STICK_NUMBER),
        //leftTrigger = new JoystickButton(controller, RobotMap.LEFT_TRIGGER),
        //rightTrigger = new JoystickButton(controller, RobotMap.RIGHT_TRIGGER);

}
