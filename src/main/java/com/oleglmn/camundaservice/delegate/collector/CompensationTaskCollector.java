package com.oleglmn.camundaservice.delegate.collector;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_FINISH_CODE_KEY;
import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;

import com.oleglmn.camundaservice.delegate.AbstractDelegate;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CompensationTaskCollector extends AbstractDelegate {

    @Override
    public void startExecute(DelegateExecution delegateExecution) {

        delegateExecution.setVariable(CAMUNDA_FINISH_CODE_KEY, false);
        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Default");

    }
}
