package com.insy2s.quizz.service;

import com.insy2s.quizz.domain.Answer;
import com.insy2s.quizz.domain.Question;
import com.insy2s.quizz.domain.QuestionAnswer;
import com.insy2s.quizz.dto.DtoQuestionAnswerByIdPost;
import com.insy2s.quizz.exception.AnswerNotFoundException;
import com.insy2s.quizz.exception.QuestionAnswerAlreadyExistException;
import com.insy2s.quizz.exception.QuestionNotFoundException;
import com.insy2s.quizz.repository.IAnswerRepository;
import com.insy2s.quizz.repository.IQuestionAnswerRepository;
import com.insy2s.quizz.repository.IQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionAnswerService {
    private final IQuestionAnswerRepository questionAnswerRepository;

    private final QuestionService questionService;
    private final AnswerService answerService;

    private final IAnswerRepository answerRepository;
    private final IQuestionRepository questionRepository;

    public List<QuestionAnswer> getAllQuestionsAnswers() {
        return questionAnswerRepository.findAll();
    }

    public void postQuestionAnswer(DtoQuestionAnswerByIdPost dtoQuestionAnswerByIdPost){
        Optional<Question> questionOptional = questionRepository.findById(dtoQuestionAnswerByIdPost.getQuestion());
        Optional<Answer> answerOptional = answerRepository.findById(dtoQuestionAnswerByIdPost.getAnswer());
        questionOptional.ifPresentOrElse(
                questionFound -> {
                    answerOptional.ifPresentOrElse(
                            answerFound -> {
                                Optional<QuestionAnswer> questionAnswerOptional = questionAnswerRepository.findByQuestionAndAnswer(questionFound, answerFound);
                                questionAnswerOptional.ifPresentOrElse(
                                        exist -> {throw new QuestionAnswerAlreadyExistException("Question answer already exist.");},
                                        () -> {
                                            QuestionAnswer questionAnswer = new QuestionAnswer();
                                            questionAnswer.setQuestion(questionFound);
                                            questionAnswer.setAnswer(answerFound);
                                            questionAnswer.setCorrect(dtoQuestionAnswerByIdPost.isCorrect());
                                            questionAnswerRepository.save(questionAnswer);
                                        }
                                );
                            },
                            () -> {throw new AnswerNotFoundException("Answer not found.");}
                    );
                },
                () -> {throw new QuestionNotFoundException("Question not found.");}
        );
    }

    // Creer - question (exist) et reponses (exit)


    private void getQuestion() {}
}
