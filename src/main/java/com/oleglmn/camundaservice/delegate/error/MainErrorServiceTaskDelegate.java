package com.oleglmn.camundaservice.delegate.error;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MAIN_ERROR_CODE_KEY;
import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;

import com.oleglmn.camundaservice.delegate.AbstractDelegate;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MainErrorServiceTaskDelegate extends AbstractDelegate {

    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** Start MAIN_ERROR task *****");
        log.info("\n Message from previous steps in process: \n {}", delegateExecution.getVariable(CAMUNDA_MESSAGE_KEY));
        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Message from MAIN_ERROR");
        delegateExecution.setVariable(CAMUNDA_MAIN_ERROR_CODE_KEY, "Error happened for MAIN_ERROR");

        log.info("\n***** End MAIN_ERROR task *****");
    }
}
