package com.insy2s.quizz.repository;

import com.insy2s.quizz.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, UUID> {
    Optional<Question> findByValueIgnoreCase(String value);
}
