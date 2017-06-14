package agarrunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

/**
 *It makes roamer,hunter ect different from basiccell. 
 */
public abstract class CellDecorator extends Cell {

private Cell decoratedCell;

    public CellDecorator(Cell c) {
        super(c.getColor(),c.getMass(),c.getSpeed(),c.getPosition().getX(),c.getPosition().getY(),c.getName());
        decoratedCell=c;
        setCellsSwallowed(c.getCellsSwallowed());
        setFoodEaten(c.getFoodEaten());
    }



    @Override
    public void draw(Graphics2D g2d) {
        super.draw(g2d);
    }


}