/*
* elevator class
*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends Subsystem {

    /*
    * variables
    */
    private static Talon elevatorMotor;
    private static Encoder encoder;

    /*
    * constructor
    */
    public Elevator(XboxController controller) {
        elevatorMotor = new Talon(RobotMap.ELEVATOR_PORT);
        encoder = new Encoder(RobotMap.ENCODER_INPUT_1, RobotMap.ENCODER_INPUT_2);
    }

    /*
    * interface methods
    */
    public static int encoder() {
        return encoder.get();
    }

    public static double encoderDistance() {
        return encoder.getDistance();
    }

    public static void updateSensors() {
        SmartDashboard.putNumber("Encoder", Elevator.encoderDistance());
    }

    public static void init() {
        elevatorMotor.setInverted(false);
        encoder.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
        encoder.setReverseDirection(false);
    }

    @Override
    protected void initDefaultCommand() {
    }

    /*
    * local methods
    */
    public void start() {
        
    }

}