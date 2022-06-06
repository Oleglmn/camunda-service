package com.oleglmn.camundaservice.controller;

import com.oleglmn.camundaservice.service.ProcessInitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class InitController {

    private final ProcessInitService processInitService;

    @PostMapping("start")
    public ResponseEntity<String> startRegistrationProcess() {
        processInitService.startRegistrationProcess();
        return ResponseEntity.ok("Process was started");
    }
}
