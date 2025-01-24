package com.insy2s.quizz.service;

import com.insy2s.quizz.domain.QuestionAnswer;
import com.insy2s.quizz.repository.IQuestionAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionAnswerService {
    private final IQuestionAnswerRepository questionAnswerRepository;

    public List<QuestionAnswer> getAllQuestionsAnswers() {
        return questionAnswerRepository.findAll();
    }

    public void postQuestionAnswer(QuestionAnswer questionAnswer){
        questionAnswerRepository.save(questionAnswer);
    }

    public void postQuestionAnswers() {
        //
    }
}
