package com.insy2s.quizz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class DtoQuestionAnswerByIdPost {
    private UUID question;
    private UUID answer;
    private boolean isCorrect;
}
