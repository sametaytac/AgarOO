package agarrunner;

import java.util.*;

/**
 * Moverandom strategy.
 */
public class MoveRandom extends StepStrategy {

	/**
	 * Default constructor
	 */
	public MoveRandom(int temp) {
       super();
        this.setNumberOfTurns(temp);
        setStart(false);
	}

	/**
 * Strategy executed here.
 */	
	  @Override
	public void step(Entity e, double deltaTime) {
            
              if(getNumberOfTurns()<=0)
            setStart(true);
        else 
             {
            
            setNumberOfTurns(getNumberOfTurns()-1);
            Random rand = new Random();
                 int tempx=rand.nextInt(40)-20;
                     tempx+=e.getPosition().getX();
                 int tempy=rand.nextInt(40)-20;
                 tempy+=e.getPosition().getY();
                 Vector vec=new Vector(tempx,tempy);
                  e.getDirection().setX((e.getPosition().getX()-vec.getX())/e.getPosition().distanceTo(vec));
                    e.getDirection().setY((e.getPosition().getY()-vec.getY())/e.getPosition().distanceTo(vec));
                    
            if(e.getPosition().getX()-e.getDirection().getX()*e.getSpeed()*deltaTime<800 && e.getPosition().getX()-e.getDirection().getX()*e.getSpeed()*deltaTime>250)
                        e.getPosition().setX(e.getPosition().getX()-e.getDirection().getX()*e.getSpeed()*deltaTime);

            if(e.getPosition().getY()-e.getDirection().getY()*e.getSpeed()*deltaTime<680 && e.getPosition().getY()-e.getDirection().getY()*e.getSpeed()*deltaTime>0)
                        e.getPosition().setY(e.getPosition().getY()-e.getDirection().getY()*e.getSpeed()*deltaTime);
             }
        
            
            
        }
        
       

        
        

}