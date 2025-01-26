package com.insy2s.quizz.repository;

import com.insy2s.quizz.domain.Answer;
import com.insy2s.quizz.domain.Question;
import com.insy2s.quizz.domain.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IQuestionAnswerRepository extends JpaRepository<QuestionAnswer, UUID> {
    Optional<QuestionAnswer> findByQuestionAndAnswer(Question question, Answer answer);
}
