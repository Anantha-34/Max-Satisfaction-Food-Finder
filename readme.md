Requirements:
1. Text file format
	first line: header: 
		[t] [Number of items on menu]
	every line:
		[amount of satisfaction from eating dish 1][time taken for dish 1]
		[amount of satisfaction from dish 2][time taken for dish 2]
2. Given t minute, java program Reads the text file and finds out the maximum satisfaction that Gordon can get from eating at the restaurant.

Output:
1. Approach
	Technology: Spring Batch with Spring boot:
		It simplifies batch processing by providing built-in implementations of file readers and writers hence job of reading is taken care by spring batch framework. 
		
		Read the file and store the 1st line and process it independently. Store the t value in Integer object.
		Read the file and store the remaining records in in-memory (Array of objects) as part of batch job.
		once the job is sucessfully completed,
			Loop through array of objects and compare each time taken for dishes against input: t
			if the time taken for dish is less than t 
				include the time taken and dish in new hashmap 
					key: dish name and value: amount of satisfaction
			
			loop through the hashmap and lists out the number of dishes he can have
				Display the maximum number of satisfaction value

3. Maximum satisfaction value
	Result: 99098
