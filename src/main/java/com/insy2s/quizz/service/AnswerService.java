package com.insy2s.quizz.service;

import com.insy2s.quizz.domain.Answer;
import com.insy2s.quizz.repository.IAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final IAnswerRepository answerRepository;

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public void createAnswer(Answer answer) {
        answerRepository.save(answer);
    }
}
