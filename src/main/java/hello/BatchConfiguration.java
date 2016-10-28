package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    List<Food> fd = new ArrayList<Food> ();

    /*
     * File reader of type Food, reads from data.txt
     * First line is set to skip as it contains the time t and total number of items
     */
    @Bean
    public FlatFileItemReader<Food> reader() {
    	FlatFileItemReader<Food> reader = new FlatFileItemReader<Food>();
        reader.setResource(new ClassPathResource("data.txt"));
        reader.setLinesToSkip(1);
      
        LineMapper<Food> foodLineMapper = createFoodLineMapper();        
        reader.setLineMapper(foodLineMapper);
        reader.setSkippedLinesCallback(
        		new MyAppFileHeaderCallbackHandler()); 
     
      return reader;
      
    }

    /*
     * To map each line to Default line mapper of type Food with token delimiter and Field mapper class
     */
    
    private LineMapper<Food> createFoodLineMapper() {
        DefaultLineMapper<Food> foodLineMapper = new DefaultLineMapper<>();
 
        LineTokenizer foodLineTokenizer = createFoodLineTokenizer();
        foodLineMapper.setLineTokenizer(foodLineTokenizer);
 
        FieldSetMapper<Food> foodInformationMapper = createFoodInformationMapper();
        foodLineMapper.setFieldSetMapper(foodInformationMapper);
 
        return foodLineMapper;
    }

    /*
     * To map the fields in the line to Food Object
     */
    
    private FieldSetMapper<Food> createFoodInformationMapper() {
        BeanWrapperFieldSetMapper<Food> foodInformationMapper = new BeanWrapperFieldSetMapper<>();
        foodInformationMapper.setTargetType(Food.class);
        return foodInformationMapper;
    }    

    /*
     * To provide the delimiter and map the object names against fields from file.
     */

    private LineTokenizer createFoodLineTokenizer() {
        DelimitedLineTokenizer foodLineTokenizer = new DelimitedLineTokenizer();
        foodLineTokenizer.setDelimiter(new String(" "));
        foodLineTokenizer.setNames(new String[]{"amtSatisfaction", "timeTaken"});
        return foodLineTokenizer;
    }    

    /*
     * Custom  processor that transforms each record
     */
    
    @Bean
    public FoodItemProcessor processor() {
        return new FoodItemProcessor();
    }

    /*
     * Job definition: the name of the job, a single step and the listener to perform the activities post job completion.
     */
        
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)                
                .flow(step1())
                .end()
                .build();
    }

    /*
     * Step1 definition: providing processor and reader mappings
     */    
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Food, Food> chunk(10)
                .reader(reader())
                .processor(processor())
                .build();
    }
}
