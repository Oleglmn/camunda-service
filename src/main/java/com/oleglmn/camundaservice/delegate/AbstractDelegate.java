package com.oleglmn.camundaservice.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public abstract class AbstractDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Thread.sleep(3000);
        startExecute(delegateExecution);
    }

    public abstract void startExecute(DelegateExecution delegateExecution);

}
