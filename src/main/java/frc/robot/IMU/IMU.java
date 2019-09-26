package frc.robot.IMU;

import com.kauailabs.navx.frc.AHRS;
import frc.robot.IMU.Vector3D;

//if you want to understand the painful math involved in this,
//we are using a 4 dimensional hyper-sphere to keep directions straight.

//https://math.stackexchange.com/questions/40164/how-do-you-rotate-a-vector-by-a-unit-quaternion
//https://en.wikipedia.org/wiki/Quaternion#Hamilton_product
//https://math.stackexchange.com/questions/1375754/clarification-of-definition-of-inverse-with-quaternions

/**
 * Intertial Measurement Unit (IMU)
 * Provides information about where the robot
 * is in space, and does all of the horrible
 * math so you don't have to.
 * <p>
 * You can assume that any value you get from
 * here is not very accurate, but acceptably
 * close.
 */
public class IMU {

    //variables
    protected AHRS ahrs;

    /**
     * Constructor
     */
    public IMU() {
        ahrs = new AHRS();
        ahrs.resetDisplacement();
        ahrs.enableBoardlevelYawReset(true);
        ahrs.zeroYaw();
    }

    /**
     * @return World-centric vector of robot acceleration
     */
    public Vector3D getAcceleration() {
        //get components
        double x = ahrs.getWorldLinearAccelX();
        double y = ahrs.getWorldLinearAccelY();
        double z = ahrs.getWorldLinearAccelZ();

        return new Vector3D(x, y, z);
    }

    /**
     * @return World-centric vector of robot velocity
     */
    public Vector3D getVelocity() {
        //get components
        double x = ahrs.getVelocityX();
        double y = ahrs.getVelocityY();
        double z = ahrs.getVelocityZ();

        return new Vector3D(x, y, z);
    }

    /**
     * @return World-centric vector of robot displacement
     */
    public Vector3D getDisplacement() {
        //get components
        double x = ahrs.getDisplacementX();
        double y = ahrs.getDisplacementY();
        double z = ahrs.getDisplacementZ();

        return new Vector3D(x, y, z);
    }

    /**
     * @return Returns the current yaw value (in degrees, from -180 to 180)
     */
    public double getYaw() {
        return ahrs.getYaw();
    }

    /**
     * @return Returns the current pitch value (in degrees, from -180 to 180)
     */
    public double getPitch() {
        return ahrs.getPitch();
    }

    /**
     * @return Returns the current roll value (in degrees, from -180 to 180)
     */
    public double getRoll() {
        return ahrs.getRoll();
    }

    /**
     * Does a Hamilton product on two arrays
     * @param a The first operand. Must be an array
     *          containing {W, X, Y, Z} components
     *          in that order.
     * @param b The second operand. Must be an array
     *          containing {W, X, Y, Z} components
     *          in that order.
     * @return
     */
    protected double[] hamiltonProduct(double[] a, double[] b) {
        //check for bad input
        if (a == null || b == null)
            throw new NullPointerException();

        if (a.length != 4 || b.length != 4)
            throw new IllegalArgumentException("Must have 4 components");
        
        //if input is good

        //do hamilton products on components
        double w = a[0]*b[0] - a[1]*b[1] - a[2]*b[2] - a[3]*b[3];
        double x = a[0]*b[1] + a[1]*b[0] + a[2]*b[3] - a[3]*b[2];
        double y = a[0]*b[2] - a[1]*b[3] + a[2]*b[0] + a[3]*b[1];
        double z = a[0]*b[3] + a[1]*b[2] - a[2]*b[1] + a[3]*b[1];
        
        return new double[] {w, x, y, z};
    }

    /**
     * Turns a vector in the context of the robot into
     * a vector in the context of the world
     * @param vector 3D local vector to transform
     * @return 3D world vector corrected for robot rotation
     */
    public Vector3D l2wTransform(Vector3D vector) {
        
        //grab vector components
        double[] p = new double[] {
            0,
            vector.getX(),
            vector.getY(),
            vector.getZ()
        };

        //grab quaternion components
        double w = ahrs.getQuaternionW();
        double x = ahrs.getQuaternionX();
        double y = ahrs.getQuaternionY();
        double z = ahrs.getQuaternionZ();
        
        double[] r = new double[] {w, x, y, z};
        double[] R = new double[] {w, -x, -y, -z};
        
        //take hamilton products
        p = hamiltonProduct(r, p);
        p = hamiltonProduct(p, R);

        Vector3D v = new Vector3D(p[1], p[2], p[3]);
        return v;
    }

    /**
     * Turns a vector in the context of the world into
     * a vector in the context of the robot
     * @param vector 3D world vector to transform
     * @return 3D local vector corrected for robot rotation
     */
    public Vector3D w2lTransform(Vector3D vector) {
        
        //grab vector components
        double[] p = new double[] {
            0,
            vector.getX(),
            vector.getY(),
            vector.getZ()
        };

        //grab quaternion components
        double w = ahrs.getQuaternionW();
        double x = ahrs.getQuaternionX();
        double y = ahrs.getQuaternionY();
        double z = ahrs.getQuaternionZ();

        //get quaternion magnitude
        double w2 = Math.pow(w, 2);
        double x2 = Math.pow(x, 2);
        double y2 = Math.pow(y, 2);
        double z2 = Math.pow(z, 2);
        double mag = Math.sqrt(w2 + x2 + y2 + z2);

        //invert quaternion components
        w /= mag;
        x /= mag;
        y /= mag;
        z /= mag;
        
        double[] r = new double[] {w, x, y, z};
        double[] R = new double[] {w, -x, -y, -z};
        
        //take hamilton products
        p = hamiltonProduct(r, p);
        p = hamiltonProduct(p, R);

        Vector3D v = new Vector3D(p[1], p[2], p[3]);
        return v;
    }

    /**
     * Turns a vector of sensor data into a displacement
     * vector that can be put on a map.
     * <p>
     * Takes in something like distance straight ahead of
     * 3 meters, and turns it into a point in the world.
     * @param vector data to transform
     * @return displacement vector in the world
     */
    public Vector3D sensorVectorToWorldPoint(Vector3D vector) {
        //rotate vector
        vector = l2wTransform(vector);

        //translate vector
        vector.add(getDisplacement());

        return vector;
    }

}
