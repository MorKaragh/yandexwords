package com.yandexwords.yandexwords.yandex;

import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class YandexHttpCatcherTest {

    @Test
    public void getXml() throws Exception {
        YandexHttpCatcher catcher = new YandexHttpCatcher();
        String xml = catcher.getXml();
        assertNotNull(xml);
        assertTrue(xml.contains("last20x"));
    }
}