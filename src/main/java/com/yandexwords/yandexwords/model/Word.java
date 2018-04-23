package com.yandexwords.yandexwords.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Word {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private Long count;

    public Word(String text) {
        this.text = text;
    }
}
