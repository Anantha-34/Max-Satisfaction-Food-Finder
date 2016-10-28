package hello;

import java.util.ArrayList;
import java.util.List;

/*
 * For storing the list of food objects from 
 * corresponding setters and getters
 */
public class FoodList {

	static List<Food> arra;
	
	public FoodList()
	{
		arra = new ArrayList<Food> ();
	}
	
	public List<Food> getGoodList()
	{
		return arra;
	}
	
	public void putGoodList(Food food)
	{
		 arra.add(food);
	}
	
}
