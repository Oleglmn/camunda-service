package com.oleglmn.camundaservice.delegate.error;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_COMPENSATION_ERROR_CODE_KEY;
import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;

import com.oleglmn.camundaservice.delegate.AbstractDelegate;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ErrorServiceTaskFirstDelegate extends AbstractDelegate {

    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** Start COMPENSATION_ERROR task *****");
        log.info("\n Message from previous steps in process: \n {}", delegateExecution.getVariable(CAMUNDA_MESSAGE_KEY));
        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Message from COMPENSATION_ERROR");
        delegateExecution.setVariable(CAMUNDA_COMPENSATION_ERROR_CODE_KEY, "Error happened for COMPENSATION_ERROR");

        log.info("\n***** End COMPENSATION_ERROR task *****");
    }
}
