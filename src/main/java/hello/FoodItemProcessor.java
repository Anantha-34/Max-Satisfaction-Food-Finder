package hello;

import org.springframework.batch.item.ItemProcessor;

/*
 * Bean to store the each dish details, does not do any transformation
 * it simply stores them in FoodList as array..
 */
public class FoodItemProcessor implements ItemProcessor<Food, Food> {

    FoodList fod = new FoodList();
    
    @Override
    public Food process(final Food food) throws Exception {
        fod.putGoodList(food);
        return food;
    }

}
