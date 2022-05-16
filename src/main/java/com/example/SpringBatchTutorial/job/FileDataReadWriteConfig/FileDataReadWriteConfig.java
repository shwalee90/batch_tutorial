package com.example.SpringBatchTutorial.job.FileDataReadWriteConfig;

import com.example.SpringBatchTutorial.job.FileDataReadWriteConfig.dto.Player;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class FileDataReadWriteConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Job fileReadWritejob(){
        return jobBuilderFactory.get("helloWorldJob")
                .incrementer(new RunIdIncrementer())
                .start(fileReadWriteStep())
                .build();
    }

    @JobScope
    @Bean
    public Step fileReadWriteStep() {
        return stepBuilderFactory.get("helloWorldStep")
                .<Player, Player>chunk(5)
                .reader()
                .build();
    }


}
