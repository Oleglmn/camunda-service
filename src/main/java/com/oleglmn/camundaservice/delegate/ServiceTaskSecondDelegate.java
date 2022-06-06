package com.oleglmn.camundaservice.delegate;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;
import static com.oleglmn.camundaservice.service.ProcessInitService.CAMUNDA_DEFAULT_VARIABLE;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceTaskSecondDelegate extends AbstractDelegate {
    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** Start service task 2 *****");

        log.info("\n Message from previous steps in process: \n {}", delegateExecution.getVariable(CAMUNDA_DEFAULT_VARIABLE));
        log.info("\n Message from previous steps in process: \n {}", delegateExecution.getVariable(CAMUNDA_MESSAGE_KEY));

        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Message from ServiceTask 2");

        log.info("\n***** End service task 2 *****");
    }
}
