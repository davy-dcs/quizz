package com.insy2s.quizz.service;

import com.insy2s.quizz.domain.Question;
import com.insy2s.quizz.repository.IQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final IQuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public void createQuestion(Question question) {
        questionRepository.save(question);
    }
}
