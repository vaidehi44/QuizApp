package com.spring.quiz.model;

import lombok.Data;

@Data
public class UserQuestion {

    private Integer id;
    private String questionTitle;
    private String question;
    private String category;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
