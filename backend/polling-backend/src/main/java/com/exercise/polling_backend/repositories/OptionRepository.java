package com.exercise.polling_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.polling_backend.dto.Option;

public interface OptionRepository extends JpaRepository<Option, Integer> {

}
