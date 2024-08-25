package com.exercise.polling_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.polling_backend.dto.QuestionTable;
import com.exercise.polling_backend.repositories.QuestionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class QuestionService {
    
    private QuestionRepository questionRepository;

    private OptionService optionService;

    public QuestionTable createQuestion(QuestionTable question){
        try{
            // TODO Stop creation if it has less than 2 options
            question.setIsActive(true);
            
            log.info("Setting isActive flag of other questions to false");
            List<QuestionTable> list = questionRepository.findAll();
            for(QuestionTable entry: list){
                entry.setIsActive(false);
            }
            questionRepository.saveAll(list);

            log.info("Creating question");
            question = questionRepository.save(question);
            
            log.info("Question created. Creating the options");
            
            optionService.createOptions(question);

            log.info("Question successfully created");
            return question;
        } catch (Exception e){
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            return null;
        }
    }
}
