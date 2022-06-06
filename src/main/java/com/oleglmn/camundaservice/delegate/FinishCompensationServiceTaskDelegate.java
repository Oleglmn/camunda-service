package com.oleglmn.camundaservice.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FinishCompensationServiceTaskDelegate extends AbstractDelegate {

    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** FINISH COMPENSATION_ERROR *****");
    }
}
