//package com.example.batch.batchV;
//
//import jakarta.persistence.EntityManagerFactory;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
//import org.springframework.batch.item.database.JpaItemWriter;
//import org.springframework.batch.item.database.JpaPagingItemReader;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.Sort;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Collections;
//import java.util.Date;
//
//@Configuration
//@RequiredArgsConstructor
//@Slf4j
//public class MemberJobConfig {
//    private final ApplicationContext applicationContext;
//
//    @Qualifier("entityManagerFactory")
//    private final EntityManagerFactory entityManagerFactory;
//
//    private final MemberRepository memberRepository;
//
//    private final BusinessService businessService;
//    private final VacationService vacationService;
//    private final WorkOutsideService workOutsideService;
//
//    @Value("${batch.chunk-size:3}")
//    private int chunkSize;
//
//    @Bean("memberWorkJob")
//    Job memberWorkJob(JobRepository jobRepository, Step memberWorkStep) {
//        return new JobBuilder("memberWorkJob", jobRepository)
//                .start(memberWorkStep)
//                .build();
//    }
//
////## 1번 ##
//    @Bean
//    @JobScope
//    Step memberWorkStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) throws Exception {
//        return new StepBuilder("memberWorkStep", jobRepository)
//                .<Member, MemberMonthlyWork>chunk(chunkSize,transactionManager)
//                .reader(itemReader(entityManagerFactory))
//                .processor(itemProcessor())
//                .writer(itemWriter(entityManagerFactory))
//                .build();
//    }
//
////## 2번 ##
//    @Bean
//    @StepScope
//    JpaPagingItemReader<Member> itemReader(EntityManagerFactory entityManagerFactory) {
//        //JpaRepository를 ListItemReader, QueueItemReader에 사용하면 안된다.
//        //paging과 cursor 구현이 없어 대규모 데이터 처리가 불가하다.
//        JpaPagingItemReader<Member> itemReader = new JpaPagingItemReader<>();
//        itemReader.setEntityManagerFactory(entityManagerFactory);
//        itemReader.setQueryString("SELECT m FROM Member m");
//        itemReader.setPageSize(chunkSize);
//        return itemReader;
//    }
//
////## 3번 ##
//    @Bean
//    @StepScope
//    ItemProcessor<Member, MemberMonthlyWork> itemProcessor() {
//        return Member -> {
//            LocalDate now = LocalDate.now();
//            LocalDate startDate = now.withDayOfMonth(1);
//            LocalDate endDate = now.withDayOfMonth(now.lengthOfMonth());
//
//            Integer workHours = businessService.getWorkHour(member.getId(), startDate, endDate);
//            Integer vacationHours = vacationService.getWorkHour(member.getId(), startDate, endDate);
//            Integer outsideWorkHours = workOutsideService.getHour(member.getId(), startDate, endDate);
//
//            return MemberMonthlyWork.builder()
//                    .memberId(member.getId())
//                    .yearMonth(now.format(DateTimeFormatter.ofPattern("yyyyMM")))
//                    .hour(workHours + vacationHours + outsideWorkHours)
//                    .creationDate(new Date())
//                    .build();
//        };
//    }
//
////## 4번 ##
//    @Bean
//    @StepScope
//    JpaItemWriter<MemberMonthlyWork> itemWriter(EntityManagerFactory entityManagerFactory) throws Exception {
//        JpaItemWriter<MemberMonthlyWork> writer = new JpaItemWriter<>();
//        writer.setEntityManagerFactory(entityManagerFactory);
//        writer.afterPropertiesSet();
//        return writer;
//    }
//
//}
