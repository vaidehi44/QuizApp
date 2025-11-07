package com.spring.quiz.service;

import com.spring.quiz.dao.QuestionDao;
import com.spring.quiz.dao.QuizDao;
import com.spring.quiz.model.Question;
import com.spring.quiz.model.Quiz;
import com.spring.quiz.model.UserQuestion;
import com.spring.quiz.model.UserQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> addQuiz(String title, String category, Integer numQ) {
        try {
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            List<Question> ques = questionDao.getRandomQuestionsByCategory(category, numQ);
            quiz.setQuestions(ques);
            quizDao.save(quiz);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<UserQuiz> getQuizById(Integer id) {
        try {
            Quiz quiz = quizDao.findById(id).get();
            List<Question> questions = quiz.getQuestions();
            UserQuiz userQuiz = new UserQuiz(quiz.getTitle());
            List<UserQuestion> userQues = new ArrayList<>();
            for (Question question : questions) {
                UserQuestion userQue = new UserQuestion();
                userQue.setId(question.getId());
                userQue.setQuestionTitle(question.getQuestionTitle());
                userQue.setQuestion(question.getQuestion());
                userQue.setCategory(question.getCategory());
                userQue.setOption1(question.getOption1());
                userQue.setOption2(question.getOption2());
                userQue.setOption3(question.getOption3());
                userQue.setOption4(question.getOption4());
                userQues.add(userQue);
            }
            userQuiz.setQuestions(userQues);

            return new ResponseEntity<>(userQuiz, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //get a random quiz
    public ResponseEntity<UserQuiz> getQuiz() {
        try {
            Quiz quiz = quizDao.getRandomQuiz();
            UserQuiz userQuiz = new UserQuiz(quiz.getTitle());
            List<UserQuestion> userQues = new ArrayList<>();
            List<Question> questions = quiz.getQuestions();
            for (Question question : questions) {
                UserQuestion userQue = new UserQuestion();
                userQue.setId(question.getId());
                userQue.setQuestionTitle(question.getQuestionTitle());
                userQue.setQuestion(question.getQuestion());
                userQue.setCategory(question.getCategory());
                userQue.setOption1(question.getOption1());
                userQue.setOption2(question.getOption2());
                userQue.setOption3(question.getOption3());
                userQue.setOption4(question.getOption4());
                userQues.add(userQue);
            }
            userQuiz.setQuestions(userQues);
            return new ResponseEntity<>(userQuiz, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
