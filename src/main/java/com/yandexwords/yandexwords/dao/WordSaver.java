package com.yandexwords.yandexwords.dao;

import com.yandexwords.yandexwords.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordSaver {

    @Autowired
    WordRepository repository;

    public void save(List<Word> words) {
        words.forEach(word -> {
            try {
                Word toSave = repository.findByText(word.getText());
                if (toSave == null) {
                    toSave = new Word(word.getText());
                    toSave.setCount(1L);
                } else {
                    toSave.setCount(toSave.getCount() + 1);
                }
                repository.save(toSave);
            } catch (Exception e){
                System.out.println("ERROR WORD " + word.getText());
            }

        });
    }
}
