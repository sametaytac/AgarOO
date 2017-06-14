package agarrunner;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;

/**
 * Superclass of cells
 */
public abstract class Cell extends Entity {

	private String name;

	private int foodEaten;

	private int cellsSwallowed;
        
        
	public Cell(Color renk,double mass1,double hiz1,double x12,double y12,String isim) {
        super(renk,mass1,hiz1,x12,y12);
                 name=new String(isim);
                 foodEaten=0;
                 cellsSwallowed=0;
        }
	
/**
 * It draws every cell without circles that show cell is hunter,roamer ect.
 */	

         @Override
    public void draw(Graphics2D g2d) {
          Font font = new Font(Font.SANS_SERIF,Font.BOLD, 10);
               g2d.setFont(font);
         g2d.setPaint(this.getColor());
        double radius=getMass()/(2*Math.PI);
        g2d.fillOval((int)(getPosition().getX()-radius),(int)(getPosition().getY()-radius),(int)(2*radius),(int)(2*radius)); 
         g2d.setPaint(this.getColor().darker().darker().darker().darker());
                 g2d.drawOval((int)(getPosition().getX()-radius),(int)(getPosition().getY()-radius),(int)(2*radius),(int)(2*radius)); 
                 g2d.drawString(this.getName(),(int)(getPosition().getX()-10), (int)(getPosition().getY()-10) ) ;
                 g2d.drawString(this.getFoodEaten() + "-" + this.getCellsSwallowed(),(int)(getPosition().getX()-5), (int)(getPosition().getY()) ) ;
                 String str=null;
                if(getStrategy() instanceof AvoidLarger)
                    str="AL";
                else if(getStrategy() instanceof StandStill)
                    str="SS";
                else if(getStrategy() instanceof GrabFood)
                    str="GF";
                else if(getStrategy() instanceof ChaseSmaller)
                    str="CS";
                else if(getStrategy() instanceof LoseMass)
                    str="LM";
                else if(getStrategy() instanceof MoveRandom)
                    str="MR";
                else if(getStrategy() instanceof MoveLinear)
                    str="ML";
                g2d.drawString(str + "",(int)(getPosition().getX()-5), (int)(getPosition().getY()+10) ) ;

                 g2d.drawString(this.getStrategy().getNumberOfTurns() + "",(int)(getPosition().getX()-5), (int)(getPosition().getY()+20) ) ;


                 g2d.drawLine((int)getPosition().getX(),(int) getPosition().getY(), (int)(-getDirection().getX()*radius+getPosition().getX()), (int)(-getDirection().getY()*radius+getPosition().getY()));

         

    }

    
    
    public void addMass(double additionalMass) {
            setMass(additionalMass+getMass());
}
    public void removeMass(double reductionalMass) {
		            setMass(-reductionalMass+getMass());

	}

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the foodEaten
     */
    public int getFoodEaten() {
        return foodEaten;
    }

    /**
     * @param foodEaten the foodEaten to set
     */
    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    /**
     * @return the cellsSwallowed
     */
    public int getCellsSwallowed() {
        return cellsSwallowed;
    }

    /**
     * @param cellsSwallowed the cellsSwallowed to set
     */
    public void setCellsSwallowed(int cellsSwallowed) {
        this.cellsSwallowed = cellsSwallowed;
    }
	
  

}