package n_1.batch.job;

import n_1.mock.MockStoreData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * HibernatePagingItemReader는 batch size가 적용되어 N+1 문제가 발생하지 않는 걸 보여주는 테스트
 *
 * 로그 결과
 * Hibernate: select store0_.id as id1_3_, ... from store store0_ where store0_.address like ? limit ?
 * Hibernate: select products0_.store_id as store_id4_2_1_, ... from product products0_ where products0_.store_id in (?, ?, ?)
 * Hibernate: select employees0_.store_id as store_id4_0_1_, ... from employee employees0_ where employees0_.store_id in (?, ?, ?)
 */
@TestPropertySource(properties = "job.name=hibernatePagingReaderBatchJob")
@SpringBootTest
class HibernatePagingReaderBatchTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private MockStoreData mockStoreData;

    @DisplayName("HibernatePagingItemReader는 batch size가 적용되어 N+1 문제가 발생하지 않는다.")
    @Test
    public void batch_size_is_applied_to_HibernatePagingItemReader() throws Exception {
        // given
        mockStoreData.saveStores();

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("address", "서울")
                .addDate("requestDate", new Date())
                .toJobParameters();

        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        // then
        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);
    }
}

