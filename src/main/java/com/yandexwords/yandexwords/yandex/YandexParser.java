package com.yandexwords.yandexwords.yandex;

import com.yandexwords.yandexwords.model.Word;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class YandexParser {


    public List<Word> parse(String xml) throws JDOMException, IOException {
        assert  xml != null;
        List<Word> result = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new ByteArrayInputStream(xml.getBytes()));
        List<Element> items = document.getRootElement().getChild("last20x").getChildren();
        items.forEach(item->
            {
                String phrase = item.getText();
                Arrays.asList(phrase.split(" ")).forEach(word -> result.add(new Word(word)));
            }
        );
        return result;
    }

}
