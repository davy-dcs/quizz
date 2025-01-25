package com.insy2s.quizz.controller;

import com.insy2s.quizz.domain.Answer;
import com.insy2s.quizz.dto.answer.AnswerValueDto;
import com.insy2s.quizz.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//TODO Uniquement les admins

@RequiredArgsConstructor
@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;

    /**
     * Get all value's answers
     *
     * @return List of values
     */
    @GetMapping
    public ResponseEntity<List<AnswerValueDto>> getValues() {
        return ResponseEntity.status(HttpStatus.OK).body(answerService.getAnswersValues());
    }

    /**
     * Get all answers
     *
     * @return List of answers
     */
    @GetMapping("/whole")
    public ResponseEntity<List<Answer>> getAnswers() {
        return ResponseEntity.status(HttpStatus.OK).body(answerService.getAnswers());
    }

    /**
     * Create answers by values
     *
     * @param answerValueDtoList List of values to create
     * @return Void
     */
    @PostMapping
    public ResponseEntity<Void> postAnswers(@RequestBody List<AnswerValueDto> answerValueDtoList) {
        answerService.answerCreate(answerValueDtoList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Update answer
     *
     * @param answer         UUID
     * @param answerValueDto Value to update
     * @return Void
     */
    @PutMapping("/{answer}")
    public ResponseEntity<Void> putAnswer(@PathVariable UUID answer, @RequestBody AnswerValueDto answerValueDto) {
        answerService.updateAnswer(answer, answerValueDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Delete answer by id
     *
     * @param answer UUID
     * @return Void
     */
    @DeleteMapping("/{answer}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable UUID answer) {
        answerService.deleteAnswer(answer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
