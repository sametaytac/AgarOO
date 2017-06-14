package agarrunner;
import java.util.*;

/**
 * Avoidlarger strategy
 */
public class AvoidLarger extends StepStrategy {

		        private ArrayList<Entity> hunters;

	public AvoidLarger(ArrayList<Entity> h,int temp) {
            
            super();
	hunters=h;
        this.setNumberOfTurns(temp);
        setStart(false);
	}

/**
 * For every cell,it checks the nearest hunter and it runs away from it.
 */
    @Override
    public void step(Entity e, double deltaTime) {
    
    
    double temp=1000;
     Entity tempe = null;
     for(Entity avci : hunters)
     {      if(avci instanceof Cell && avci.getMass()>e.getMass())
            {
                if(temp>e.getPosition().distanceTo(avci.getPosition()))
                {
                    tempe=avci;
                    temp=e.getPosition().distanceTo(avci.getPosition());
          
                }
            }
     }
     
     
     if(tempe!=null){    
     e.getDirection().setX((e.getPosition().getX()-tempe.getPosition().getX())/e.getPosition().distanceTo(tempe.getPosition()));
     e.getDirection().setY((e.getPosition().getY()-tempe.getPosition().getY())/e.getPosition().distanceTo(tempe.getPosition()));

     
      if(e.getPosition().getX()-e.getDirection().getX()*e.getSpeed()*deltaTime<800 && e.getPosition().getX()-e.getDirection().getX()*e.getSpeed()*deltaTime>250)

        e.getPosition().setX(e.getPosition().getX()+e.getDirection().getX()*e.getSpeed()*deltaTime);
     
      if(e.getPosition().getY()-e.getDirection().getY()*e.getSpeed()*deltaTime<680 && e.getPosition().getY()-e.getDirection().getY()*e.getSpeed()*deltaTime>0)
    
        e.getPosition().setY(e.getPosition().getY()+e.getDirection().getY()*e.getSpeed()*deltaTime);
     }
          
  if(getNumberOfTurns()<=0)
            setStart(true);
        else 
            setNumberOfTurns(getNumberOfTurns()-1);
 
    }

    
    
    }

