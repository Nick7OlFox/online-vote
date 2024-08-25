package com.exercise.polling_backend.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.polling_backend.dto.Option;
import com.exercise.polling_backend.dto.Question;
import com.exercise.polling_backend.dto.Vote;
import com.exercise.polling_backend.repositories.VoteRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class VoteService {

    VoteRepository voteRepository;

    QuestionService questionService;
    OptionService optionService;

    /**
     * Service method to vote
     * 
     * @param question The question object with the options to be created
     * @throws Exception
     */
    public Vote vote(Integer answerId) throws Exception {
        try {
            Question question = questionService.getActiveQuestion();

            // Check if answerId is a associated with the currently active question
            Iterator<Option> iterator = question.getListOfOptions().iterator();
            while (iterator.hasNext()) {
                Option option = iterator.next();

                if (answerId.equals(option.getId())) {
                    break;
                }

                // If answerId was not found
                if (!iterator.hasNext())
                    throw new Exception("The answer provided is not associated with a currently active question");
            }

            // Register the vote
            Vote vote = new Vote(answerId, new Timestamp(System.currentTimeMillis()));
            vote = voteRepository.save(vote);

            log.info("Vote registered");
            return vote;
        } catch (Exception e) {
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Method to get the list of votes for a given option
     * 
     * @param id
     * @return
     */
    public List<Vote> getVotesForOption(Integer id) {
        try {
            log.info(String.format("Getting votes for Option with ID \"%s\"", id));
            return voteRepository.findVotesForAnswer(id);
        } catch (Exception e) {
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Service layer method to retrieve the votes for the given question
     * 
     * @return
     * @throws Exception
     */
    public List<Vote> getVotesForQuestion(Integer pollId) {
        try {
            log.info(String.format("Getting votes for question with ID \"%s\"", pollId));
            List<Option> listOfOptions = optionService.getQuestionOptions(pollId);

            List<Vote> listOfVotes = new ArrayList<Vote>();
            for (Option option : listOfOptions) {
                listOfVotes.addAll(getVotesForOption(option.getId()));
            }

            return listOfVotes;
        } catch (Exception e) {
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }
}
