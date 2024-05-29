package com.example.batch.test.job;

import com.example.batch.test.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CompositeJobConfig {
    private final DataSource dataSource;

    private static final int chunkSize = 10;

    // Job 빈을 생성하는 메서드
    @Bean
    public Job compositeJob(JobRepository jobRepository, PlatformTransactionManager transactionManager, Step compositeStep) {
        return new JobBuilder("compositeJob", jobRepository)
                .start(compositeStep) // 지정된 Step으로 시작
                .build();
    }

    // Job의 Step을 생성하는 메서드
    @Bean
    @JobScope
    public Step compositeStep(@Value("#{jobParameters[reqDt]}") String requestDate, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("compositeStep", jobRepository)
                .<MemberDto, MemberDto>chunk(chunkSize, transactionManager) // 청크 단위 설정
                .reader(compositeItemReader()) // ItemReader 설정
                .writer(compositeWriter()) // ItemWriter 설정
                .build();
    }

    // JDBC를 사용하여 데이터를 읽는 ItemReader 빈 생성
    @Bean
    @StepScope
    public JdbcCursorItemReader<MemberDto> compositeItemReader() {
        return new JdbcCursorItemReaderBuilder<MemberDto>()
                .fetchSize(chunkSize) // 데이터를 가져오는 크기 설정
                .dataSource(dataSource) // DataSource 설정
                .rowMapper(new BeanPropertyRowMapper<>(MemberDto.class)) // RowMapper 설정
                .sql("SELECT id, name, grade, mileage FROM MEMBER") // SQL 쿼리 설정
                .name("jdbcItemReader") // 빈의 이름 설정
                .build();
    }

    // 멤버 정보를 처리하는 CompositeItemWriter 빈 생성
    @Bean
    @StepScope
    public CompositeItemWriter<MemberDto> compositeWriter() {
        final CompositeItemWriter<MemberDto> compositeItemWriter = new CompositeItemWriter<>();
        compositeItemWriter.setDelegates(Arrays.asList(updateGrade(), insertVIP())); // 멤버 등급 업데이트 및 VIP 멤버 추가를 처리하는 ItemWriter 설정
        return compositeItemWriter;
    }

    // 멤버 등급을 업데이트하는 ItemWriter 빈 생성
    private CustomBatchItemWriter updateGrade() {
        String sql = "update MEMBER set grade = :grade where id = :id"; // 멤버 등급 업데이트를 위한 SQL 쿼리 설정

        JdbcBatchItemWriter<MemberDto> itemWriter = new JdbcBatchItemWriterBuilder<MemberDto>()
                .dataSource(dataSource)
                .sql(sql)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .build();

        return new CustomBatchItemWriter(itemWriter); // 커스텀 ItemWriter를 사용하여 멤버 등급 업데이트 작업을 처리
    }

    // VIP 멤버를 추가하는 ItemWriter 설정
    private ItemWriter<MemberDto> insertVIP() {
        String sql = "insert into VIP(id,name) values(:id, :name)"; // VIP 멤버 추가를 위한 SQL 쿼리 설정
        return items -> {
            JdbcBatchItemWriter<MemberDto> itemWriter = new JdbcBatchItemWriterBuilder<MemberDto>()
                    .dataSource(dataSource)
                    .sql(sql)
                    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                    .build();

            itemWriter.afterPropertiesSet(); // 빈의 속성을 설정
            itemWriter.write(new Chunk<MemberDto>(items.getItems().stream()
                    .filter(item -> item.getMileage() > 10000) // 마일리지가 10000 이상인 멤버만 선택
                    .collect(Collectors.toList())) // 선택된 멤버를 VIP 테이블에 추가
            );
        };
    }
}