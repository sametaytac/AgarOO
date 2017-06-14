package agarrunner;

import java.util.*;

/**
 * Baseclass of strategies.
 */
public abstract class StepStrategy {

	/**
	 * Default constructor
	 */
	public StepStrategy() {
	start=true;
        }

	/**
	 * 
	 */
	private int numberOfTurns;
        private boolean start;

	/**
	 * @return
	 */
	public boolean isFinished(){
        return start;
        
        
        }
		
	



	/**
	 * @param e 
	 * @param deltaTime 
	 * 
	 */
	public abstract void step(Entity e, double deltaTime);

    /**
     * @return the numberOfTurns
     */
    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    /**
     * @param numberOfTurns the numberOfTurns to set
     */
    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    /**
     * @param start the start to set
     */
    public void setStart(boolean start) {
        this.start = start;
    }
            
            
        
        
        

	
	

}