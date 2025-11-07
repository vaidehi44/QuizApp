package com.spring.quiz.model;

import lombok.Data;

import java.util.List;

@Data
public class UserQuiz {

    private String title;
    private List<UserQuestion> questions;

    public UserQuiz(String title) {
        this.title = title;
    }
}
