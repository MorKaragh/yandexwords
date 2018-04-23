package com.yandexwords.yandexwords.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.yandexwords.yandexwords.dao.WordRepository;
import com.yandexwords.yandexwords.model.Word;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI
public class MainUglyUI extends UI{

    @Autowired
    WordRepository wordRepository;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(buildContent());
    }

    private Component buildContent() {
        VerticalLayout main = new VerticalLayout();
        VerticalLayout wordsLayout = new VerticalLayout();
        HorizontalLayout controls = new HorizontalLayout();
        Button findBtn = new Button("найти");
        Button loadBtn = new Button("топ 10");
        TextField searchFld = new TextField();

        findBtn.addClickListener(clickEvent -> {
            Word byText = wordRepository.findByText(searchFld.getValue());
            wordsLayout.removeAllComponents();
            if (byText != null) {
                wordsLayout.addComponents(new Label(byText.toString()));
            }
        });

        loadBtn.addClickListener(clickEvent -> {
            List<Word> top10ByOrderByCountDesc = wordRepository.findTop10ByOrderByCountDesc();
            wordsLayout.removeAllComponents();
            top10ByOrderByCountDesc.forEach(word -> {
                wordsLayout.addComponents(new Label(word.toString()));
            });
        });


        controls.addComponents(searchFld, findBtn, loadBtn);
        main.addComponents(controls, wordsLayout);
        return main;
    }
}
