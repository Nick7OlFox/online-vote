package com.exercise.polling_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.polling_backend.dto.QuestionTable;

public interface QuestionRepository extends JpaRepository<QuestionTable, Integer>{

    // @Query("SELECT * FROM questions WHERE is_active = true")
    // List<QuestionTable> findByIsActiveTrue();
}
