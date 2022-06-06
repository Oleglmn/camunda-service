package com.oleglmn.camundaservice.delegate;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceTaskFirstDelegate extends AbstractDelegate {
    @Value("${application.camunda.task1.throwEnabled}")
    private Boolean throwEnabled;

    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** Start service task 1 *****");
        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Message from ServiceTask 1");

        if (throwEnabled) {
            throw new BpmnError("COMPENSATION_ERROR");
        }
        log.info("\n***** End service task 1 *****");
    }
}
