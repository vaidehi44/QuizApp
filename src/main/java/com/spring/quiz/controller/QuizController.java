package com.spring.quiz.controller;

import com.spring.quiz.model.UserQuiz;
import com.spring.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> addQuiz(@RequestParam String title, @RequestParam  String category, @RequestParam Integer numQ) {
        return quizService.addQuiz(title, category, numQ);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<UserQuiz> getQuizById(@PathVariable Integer id) {
        return quizService.getQuizById(id);
    }

    @GetMapping("get")
    public ResponseEntity<UserQuiz> getQuiz() {
        return quizService.getQuiz();
    }
}
