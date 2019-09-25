package frc.robot.IMU;

import com.kauailabs.navx.frc.AHRS;
import frc.robot.IMU.Vector3D;

//if you want to understand the painful math involved in this,
//we are using a 4 dimensional hyper-sphere to keep directions straight.

//https://math.stackexchange.com/questions/40164/how-do-you-rotate-a-vector-by-a-unit-quaternion
//https://en.wikipedia.org/wiki/Quaternion#Hamilton_product

/**
 * Intertial Measurement Unit (IMU)
 * Provides information about where the robot
 * is in space, and does all of the horrible
 * math so you don't have to.
 * <p>
 * You can assume that any value you get from
 * here is not perfectly accurate, but pretty
 * close. All of the units are metric.
 */
class IMU {

    //variables
    private Vector3D displacement, velocity;
    protected AHRS ahrs;

    /**
     * Constructor
     * Put this in robot init
     */
    public IMU() {
        ahrs = new AHRS();
    }

    /**
     * Keeps track of position updates
     * Put this in robot periodic
     */
    public void update() {

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
     * Internal method to get W quaternion component
     * @return W component of rotation quaternion
     */
    protected double getQuaternionW() {
        return ahrs.getQuaternionW();
    }

    /**
     * Internal method to get X quaternion component
     * @return X component of rotation quaternion
     */
    protected double getQuaternionX() {
        return ahrs.getQuaternionX();
    }
    
    /**
     * Internal method to get Y quaternion component
     * @return Y component of rotation quaternion
     */
    protected double getQuaternionY() {
        return ahrs.getQuaternionY();
    }
    
    /**
     * Internal method to get Z quaternion component
     * @return Z component of rotation quaternion
     */
    protected double getQuaternionZ() {
        return ahrs.getQuaternionZ();
    }

}
