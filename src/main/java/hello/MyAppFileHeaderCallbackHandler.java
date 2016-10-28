package hello;

import org.springframework.batch.item.file.LineCallbackHandler;

/*
 * Custom skip call back handler that splits header line into multiple spaces.  
 */

public class MyAppFileHeaderCallbackHandler implements LineCallbackHandler{

	FoodHeaderDetails foodheader;
	
	@Override
	public void handleLine(String arg0) {
		// TODO Auto-generated method stub
		
		System.out.println(arg0);
		String[] parts = arg0.split("\\s");

		foodheader = new FoodHeaderDetails();
		foodheader.setTimeount(new Integer(parts[0]));
		foodheader.setSatCount(new Integer(parts[1]));
	}

}
