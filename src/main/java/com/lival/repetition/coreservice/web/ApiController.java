package com.lival.repetition.coreservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/start")
    public String start() {
        return "It is start of repetition application";
    }

}
