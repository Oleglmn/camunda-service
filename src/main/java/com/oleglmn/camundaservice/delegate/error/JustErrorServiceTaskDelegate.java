package com.oleglmn.camundaservice.delegate.error;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_JUST_ERROR_CODE_KEY;
import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;

import com.oleglmn.camundaservice.delegate.AbstractDelegate;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JustErrorServiceTaskDelegate extends AbstractDelegate {

    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** Start JUST_ERROR task *****");
        log.info("\n Message from previous steps in process: \n {}", delegateExecution.getVariable(CAMUNDA_MESSAGE_KEY));
        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Message from JUST_ERROR");
        delegateExecution.setVariable(CAMUNDA_JUST_ERROR_CODE_KEY, "Error happened for JUST_ERROR");

        log.info("\n***** End JUST_ERROR task *****");
    }
}
