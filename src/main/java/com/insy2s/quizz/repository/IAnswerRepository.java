package com.insy2s.quizz.repository;

import com.insy2s.quizz.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAnswerRepository extends JpaRepository<Answer, UUID> {
}
