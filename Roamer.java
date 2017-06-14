package agarrunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 * Roamer class
 */
public class Roamer extends CellDecorator {

    public Roamer(Cell c) {
                super(c);

    }

    /**
     *It overrides draw method and draw green circle.
     * @param g2d
     */
    @Override
	public void draw(Graphics2D g2d) {
		// TODO implement here
                super.draw(g2d);
                 g2d.setPaint(Color.GREEN);
                 double radius=getMass()/(2*Math.PI);

        g2d.drawOval((int)(getPosition().getX()-radius/4),(int)(getPosition().getY()-radius/4),(int)(radius/2),(int)(radius/2)); 

        }

}