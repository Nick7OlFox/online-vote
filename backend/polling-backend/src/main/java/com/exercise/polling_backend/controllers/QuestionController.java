package com.exercise.polling_backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.polling_backend.constants.SystemEnvConst;
import com.exercise.polling_backend.dto.QuestionTable;
import com.exercise.polling_backend.services.QuestionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping(path = "v1/question")
@CrossOrigin(SystemEnvConst.CROSS_ORIGIN)
@Slf4j
public class QuestionController {

    QuestionService questionService;

    @PostMapping("/")
    public QuestionTable createQuestion(@RequestBody QuestionTable question) {
        log.info("Request to create a new question recieved");
        try {
            return questionService.createQuestion(question);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
