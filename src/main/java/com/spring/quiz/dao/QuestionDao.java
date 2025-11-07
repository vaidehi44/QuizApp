package com.spring.quiz.dao;

import com.spring.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM QUESTION Q WHERE Q.CATEGORY=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> getRandomQuestionsByCategory(String category, Integer numQ);
}
