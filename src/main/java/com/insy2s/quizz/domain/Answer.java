package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    private UUID uuid;

    @Setter
    private String value;

    @OneToMany(mappedBy = "answer")
    private List<QuestionAnswer> questionAnswerList = new ArrayList<>();
}
