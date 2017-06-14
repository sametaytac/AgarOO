
package agarrunner;

import java.awt.Color;
import java.awt.Graphics2D;
	/**
 *Evader class
 */

public class Evader extends CellDecorator {

    public Evader(Cell c) {
                super(c);

    }
    	/**
 *Overrides draw method and draw green and blue circle.
 */
    @Override
	public void draw(Graphics2D g2d) {
		// TODO implement here
                super.draw(g2d);
                 g2d.setPaint(Color.GREEN);
double radius=getMass()/(2*Math.PI);

        g2d.drawOval((int)(getPosition().getX()-radius/4),(int)(getPosition().getY()-radius/4),(int)(radius/2),(int)(radius/2));
                 g2d.setPaint(Color.BLUE);
        g2d.drawOval((int)(getPosition().getX()-radius/2),(int)(getPosition().getY()-radius/2),(int)(radius),(int)(radius)); 

        }
}
