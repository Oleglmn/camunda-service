package com.oleglmn.camundaservice.service;

import static com.oleglmn.camundaservice.delegate.CamundaVariables.CAMUNDA_GO_TO_TASK2_KEY;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProcessInitService {
    public static final String CAMUNDA_PROCESS_KEY = "camundaMain";
    public static final String CAMUNDA_DEFAULT_VARIABLE = "defaultVariable";

    private final RuntimeService runtimeService;

    public ProcessInitService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void startRegistrationProcess() {
        runtimeService.startProcessInstanceByKey(CAMUNDA_PROCESS_KEY, UUID.randomUUID().toString(), initDefaultVariables());
    }

    private Map<String, Object> initDefaultVariables() {
        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put(CAMUNDA_DEFAULT_VARIABLE, "default variable");
        processVariables.put(CAMUNDA_GO_TO_TASK2_KEY, "false");


        return processVariables;
    }
}
