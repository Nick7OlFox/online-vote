package com.exercise.polling_backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.polling_backend.dto.Option;
import com.exercise.polling_backend.dto.Question;
import com.exercise.polling_backend.repositories.OptionRepository;
import com.exercise.polling_backend.repositories.VoteRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class OptionService {

    OptionRepository optionRepository;
    VoteRepository voteRepository;

    /**
     * Service method to create all the necessary options for any given question
     * 
     * @param question The question object with the options to be created
     */
    public void createOptions(Question question) {
        try {
            List<Option> listOfOptions = new ArrayList<Option>();

            // Create options based on request
            for (String text : question.getListOfOptionsInput())
                listOfOptions.add(new Option(question.getId(), text));

            // Save all options to the database
            optionRepository.saveAll(listOfOptions);
            question.setListOfOptions(listOfOptions);

            // Clear input
            question.setListOfOptionsInput(null);

            log.info("Options created");
        } catch (Exception e) {
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Method to get list of option for a given question
     * 
     * @param question Obejct of the question
     * @return
     */
    public List<Option> getQuestionOptions(Question question) {
        try {
            log.info(String.format("Getting options for question \"%s\"", question.getQuestion()));
            List<Option> listOfOptions = optionRepository.findQuestionOptions(question.getId());

            for (Option option : listOfOptions) {
                option.setNumberOfVotes(voteRepository.findAnswerCount(option.getId()));
            }

            return listOfOptions;
        } catch (Exception e) {
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Method to get list of option for a given question
     * 
     * @param pollId Integer of the ID
     * @return
     */
    public List<Option> getQuestionOptions(Integer pollId) {
        try {
            log.info(String.format("Getting options for question with ID \"%s\"", pollId));
            List<Option> listOfOptions = optionRepository.findQuestionOptions(pollId);

            for (Option option : listOfOptions) {
                option.setNumberOfVotes(voteRepository.findAnswerCount(option.getId()));
            }

            return listOfOptions;
        } catch (Exception e) {
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }
}
