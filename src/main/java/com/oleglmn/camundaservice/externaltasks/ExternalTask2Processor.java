package com.oleglmn.camundaservice.externaltasks;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Service;

@Service
@ExternalTaskSubscription("ExternalTask2")
@Slf4j
public class ExternalTask2Processor implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        log.info("\n***** Start external task 2 *****");

        var taskVariables = externalTask.getAllVariables();
        log.info("All camunda variables: ");
        taskVariables.forEach((key, value) -> log.info("\"{}\": \"{}\"", key, value));

        externalTaskService.complete(externalTask, taskVariables);

        log.info("\n***** End external task 2 *****");
    }
}
