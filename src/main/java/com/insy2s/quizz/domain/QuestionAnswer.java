package com.insy2s.quizz.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class QuestionAnswer {

    @Id
    @ManyToOne
    private Question question;

    @Id
    @ManyToOne
    private Answer answer;

    private boolean isCorrect;
}
