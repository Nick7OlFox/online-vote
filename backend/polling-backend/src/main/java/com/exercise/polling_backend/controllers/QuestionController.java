package com.exercise.polling_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.polling_backend.constants.SystemEnvConst;
import com.exercise.polling_backend.dto.Question;
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

    /**
     * Controller method to catch the request to create a question and return the created question
     * @param question
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<?> createQuestion(@RequestBody Question question) {
        log.info("Request to create a new question recieved");
        try {
            question = questionService.createQuestion(question);
            return ResponseEntity.status(HttpStatus.OK).body(question);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Controller method to get the currently active question
     * @return
     */
    @GetMapping("/active")
    public ResponseEntity<?> getActiveQuestion(){
        log.info("Request to retrieve the currently active question recieved");
        try{
            Question question = questionService.getActiveQuestion();
            return ResponseEntity.status(HttpStatus.OK).body(question);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
