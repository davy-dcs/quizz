package com.insy2s.quizz.repository;

import com.insy2s.quizz.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAnswerRepository extends JpaRepository<Answer, UUID> {
    Optional<Answer> findByValueIgnoreCase(String value);
    boolean existsByValue(String value);
}
