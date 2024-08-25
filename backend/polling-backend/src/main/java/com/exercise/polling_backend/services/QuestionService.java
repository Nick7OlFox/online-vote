package com.exercise.polling_backend.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.polling_backend.dto.Question;
import com.exercise.polling_backend.repositories.QuestionRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class QuestionService {
    
    private QuestionRepository questionRepository;

    private OptionService optionService;

    /**
     * Service layer method that will create/replace the question being polled
     * @param question The requested question passed via a Request body
     * @return The created question
     */
    public Question createQuestion(Question question){
        try{
            // Meet minimum of options constraint
            if(question.getListOfOptionsInput().size() < 2){
                log.warn("There are not enough options. Question not created");
                throw new IllegalArgumentException("A minimum of 2 options is required to create a question");
            }

            // Meet maximum of options constraint
            if(question.getListOfOptionsInput().size() > 7){
                log.warn("There are too many options. Question not created");
                throw new IllegalArgumentException("A maximum of 7 options is allowed when creating a question");
            }

            // Make sure date is in the future
            if(null != question.getEndDate() && !question.getEndDate().after(new Timestamp(System.currentTimeMillis()))){
                log.warn("The date sent is not in the future. Question not created");
                throw new IllegalArgumentException("The end date for the question must be in the future");
            }

            // Request passed initial validation. Try to create request now
            // Save question to the database (Question will only be active when all entries have been successfully created)
            log.info("Saving question to the database");
            question.setIsActive(false);
            question = questionRepository.save(question);
            
            log.info("Question created. Creating the options");
            optionService.createOptions(question);

            // Set current question to active and make sure no other question is set to true
            log.info("Setting active flag for other existing questions to false");
            List<Question> list = questionRepository.findActive();
            for(Question entry: list)
                entry.setIsActive(false);
            questionRepository.saveAll(list);

            log.info("Setting active flag for this question as true");
            question.setIsActive(true);
            question = questionRepository.save(question);

            log.info("Question successfully created");
            return question;
        } catch (Exception e){
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Service layer method to retrieve the currently active question
     * @return
     * @throws Exception 
     */
    public Question getActiveQuestion() throws Exception {
        try{
            List<Question> list = questionRepository.findActive();
            
            // Error handling
            // No active question
            if (list.size() == 0) {
                log.warn("No active question found");
                throw new Exception("No question is currently active");
            }
            // More than one active question
            if(list.size() > 1){
                log.warn("More than one active question was retrieved. Error thrown");
                throw new Exception("More than one question is active at the present time. Please contact an administrator to fix the issue");
            }

            Question question = list.get(0);

            // Get question options
            question.setListOfOptions(optionService.getQuestionOptions(question));

            // Return the only item on the list
            return list.get(0);
        } catch (Exception e){
            log.warn("An error orccured when trying to create the question");
            e.printStackTrace();
            throw e;
        }
    }
}
