package com.insy2s.quizz.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Question {
    @Id
    private Long id;

    @Column(unique = true)
    private final UUID uuid = UUID.randomUUID();

    private String value;

    @OneToMany(mappedBy = "question")
    private List<QuestionAnswer> questionAnswerList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private List<Category> categories = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany(mappedBy = "questions")
    private List<Quizz> quizzes = new ArrayList<>();
}
