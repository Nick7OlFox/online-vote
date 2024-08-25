package com.exercise.polling_backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.polling_backend.dto.Option;

public interface OptionRepository extends JpaRepository<Option, Integer> {

    @Query("SELECT o FROM Option o WHERE o.poll = poll")
    List<Option> findQuestionOptions(Integer poll);
}
