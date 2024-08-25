package com.exercise.polling_backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.polling_backend.constants.SystemEnvConst;
import com.exercise.polling_backend.dto.Question;
import com.exercise.polling_backend.dto.Vote;
import com.exercise.polling_backend.services.QuestionService;
import com.exercise.polling_backend.services.VoteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping(path = "v1/question")
@CrossOrigin(SystemEnvConst.CROSS_ORIGIN)
@Slf4j
public class QuestionController {

    QuestionService questionService;
    VoteService voteService;

    /**
     * Controller method to catch the request to create a question and return the
     * created question
     * 
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
     * 
     * @return
     */
    @GetMapping("/active")
    public ResponseEntity<?> getActiveQuestion() {
        log.info("Request to retrieve the currently active question recieved");
        try {
            Question question = questionService.getActiveQuestion();
            return ResponseEntity.status(HttpStatus.OK).body(question);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Controller method to get list of Votes for a given question
     * 
     * @return
     */
    @GetMapping("/votes")
    public ResponseEntity<?> getVotesForPoll(@RequestParam Integer pollId) {
        log.info(String.format("Request to retrieve the votes for question with id \"%s\"", pollId));
        try {
            List<Vote> listOfVotes = voteService.getVotesForQuestion(pollId);
            return ResponseEntity.status(HttpStatus.OK).body(listOfVotes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
