package agarrunner;

import java.util.*;

/**
 * Standstill strategy.
 */
public class StandStill extends StepStrategy {

	/**
	 * Default constructor
	 */
         
    
	public StandStill(int temp) {
	super();
        this.setNumberOfTurns(temp);
        setStart(false);
        }

        @Override
	public void step(Entity e, double deltaTime) {
        if(getNumberOfTurns()<=0)
            setStart(true);
        else 
        {  if(deltaTime>1)
            setNumberOfTurns(getNumberOfTurns()-(int) deltaTime);
            else
            setNumberOfTurns(getNumberOfTurns()-1);

            
        }
        }
	
        
        
       
}