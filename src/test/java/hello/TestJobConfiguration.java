package hello;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestJobConfiguration {
  
	    @Bean
	    public MapJobRegistry mapJobRegistry() {
	        return new MapJobRegistry();
	    }
	    
    
/*	    @Bean
	    public SimpleJobLauncher simpleJobLauncher() {
	        SimpleJobLauncher jl = new SimpleJobLauncher();
	        jl.setJobRepository(jobRepository);
	        return jl;
	    }	    
*/	    
	@Bean JobLauncherTestUtils newJobLauncherTestUtils()
	{
		//return new JobLauncherTestUtils();
		
	       return new JobLauncherTestUtils() {
	            @Override
	            @Autowired
	            public void setJob(@Qualifier("ncsvImportJob") Job job) {
	                super.setJob(job);
	            }
	        };
	}
	
	@Bean FlatFileItemReader<Food> newFlatFileReader()
	{
		return new FlatFileItemReader<Food>();
	}	
/*	
	<bean id="jobRegistry"
		    class="org.springframework.batch.core.configuration.support.MapJobRegistry" />
		<bean>
		
    @Bean
    public MapJobRegistry mapJobRegistry() {
        return new MapJobRegistry();
    }


    @Bean
    public MapJobRegistry mapJobRegistry() {
        return new MapJobRegistry();
    }

    @Bean
    public MapJobRepositoryFactoryBean  mapJobRegistry1() {
        return new MapJobRepositoryFactoryBean();
    }
    
    
    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor() {
        JobRegistryBeanPostProcessor pp = new JobRegistryBeanPostProcessor();
        pp.setJobRegistry(mapJobRegistry());
        return pp;
    }    

    @Bean
    public JobRepositoryFactoryBean jobRepositoryBeanPostProcessor() {
        JobRegistryBeanPostProcessor pp = new JobRegistryBeanPostProcessor();
        pp.setJobRegistry(mapJobRegistry1());
        return pp;
    }    
    
    @Bean
    public SimpleJobLauncher simpleJobLauncher() {
        SimpleJobLauncher jl = new SimpleJobLauncher();
        jl.setJobRepository(mapJobRegistry());
        return jl;
    }
    
    @Bean
    public JobRepositoryFactoryBean jobRepositoryFactoryBean() {
        JobRepositoryFactoryBean fb = new JobRepositoryFactoryBean();
        return fb;
    }    
    // if additional beans required, they go here...
     * 
     */
	
}
