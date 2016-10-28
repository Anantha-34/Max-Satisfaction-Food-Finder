package hello;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

public int getMax(List<Food> list){
    int max = Integer.MIN_VALUE;
    for(int i=0; i<list.size(); i++){
        if(list.get(i).getAmtSatisfaction() > max){
            max = list.get(i).getAmtSatisfaction();
        }
    }
    return max;
}

/*
 * After the job is finished, loop through the ArrayList and compare against the  (non-Javadoc)
 * @see org.springframework.batch.core.listener.JobExecutionListenerSupport#afterJob(org.springframework.batch.core.JobExecution)
 */

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			Integer totTime = new Integer(4345);
			List<Food> SatisFood = new ArrayList<Food> ();
			
			totTime = FoodHeaderDetails.getTimeount();
			
			log.info("!!! Total amount of time: " + FoodHeaderDetails.getTimeount());

			Integer totalcount = new Integer(0);
		
			// loop through the Arraylist and go through the food that can be eaten with in total time
			
			for (Food food: FoodList.arra) {
			    totalcount += food.getTimeTaken();
		        if (totTime>totalcount)
		        {
					//log.info("food <" + food + "> in the Arraylist.");
		        	SatisFood.add(food);       
		        }
			    
			}
			
			//find the max
			System.out.println("maximum satisfaction:" + getMax(SatisFood));

		}
	}
}

