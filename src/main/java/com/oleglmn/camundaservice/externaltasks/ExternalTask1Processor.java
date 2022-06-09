package com.oleglmn.camundaservice.externaltasks;

import static java.util.UUID.randomUUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ExternalTaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExternalTask1Processor {

    private static final int FETCH_LOCK_SIZE = 50;
    private static final String TASK_CONFIRM_ACCOUNT_WORKER = "Worker" + randomUUID();
    private static final String CAMUNDA_TOPIC = "ExternalTask1";
    private static final long LOCK_INTERVAL = 10000L;

    private final ExternalTaskService externalTaskService;

    @Scheduled(fixedDelay = 5000)
    public void execute() {
        var tasks = externalTaskService
                .fetchAndLock(FETCH_LOCK_SIZE, TASK_CONFIRM_ACCOUNT_WORKER)
                .topic(CAMUNDA_TOPIC, LOCK_INTERVAL)
                .execute();

        for (var externalTask : tasks) {
            log.info("\n***** Start external task 1 *****");

            var taskVariables = externalTask.getVariables();
            log.info("All camunda variables: ");
            taskVariables.forEach((key, value) -> log.info("\"{}\": \"{}\"", key, value));

            externalTaskService.complete(externalTask.getId(), TASK_CONFIRM_ACCOUNT_WORKER, taskVariables);

            log.info("\n***** End external task 1 *****");
        }
    }
}
