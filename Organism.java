package agarrunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * Organism class.
 */
public class Organism extends Food {

		private double radius;

	public Organism(Color c,double mass1,double hiz1,double x12,double y12,double r) {
            
        super(c,mass1,hiz1,x12,y12);
            
           
            radius=r;
	}

	/**
	 *It draws organism here. 
	 */

        
        @Override
        public void draw(Graphics2D g2d) {
           g2d.setPaint(this.getColor());

        g2d.fillOval((int)(getPosition().getX()-radius),(int)(getPosition().getY()-radius),(int)(2*radius),(int)(2*radius));     
        }
        
        
}