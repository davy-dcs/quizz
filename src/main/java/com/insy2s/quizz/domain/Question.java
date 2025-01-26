package com.insy2s.quizz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Exclude
    @Column(updatable = false)
    private UUID uuid;

    @NotBlank(message = "Question is mandatory.")
    @Column(unique = true)
    private String value;

    @OneToMany(mappedBy = "question")
    @JsonIgnore
    private List<QuestionAnswer> answers = new ArrayList<>();

    @NotEmpty(message = "Question must contain at least one category.")
    @Enumerated(EnumType.STRING)
    private List<Category> categories = new ArrayList<>();

    @NotNull(message = "Difficulty is mandatory.")
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany(mappedBy = "questions")
    @JsonIgnore
    private List<Quiz> quizzes = new ArrayList<>();
}
