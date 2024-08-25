package com.exercise.polling_backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exercise.polling_backend.dto.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    @Query("SELECT COUNT(v.id) FROM Vote v WHERE v.answer = :answer")
    Integer findAnswerCount(@Param("answer") Integer answer);

    @Query("SELECT v FROM Vote v WHERE v.answer = :answer")
    List<Vote> findVotesForAnswer(@Param("answer") Integer answer);
}
