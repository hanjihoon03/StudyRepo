package com.example.batch.test.job;

import com.example.batch.test.BatchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JdbcJobConfig {
    private final DataSource dataSource; // 데이터베이스 연결을 위한 DataSource 주입

    private static final int chunkSize = 10; // 청크 크기 설정

    @Bean
    public Job jdbcJob(JobRepository jobRepository, PlatformTransactionManager transactionManager, Step jdbcStep) {
        return new JobBuilder("jdbcJob", jobRepository)
                .start(jdbcStep)
                .build();
    }

    @Bean
    @JobScope
    public Step jdbcStep(@Value("#{jobParameters[reqDt]}") String requestDate, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("jdbcStep", jobRepository)
                .<BatchDto, BatchDto>chunk(chunkSize, transactionManager) // 청크 단위 설정
                .reader(jdbcItemReader()) // ItemReader 설정
                .writer(jdbcItemWriter()) // ItemWriter 설정
                .build();
    }

    //JDBC를 사용하여 데이터를 읽는 ItemReader 빈 생성
    @Bean
    @StepScope
    public JdbcCursorItemReader<BatchDto> jdbcItemReader() {
        return new JdbcCursorItemReaderBuilder<BatchDto>()
                .fetchSize(chunkSize) // 데이터를 가져오는 크기 설정
                .dataSource(dataSource) // DataSource 설정
                .rowMapper(new BeanPropertyRowMapper<>(BatchDto.class)) // RowMapper 설정
                .sql("SELECT id, name FROM BATCH_TEST") // SQL 쿼리 설정
                .name("jdbcItemReader") // 빈의 이름 설정
                .build();
    }

    // JDBC를 사용하여 데이터를 쓰는 ItemWriter 빈 생성
    @Bean
    public JdbcBatchItemWriter<BatchDto> jdbcItemWriter() {
        String sql = "UPDATE BATCH_TEST set name = ? where id = ?"; // SQL 업데이트 쿼리 설정
        return new JdbcBatchItemWriterBuilder<BatchDto>().dataSource(dataSource)
                .sql(sql) // SQL 쿼리 설정
                .itemPreparedStatementSetter((item, ps) -> { // PreparedStatement 설정
                    ps.setString(1, "SYSTEM"); // 첫 번째 매개변수 설정
                    ps.setLong(2, item.getId()); // 두 번째 매개변수 설정
                })
                .assertUpdates(true) // 업데이트가 성공했는지 확인 설정
                .build();
    }
}


