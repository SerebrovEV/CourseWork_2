package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
