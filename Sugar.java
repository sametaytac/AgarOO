package agarrunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.*;

/**
 * Sugar class
 */
public class Sugar extends Food {

	
	private int sideHalfLength;
    public Sugar(Color c,double mass1, double hiz1, double x12, double y12,int side) {
        super(c, mass1, hiz1, x12, y12);
        sideHalfLength=side;
    }
    /**
 * It overrides draw and draw rectangles.
 */
     @Override
        public void draw(Graphics2D g2d) {
           g2d.setPaint(this.getColor());
         
           g2d.drawRect((int)(getPosition().getX()-sideHalfLength/2),(int)(getPosition().getY()-sideHalfLength/2),sideHalfLength,sideHalfLength);  // the actual location of the sprite
  
           
           
  /*         AffineTransform backup = g2d.getTransform();
AffineTransform trans = new AffineTransform();
Random rand = new Random();
int kenar=rand.nextInt(45);
trans.rotate(kenar, position.x, position.y ); // the points to rotate around (the center in my example, your left side for your problem)
 
g2d.transform( trans );
g2d.drawRect((int)(position.x-sideHalfLength),(int)(position.y-sideHalfLength),2*sideHalfLength,2*sideHalfLength);  // the actual location of the sprite

g2d.setTransform( backup ); // restore previous transform
*/
        }

}