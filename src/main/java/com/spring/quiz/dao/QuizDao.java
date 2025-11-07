package com.spring.quiz.dao;

import com.spring.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

    @Query(value = "SELECT * FROM QUIZ ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Quiz getRandomQuiz();
}
