package com.yandexwords.yandexwords.dao;

import com.yandexwords.yandexwords.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WordRepository extends JpaRepository<Word, Long>{

    Word findByText(String text);

    List<Word> findTop10ByOrderByCountDesc();

}
