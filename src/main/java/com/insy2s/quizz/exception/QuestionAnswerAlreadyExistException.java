package com.insy2s.quizz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class QuestionAnswerAlreadyExistException extends RuntimeException {
    public QuestionAnswerAlreadyExistException(String message) {
        super(message);
    }
}
