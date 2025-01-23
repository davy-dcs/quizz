package com.insy2s.quizz.controller;

import com.insy2s.quizz.domain.Question;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private ArrayList<Question> questions = new ArrayList<>();

    @GetMapping
    public ResponseEntity<ArrayList<Question>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    @PostMapping
    public ResponseEntity<Question> post(@Valid @RequestBody Question question) {
        return questions.add(question) ?
                ResponseEntity.status(HttpStatus.CREATED).body(question) :
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }
}
