package com.example.batch.test.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
public class SimpleJobConfig {

    // Job을 정의하는 메서드
    @Bean
    public Job simpleJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("simpleJob", jobRepository)
                .start(simpleStepOne(null,jobRepository, transactionManager))  // 첫 번째 Step으로 simpleStepOne을 설정
                .next(simpleStepTwo(jobRepository, transactionManager))  // simpleStepTwo로 이동
                .build();
    }

    // StepOne을 정의하는 메서드
    @Bean
    @JobScope
    public Step simpleStepOne(@Value("#{jobParameters[reqDt]}") String requestDate, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("simpleStepOne", jobRepository)
                .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
                    log.info(">>>>> This is simpleStepOne {}",requestDate);  // 로그 출력

                    return RepeatStatus.FINISHED;  // Step이 성공적으로 완료되었음을 반환
                }, transactionManager)
                .build();
    }

    // StepTwo를 정의하는 메서드
    @Bean
    public Step simpleStepTwo(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("simpleStepTwo", jobRepository)
                .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
                    log.info(">>>>> simpleStepTwo");  // 로그 출력

                    return RepeatStatus.FINISHED;  // Step이 성공적으로 완료되었음을 반환
                }, transactionManager)
                .build();
    }
}
