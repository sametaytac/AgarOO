package agarrunner;

import java.util.*;

/**
 * 
 */
public abstract class FoodFactory {

	/**
	 * Default constructor
	 */
	public FoodFactory() {
	}

	/**
	 * @param env 
	 * @return
	 */
	public abstract Food createFood(Environment env) ;
	
	

}