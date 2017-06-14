package agarrunner;
import java.awt.Color;
import java.util.*;

/**
 * OrganismFactory class.It creates organisms.
 */
public class OrganismFactory extends FoodFactory {

	
	public OrganismFactory() {
	}
        /**
	 * Creation is happening here.
	 */
        @Override
        public Food createFood(Environment env) {
                 Random rand = new Random();
                 double radius=rand.nextInt(3) + 5;
                 double x=rand.nextInt(env.getWindowWidth()-250) + 250;
                 double y=rand.nextInt(env.getWindowHeight());
                     float r = rand.nextFloat();
                 float g = rand.nextFloat();
                 float b = rand.nextFloat();
                 Color randomColor = new Color(r, g, b);
                 double hiz= 100/radius;
                 Organism temp=new Organism(randomColor,radius,hiz,x,y,radius);
                return temp;
            }
        

}