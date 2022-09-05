package com.skypro.java8.course_work_2.service;

import com.skypro.java8.course_work_2.exception.ArgumentQuestionRepeatsAnswer;
import com.skypro.java8.course_work_2.exception.IncorrectQuestionOrAnswer;
import com.skypro.java8.course_work_2.exception.ObjectNotFoundException;
import com.skypro.java8.course_work_2.exception.StorageIsEmptyException;
import com.skypro.java8.course_work_2.repository.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> javaQuestions = new HashSet<>();
    private final Random random = new Random();

    private void checkQuestion(String question, String answer) {
        if (question == null || answer == null) {
            throw new IncorrectQuestionOrAnswer();
        }
        if (question.equals(answer)) {
            throw new ArgumentQuestionRepeatsAnswer();
        }
    }


    @Override
    public Question add(String question, String answer) {
        Question questionAdd = new Question(question, answer);
        add(questionAdd);
        return questionAdd;
    }

    @Override
    public Question add(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        checkQuestion(question.getQuestion(), question.getAnswer());
        if (javaQuestions.remove(question)) {
            return question;
        }
        throw new ObjectNotFoundException();
    }

    @Override
    public Question find(Question question) {
        return javaQuestions.stream()
                .filter(q -> q.equals(question))
                .findFirst()
                .orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestions;
    }

    @Override
    public Question getRandomQuestion() {
        if (javaQuestions.size() == 0) {
            throw new StorageIsEmptyException();
        }
        int value = random.nextInt(javaQuestions.size());
        List<Question> questionList = new ArrayList<>(javaQuestions);
        return questionList.get(value);
    }

    @Override
    public int size() {
        return javaQuestions.size();
    }
}
