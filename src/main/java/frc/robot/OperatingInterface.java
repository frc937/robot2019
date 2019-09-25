/*
* Code for buttons and what they do
*/

package frc.robot;

import frc.robot.XboxControllerButtons;
import frc.robot.commands.manipulation.claw.*;
import frc.robot.commands.manipulation.elevator.*;

public class OperatingInterface {

    /*
    * variables
    */
    private XboxControllerButtons controller;

    /*
    * constructor
    */
    public OperatingInterface() {
        
        controller = new XboxControllerButtons(RobotMap.CONTROLLER_NUMBER);

        //claw controls
        controller.lb.whenPressed(new ClawOpen());
        controller.rb.whenPressed(new ClawClose());
        controller.dp_l.whenPressed(new ClawUp());
        controller.dp_r.whenPressed(new ClawDown());

        //push controls
        controller.a.whenPressed(new PushOut());
        controller.b.whenPressed(new PushIn());

        //elevator controls
        controller.dp_u.whileHeld(new Lift());
        controller.dp_d.whileHeld(new Lower());

    }

    /*
    * methods
    */

    //triggers
    public double getLeftTrigger() {
        return controller.getLT();
    }

    public double getRightTrigger() {
        return controller.getRT();
    }

    
    // Joysticks
    public double getLeftXAxis() {
        return controller.getLX();
    }

    public double getScaledLeftXAxis() {
        return scaleAxis(getLeftXAxis());
    }
    
    public double getLeftYAxis() {
        return controller.getLY();
    }

    public double getScaledLeftYAxis() {
       return scaleAxis(getLeftYAxis());
    }


    public double getRightXAxis() {
        return controller.getRX();
    }

    public double getScaledRightXAxis() {
        return scaleAxis(getRightXAxis());
    }


    public double getRightYAxis() {
        return controller.getRY();
    }

    public double getScaledRightYAxis() {
        return scaleAxis(getRightYAxis());
    }

    private double scaleAxis(double a) {
        return Math.signum(a) * Math.pow(a, 4);
    }

}
