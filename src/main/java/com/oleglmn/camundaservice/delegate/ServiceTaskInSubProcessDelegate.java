package com.oleglmn.camundaservice.delegate;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_GO_TO_TASK2_KEY;
import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceTaskInSubProcessDelegate extends AbstractDelegate {
    @Value("${application.camunda.go-to-second-task}")
    private Boolean goToTaskSecond;

    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** Start service task  in sub process 1 *****");

        log.info("\n Message from previous steps in process: \n {}", delegateExecution.getVariable(CAMUNDA_MESSAGE_KEY));
        log.info("\n All variables: \n {}", delegateExecution.getVariables().toString());

        delegateExecution.setVariable(CAMUNDA_GO_TO_TASK2_KEY, goToTaskSecond);
        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Message from sub process 1");
        log.info("\n All variables: \n {}", delegateExecution.getVariables().toString());

        log.info("\n***** End service task in sub process 1 *****");
    }
}
