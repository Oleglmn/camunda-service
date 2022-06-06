package com.oleglmn.camundaservice.delegate;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_FATAL_ERROR_CODE_KEY;
import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;

import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceTaskThirdDelegate extends AbstractDelegate {
    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** Start service task 3 *****");

        log.info("\n Message from previous steps in process: \n {}", delegateExecution.getVariable(CAMUNDA_MESSAGE_KEY));
        log.info("\n Variables: \n {}", delegateExecution.getVariables());

        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Message from ServiceTask 3");

        Random random = new Random();

        int number = random.nextInt(2) + 1;
        if (number == 1) {
            delegateExecution.setVariable(CAMUNDA_FATAL_ERROR_CODE_KEY, "MAIN_ERROR");
        } else {
            delegateExecution.setVariable(CAMUNDA_FATAL_ERROR_CODE_KEY, "JUST_ERROR");
        }

        log.info("\n***** End service task 3 *****");
    }
}
