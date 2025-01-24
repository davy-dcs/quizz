package com.insy2s.quizz.controller;

import com.insy2s.quizz.domain.Answer;
import com.insy2s.quizz.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<Answer>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(answerService.getAllAnswers());
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Answer answer){
        answerService.createAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
