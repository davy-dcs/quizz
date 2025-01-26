package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class QuestionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Exclude
    private UUID id;

    @NotNull(message = "Question is mandatory.")
    @ManyToOne
    private Question question;

    @NotNull(message = "Answer is mandatory.")
    @ManyToOne
    private Answer answer;

    @Column(nullable = false)
    @NotNull(message = "Answer value is mandatory.")
    private boolean isCorrect;
}
