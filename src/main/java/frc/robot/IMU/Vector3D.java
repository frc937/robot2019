package frc.robot.IMU;

/**
 * Vector3D class
 * Represents a mathematical 3D vector.
 * And has all of the standard operations
 * like scalar multiplication, vector
 * addition, dot products, and cross products.
 */
class Vector3D {
    
    //variables
    protected double x, y, z;


    /**
     * zero vector constructor
     */
    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * copy contructor
     * @param that other vector to copy
     */
    public Vector3D(Vector3D that) {
        this(that.getX(), that.getY(), that.getZ());
    }

    /**
     * specific contructor
     * @param x x length of vector
     * @param y y length of vector
     * @param z z length of vector
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @return the x component of the vector
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y component of the vector
     */
    public double getY() {
        return y;
    }

    /**
     * @return the z component of the vector
     */
    public double getZ() {
        return z;
    }

    /**
     * getMagnitude
     * @return the magnitude of the vector
     */
    public double getMagnitude() {
        
        //square components
        double x2 = Math.pow(x, 2);
        double y2 = Math.pow(y, 2);
        double z2 = Math.pow(z, 2);
        
        return Math.sqrt(x2 + y2 + z2);
    }

    /**
     * Gets the unit vector for this vector.
     * a vector in the same direction with
     * a magnitude of 1.
     * @return the unit vector
     */
    public Vector3D getUnitVector() {
        //scale components
        double magnitude = getMagnitude();
        double x = getX() / magnitude;
        double y = getY() / magnitude;
        double z = getZ() / magnitude;

        return new Vector3D(x, y, z);
    }

    /**
     * Adds together two Vector3Ds
     * @param that the other vector to add
     * @return the added vector
     */
    public Vector3D add(Vector3D that) {
        //add each component
        double x = this.getX() + that.getX();
        double y = this.getY() + that.getY();
        double z = this.getZ() + that.getZ();
        
        return new Vector3D(x, y, z);
    }

    /**
     * Finds the dot product of two Vector3Ds
     * @param that the other vector to dot
     * @return the dot product of the vectors
     */
    public double dot(Vector3D that) {
        //multiply each component
        double x = this.getX() * that.getX();
        double y = this.getY() * that.getY();
        double z = this.getZ() * that.getZ();
        
        return x + y + z;
    }

    /**
     * Finds the cross product of two Vector3Ds
     * basically takes two vectors and finds the
     * direction where neither of them are pointing.
     * <p>
     * Doing this the other way around will result
     * in a vector facing the opposite way.
     * @param that the other vector to cross with
     * @return the cross product of the vectors
     */
    public Vector3D cross(Vector3D that) {
        //find product for each component
        double x = this.getY() * that.getZ() - this.getZ() * that.getY();
        double y = this.getX() * that.getZ() - this.getZ() * that.getX();
        double z = this.getX() * that.getY() - this.getY() * that.getX();

        return new Vector3D(x, y, z);
    }
}
