package com.insy2s.quizz.repository;

import com.insy2s.quizz.domain.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
}
