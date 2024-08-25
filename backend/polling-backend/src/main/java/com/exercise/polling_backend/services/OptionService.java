package com.exercise.polling_backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.polling_backend.dto.Option;
import com.exercise.polling_backend.dto.Question;
import com.exercise.polling_backend.repositories.OptionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class OptionService {

    OptionRepository optionRepository;

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

    public List<Option> getQuestionOptions(Question question) {
        try {
            log.info(String.format("Getting options for question \"%s\"", question.getQuestion()));
            return optionRepository.findQuestionOptions(question.getId());
        } catch (Exception e) {
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }
}
