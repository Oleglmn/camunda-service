package com.oleglmn.camundaservice.delegate;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_FINISH_CODE_KEY;
import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_MESSAGE_KEY;
import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_TIME_ENV_CODE_KEY;

import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CompensationServiceTaskInSubProcessDelegate extends AbstractDelegate {

    @Value("${camunda.process.timer.duration}")
    private String timerEnv;

    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        log.info("\n***** Start compensation service task  in sub process 1 *****");

        log.info("\n Message from previous steps in process: \n {}", delegateExecution.getVariable(CAMUNDA_MESSAGE_KEY));

        delegateExecution.setVariable(CAMUNDA_MESSAGE_KEY, "Message from compensation sub process");
        delegateExecution.setVariable(CAMUNDA_TIME_ENV_CODE_KEY, timerEnv);
        Random random = new Random();

        int number = random.nextInt(2) + 1;
        if (number == 1) {
            delegateExecution.setVariable(CAMUNDA_FINISH_CODE_KEY, true);
        } else {
            delegateExecution.setVariable(CAMUNDA_FINISH_CODE_KEY, false);
        }
        log.info("\n CAMUNDA_FINISH_CODE_KEY: \n {}", delegateExecution.getVariable(CAMUNDA_FINISH_CODE_KEY));
        log.info("\n Variables: \n {}", delegateExecution.getVariables());

        log.info("\n***** End compensation service task in sub process 1 *****");
    }
}
