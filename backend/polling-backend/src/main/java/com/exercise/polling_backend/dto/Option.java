package com.exercise.polling_backend.dto;

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
@Table(name = SystemEnvConst.OPTIONS_TABLE_NAME)
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "poll")
    private Integer poll;
    @Column(name = "text")
    private String text;

    /**
     * Constructor without id
     * @param poll
     * @param text
     */
    public Option(Integer poll, String text) {
        this.poll = poll;
        this.text = text;
    }

    
}
