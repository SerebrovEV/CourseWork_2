package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.repository.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    // Question find(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int size();


}
