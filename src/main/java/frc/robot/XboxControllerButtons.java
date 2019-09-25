package frc.robot;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Xbox Controller Buttons
 * contains all of the xbox's functions
 * in an easy way for the command based
 * programming to read.
 */
public class XboxControllerButtons {

    /*
     * variable declaration
     */
    private XboxController controller;

    public Button a;
    public Button b;
    public Button x;
    public Button y;
    public Button lb;
    public Button rb;
    public Button back;
    public Button start;
    public Button ls;
    public Button rs;

    //D-Pad
    public POVButton dp_u;
    public POVButton dp_r;
    public POVButton dp_l;
    public POVButton dp_d;

    /*
     * constructor
     */
    public XboxControllerButtons(int port) {
        controller = new XboxController(port);
        
        a = new JoystickButton(controller, 1);
        b = new JoystickButton(controller, 2);
        x = new JoystickButton(controller, 3);
        y = new JoystickButton(controller, 4);
        lb = new JoystickButton(controller, 5);
        rb = new JoystickButton(controller, 6);
        back = new JoystickButton(controller, 7);
        start = new JoystickButton(controller, 8);
        ls = new JoystickButton(controller, 9);
        rs = new JoystickButton(controller, 10);
        dp_u = new POVButton(controller, 0);
        dp_r = new POVButton(controller, 90);
        dp_l = new POVButton(controller, 180);
        dp_d = new POVButton(controller, 270);
    }

    public double getLX() {
        return controller.getX(Hand.kLeft);
    }

    public double getLY() {
        return controller.getY(Hand.kLeft);
    }

    public double getRX() {
        return controller.getY(Hand.kLeft);
    }

    public double getRY() {
        return controller.getY(Hand.kLeft);
    }

    public double getLT() {
        return controller.getTriggerAxis(Hand.kLeft);
    }

    public double getRT() {
        return controller.getTriggerAxis(Hand.kRight);
    }
}
