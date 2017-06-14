package agarrunner;
import java.awt.Color;
import java.util.*;

/**
 * SugarFactory class.It creates sugars.
 */
public class SugarFactory extends FoodFactory {


	public SugarFactory() {
	}
/**
 * Creation is made in here.
 */
        @Override
        public Food createFood(Environment env) {
                 Random rand = new Random();
                 int kenar=rand.nextInt(5) + 8;
                 double x=rand.nextInt(env.getWindowWidth()-250) + 250;
                 double y=rand.nextInt(env.getWindowHeight());
                 
                 
                     float r = rand.nextFloat();
                 float g = rand.nextFloat();
                 float b = rand.nextFloat();
                 Color randomColor = new Color(r, g, b);
                 Sugar temp=new Sugar(randomColor,kenar,0,x,y,kenar);
                return temp;
            }
        
        
}