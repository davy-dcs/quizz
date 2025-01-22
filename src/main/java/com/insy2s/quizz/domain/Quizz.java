package com.insy2s.quizz.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Quizz {

    @Id
    private Long id;

    @Column(unique = true)
    private UUID uuid = UUID.randomUUID();

    private String title;

    private String description;

    @ManyToMany
    private List<Question> questions = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "quizz")
    private List<Session> sessions = new ArrayList<>();
}
