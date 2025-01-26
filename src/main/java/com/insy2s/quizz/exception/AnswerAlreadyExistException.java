package com.insy2s.quizz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AnswerAlreadyExistException extends RuntimeException {
    public AnswerAlreadyExistException(String message) {
        super(message);
    }
}
