//package com.example.batch.batchV;
//
//import com.example.batch.test.Member;
//import com.example.batch.test.job.MemberRepository;
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
//import org.springframework.batch.item.database.JpaItemWriter;
//import org.springframework.batch.item.database.JpaPagingItemReader;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import java.util.Date;
//
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
//                .processor(itemProcessor1())
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
//    ItemProcessor<Member, MemberMonthlyWork> itemProcessor1() {
//        return member -> {
//            // 회원의 작업 시간을 계산하는 비즈니스 로직을 수행합니다.
//            //businessService; ed-sd
//            //vacationService; ed-sd
//            //workOutsideService; ed-sd
//
//            // MemberMonthlyWork 객체를 생성하여 값 설정 후 반환합니다.
//            return MemberMonthlyWork.builder()
//                    .yearMonth(yearMonth)
//                    .memberId(member.getId()) //회원의 ID를 가져와 설정
//                    .hour(totalWorkHours) // 계산된 총 작업 시간 설정
//                    .creationDate(new Date()) // 생성일 설정
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
