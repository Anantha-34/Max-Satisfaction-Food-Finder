package hello;

/*
 * Food object - for time taken and satisfaction for each dish
 * corresponding setters and getters
 */

public class Food {
    private Integer amtSatisfaction;
    private Integer timeTaken;

    public Food() {

    }    
    
	public Food(Integer amtSatisfaction, Integer timeTaken) {
		super();
		this.amtSatisfaction = amtSatisfaction;
		this.timeTaken = timeTaken;
	}

	/**
	 * @return the amtSatisfaction
	 */
	public Integer getAmtSatisfaction() {
		return amtSatisfaction;
	}

	/**
	 * @param amtSatisfaction the amtSatisfaction to set
	 */
	public void setAmtSatisfaction(Integer amtSatisfaction) {
		this.amtSatisfaction = amtSatisfaction;
	}

	/**
	 * @return the timeTaken
	 */
	public Integer getTimeTaken() {
		return timeTaken;
	}

	/**
	 * @param timeTaken the timeTaken to set
	 */
	public void setTimeTaken(Integer timeTaken) {
		this.timeTaken = timeTaken;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Food [amtSatisfaction=" + amtSatisfaction + ", timeTaken=" + timeTaken + "]";
	}
	

}
