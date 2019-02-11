/*
* Class to store toggled boolean variables so we can
* have the same button open and close a thing
*/

package frc.robot;

public class RobotState {

    /*
    * Claw
    */
    // grab variables
    public static boolean isOpen;
    // push variables
    public static boolean isPushed;
    // move variables
    public static boolean isExtended;

    /*
    * Elevator
    */
    // set this to the level the elevator is at the end of the command to change level
    public static double elevatorLevel;

}