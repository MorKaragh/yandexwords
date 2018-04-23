package com.yandexwords.yandexwords.yandex;

import org.jdom2.JDOMException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class YandexParserTest {

    @Test
    public void parse() throws JDOMException, IOException {
        String xml = "<page>\n" +
                "<last20x>\n" +
                "<item found=\"596051\">альфа банк оренбург директор</item>\n" +
                "<item found=\"315201\">окружной методический центр дорогомилово</item>" +
                "</last20x>\n" +
                "</page>";

        YandexParser parser = new YandexParser();
        assertEquals(parser.parse(xml).size(), 8);

    }
}