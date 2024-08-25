package com.exercise.polling_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.polling_backend.constants.SystemEnvConst;
import com.exercise.polling_backend.dto.Vote;
import com.exercise.polling_backend.services.VoteService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping(path = "v1/vote")
@CrossOrigin(SystemEnvConst.CROSS_ORIGIN)
@Slf4j
public class VoteController {

    VoteService voteService;

    /**
     * Controller method to catch the request to vote
     * 
     * @param question
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> createQuestion(@RequestParam Integer answerId) {
        log.info("Vote request recieved");
        try {
            Vote vote = voteService.vote(answerId);
            return ResponseEntity.status(HttpStatus.OK).body(vote);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
