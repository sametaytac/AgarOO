package agarrunner;
import java.util.*;

/**
 * losemass strategy.It create one random percentage and cell lose its mass with that percentage.
 */
public class LoseMass extends StepStrategy {

		private double losePercentage;

	public LoseMass(int turn) {
            super();
        this.setNumberOfTurns(turn);
        setStart(false);
            Random rand = new Random();
                 losePercentage=(double)rand.nextFloat()*5;
	}

	/**
	 * Step executed here.
	 */

	
	
        

    @Override
    public void step(Entity e, double deltaTime) {
        
          if(getNumberOfTurns()<=0)
            setStart(true);
        else 
             {
            setNumberOfTurns(getNumberOfTurns()-1);
                 if(e.getMass()>50)
                 {  Cell a=(Cell) e;
                     a.removeMass(deltaTime*losePercentage*e.getMass()/500);
                 }
                 
             }
    }

}