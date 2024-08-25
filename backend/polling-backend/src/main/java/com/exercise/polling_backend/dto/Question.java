package com.exercise.polling_backend.dto;

import java.sql.Timestamp;
import java.util.List;

import com.exercise.polling_backend.constants.SystemEnvConst;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = SystemEnvConst.QUESTIONS_TABLE_NAME)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "question")
    private String question;
    @Column(name = "end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp  endDate;
    @Column(name = "is_active")
    private Boolean isActive;

    @Transient
    private List<String> listOfOptionsInput;
    @Transient
    private List<Option> listOfOptions;
}
