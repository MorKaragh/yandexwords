package com.yandexwords.yandexwords.yandex;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class YandexHttpCatcher {

    final URL url = new URL("https://export.yandex.ru/last/last20x.xml");

    public YandexHttpCatcher() throws MalformedURLException {
    }

    public String getXml() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder builder = new StringBuilder();
        reader.lines().forEach(builder::append);
        return builder.toString();
    }

}
