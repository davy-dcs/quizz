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
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false)
    private UUID uuid;

    @NotBlank(message = "Title is mandatory.")
    private String title;

    @NotBlank(message = "Description is mandatory.")
    private String description;

    @ManyToMany
    @NotEmpty(message = "Quiz must contain at least one question.")
    private List<Question> questions = new ArrayList<>();

    @NotNull(message = "Difficulty is mandatory.")
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @NotNull(message = "Category is mandatory.")
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "quiz")
    private List<Session> sessions = new ArrayList<>();
}
