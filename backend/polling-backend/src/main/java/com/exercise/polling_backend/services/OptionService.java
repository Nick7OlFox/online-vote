package com.exercise.polling_backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.polling_backend.dto.OptionTable;
import com.exercise.polling_backend.dto.QuestionTable;
import com.exercise.polling_backend.repositories.OptionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class OptionService {

    OptionRepository optionRepository;

    public void createOptions(QuestionTable question) {
        try {
            List<OptionTable> listOfOptions = new ArrayList<OptionTable>();
            for (String option : question.getListOfOptions()) {
                listOfOptions.add(new OptionTable(question.getId(), option));
            }
            optionRepository.saveAll(listOfOptions);
            log.info("Options created");
        } catch (Exception e) {
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
        }
    }
}
