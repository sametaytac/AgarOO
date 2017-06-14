package agarrunner;

import java.util.*;

/**
 * ChaseSmaller strategy 
 */
public class ChaseSmaller extends StepStrategy {

	        private ArrayList<Entity> foods;

	public ChaseSmaller(ArrayList<Entity> food,int temp) {
             super();
	foods=food;
          
        this.setNumberOfTurns(temp);
        setStart(false);
            
	}

	
/**
 * It checks nearest cell whose mass is smaller than current cell and chase it.
 */
    @Override
     public void step(Entity e, double deltaTime) {
     double temp=1000;
     Entity tempe = null;
     for(Entity yemek : foods)
     {      if(yemek instanceof Cell && yemek.getMass()<e.getMass())
            {
                if(temp>e.getPosition().distanceTo(yemek.getPosition()))
                {
                    tempe=yemek;
                    temp=e.getPosition().distanceTo(yemek.getPosition());
          
                }
            }
     }
     
     
     if(tempe!=null){    
     e.getDirection().setX((e.getPosition().getX()-tempe.getPosition().getX())/e.getPosition().distanceTo(tempe.getPosition()));
     e.getDirection().setY((e.getPosition().getY()-tempe.getPosition().getY())/e.getPosition().distanceTo(tempe.getPosition()));

     
        
        e.getPosition().setX(e.getPosition().getX()-e.getDirection().getX()*e.getSpeed()*deltaTime);
     
          
        e.getPosition().setY(e.getPosition().getY()-e.getDirection().getY()*e.getSpeed()*deltaTime);
     }
          
    if(getNumberOfTurns()<=0)
            setStart(true);
        else 
                    setNumberOfTurns(getNumberOfTurns()-1);

 
    }

}