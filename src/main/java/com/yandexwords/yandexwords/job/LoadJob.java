package com.yandexwords.yandexwords.job;

import com.yandexwords.yandexwords.dao.WordSaver;
import com.yandexwords.yandexwords.model.Word;
import com.yandexwords.yandexwords.yandex.YandexHttpCatcher;
import com.yandexwords.yandexwords.yandex.YandexParser;
import org.jdom2.JDOMException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class LoadJob implements Job {

    @Autowired
    YandexHttpCatcher catcher;

    @Autowired
    YandexParser parser;

    @Autowired
    WordSaver saver;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Word> words;
        try {
            String xml = catcher.getXml();
            words = parser.parse(xml);
            saver.save(words);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }
}
