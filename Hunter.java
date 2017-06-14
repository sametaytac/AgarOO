package agarrunner;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * Hunter cell
 */
public class Hunter extends CellDecorator {

	
	public Hunter(Cell c) {
            super(c);
	}

	
	/**
         * It overrides draw method and draw green,blue and red circle.
	 * @param g2d 
	 * 
	 */
	public void draw(Graphics2D g2d) {
		  super.draw(g2d);
                 g2d.setPaint(Color.GREEN);
double radius=getMass()/(2*Math.PI);

        g2d.drawOval((int)(getPosition().getX()-radius/4),(int)(getPosition().getY()-radius/4),(int)(radius/2),(int)(radius/2));
                 g2d.setPaint(Color.BLUE);
        g2d.drawOval((int)(getPosition().getX()-radius/2),(int)(getPosition().getY()-radius/2),(int)(radius),(int)(radius)); 
                g2d.setPaint(Color.RED);
        g2d.drawOval((int)(getPosition().getX()-3*radius/4),(int)(getPosition().getY()-3*radius/4),(int)(3*radius/2),(int)(3*radius/2)); 
        

	}

}