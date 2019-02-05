/*
* Code for buttons and what they do
*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotState;
import frc.robot.commands.manipulation.claw.*;

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
    private Button dPadLeft;
    private Button dPadRight;
    private Button dPadUp;
    private Button dPadDown;

    /*
    * constructor
    */
    public OperatingInterface(XboxController controller) {
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
        dPadLeft = new JoystickButton(controller, RobotMap.DPAD_LEFT);
        dPadRight = new JoystickButton(controller, RobotMap.DPAD_RIGHT);
        dPadUp = new JoystickButton(controller, RobotMap.DPAD_UP);
        dPadDown = new JoystickButton(controller, RobotMap.DPAD_DOWN);


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

        dPadLeft.whenPressed(new ClawBackward());

        dPadRight.whenPressed(new ClawForward());

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
