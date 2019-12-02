/*
* elevator class
*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends Subsystem {

    /*
    * variables
    */
    private static Talon elevatorMotor1;
    private static Talon elevatorMotor2;
    private static Encoder encoder;

    /*
    * constructor
    */
    public Elevator() {
        elevatorMotor1 = new Talon(RobotMap.ELEVATOR1_PORT);
        elevatorMotor2 = new Talon(RobotMap.ELEVATOR2_PORT);
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
        elevatorMotor1.setInverted(false);
        elevatorMotor2.setInverted(false);
        encoder.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
        encoder.setReverseDirection(false);
    }

    @Override
    protected void initDefaultCommand() {
    }

    /*
    * local methods
    */
    public static void down() {
        elevatorMotor1.setSpeed(0.45);
        elevatorMotor2.setSpeed(0.45);
    }

    public static void up() {
        elevatorMotor1.setSpeed(-0.45);
        elevatorMotor2.setSpeed(-0.45);
    }

    public static void stop() {
        elevatorMotor1.setSpeed(0.0);
        elevatorMotor2.setSpeed(0.0);
    }

}