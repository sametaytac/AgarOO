package agarrunner;
import java.awt.Color;
import java.util.*;

/**
 * Base class of foods.
 */
public abstract class Food extends Entity {

	/**
	 * Default constructor
	 */
	public Food(Color col,double mass1,double hiz1,double x12,double y12) {
          super(col,mass1,hiz1,x12,y12);  
	}

}