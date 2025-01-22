package com.insy2s.quizz.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Answer {
    @Id
    private Long id;

    @Column(unique = true)
    private final UUID uuid = UUID.randomUUID();

    private String value;

    @OneToMany(mappedBy = "answer")
    private List<QuestionAnswer> questionAnswerList = new ArrayList<>();
}
