package com.yandexwords.yandexwords.config;

import com.yandexwords.yandexwords.job.LoadJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(LoadJob.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger(){

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever();

        return TriggerBuilder
                .newTrigger()
                .forJob(jobDetail())
                .withSchedule(simpleScheduleBuilder)
                .withIdentity("jobId")
                .build();
    }


}
