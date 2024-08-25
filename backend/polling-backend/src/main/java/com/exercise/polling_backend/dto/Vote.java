package com.exercise.polling_backend.dto;

import java.sql.Timestamp;

import com.exercise.polling_backend.constants.SystemEnvConst;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = SystemEnvConst.VOTES_TABLE_NAME)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "answer")
    private Integer answer;
    @Column(name = "time")
    private Timestamp time;

    /**
     * Constructor without id
     * 
     * @param anser
     * @param time
     */
    public Vote(Integer answer, Timestamp time) {
        this.answer = answer;
        this.time = time;
    }

}
