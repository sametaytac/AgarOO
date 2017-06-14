package agarrunner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.*;

/**
 * Vector class.It keeps all entities position and direction.
 */
public class Vector {

	
	private double x;

	private double y;

	/**
	 * @param x 
	 * @param y
	 */
	public Vector(double x, double y) {
            this.x=x;
            this.y=y;
        }
/**
 * Calculate distance to another vector.
 */
        public double distanceTo(Vector other) {
		
		return sqrt(pow((this.getX()-other.getX()),2) + pow((this.getY()-other.getY()),2));
	}
        /**
 * Normalize vector.
 */
        public void normalize() {
		setX(getX() / sqrt(getX() * getX() + getY() * getY()));
                setY(getY() / sqrt(getX() * getX() + getY() * getY()));

	}

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
        
	/**
	 * @return
	 *//*
	

	/**
	 * @param other 
	 * @return
	 *//*
	public double distanceTo(Vector other) {
		// TODO implement here
		return 0.0d;
	}*/

}