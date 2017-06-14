package agarrunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * Base class of every elements.
 */
public abstract class Entity {
     
	/**
	 *
	 */
	public Entity(Color color,double mass,double speed,double x,double y) {
	
            this.color=color;
            this.mass=mass;
            position=new Vector(x,y);
            this.speed=speed;
            direction=new Vector(0,0);
        }

	/**
	 * Attribute of elements
	 */
	private Color color;
	private double mass;
	private double speed;
        private Vector position;
        private StepStrategy strategy;
        private Vector direction;

        
        public void step(double deltaTime) {
                getStrategy().step(this, deltaTime);
		
	}

public abstract void draw(Graphics2D g2d);

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the position
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Vector position) {
        this.position = position;
    }

    /**
     * @return the strategy
     */
    public StepStrategy getStrategy() {
        return strategy;
    }

    /**
     * @param strategy the strategy to set
     */
    public void setStrategy(StepStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * @return the direction
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Vector direction) {
        this.direction = direction;
    }




	

}