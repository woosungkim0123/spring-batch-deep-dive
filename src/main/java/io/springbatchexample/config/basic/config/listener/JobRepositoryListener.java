package io.springbatchexample.config.basic.config.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JobRepositoryListener implements JobExecutionListener {
    private final JobRepository jobRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("version", "1")
                .toJobParameters();

        JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
        if(lastJobExecution != null) {
            for(StepExecution stepExecution : lastJobExecution.getStepExecutions()) {
                BatchStatus status = stepExecution.getStatus();
                System.out.println("status = " + status);
                ExitStatus exitStatus = stepExecution.getExitStatus();
                System.out.println("exitStatus = " + exitStatus);
                String stepName = stepExecution.getStepName();
                System.out.println("stepName = " + stepName);
            }

        }
    }
}
