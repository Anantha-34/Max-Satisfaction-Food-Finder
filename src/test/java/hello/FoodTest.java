package hello;

import javax.batch.runtime.JobExecution;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class FoodTest {
	@Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	private FlatFileItemReader<Food> reader;	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() throws Exception{
		
		jobLauncherTestUtils.launchJob();
		JobExecution jobExecution = (JobExecution) jobLauncherTestUtils.launchStep("step1");		
//		 assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

	}
	
}
