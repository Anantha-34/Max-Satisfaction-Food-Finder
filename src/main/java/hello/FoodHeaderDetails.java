package hello;

/*
 * Bean to store the first line - that contains time:T and number of dishes
 */
public class FoodHeaderDetails {

	 Integer satCount;
	 static Integer timeount;
	 
	public FoodHeaderDetails() {
	}
	/**
	 * @return the satCount
	 */
	public Integer getSatCount() {
		return satCount;
	}
	/**
	 * @param satCount the satCount to set
	 */
	public void setSatCount(Integer satCount) {
		this.satCount = satCount;
	}
	/**
	 * @return the timeount
	 */
	public static Integer getTimeount() {
		return timeount;
	}
	/**
	 * @param timeount the timeount to set
	 */
	public void setTimeount(Integer timeount) {
		FoodHeaderDetails.timeount = timeount;
	}	
	
}
