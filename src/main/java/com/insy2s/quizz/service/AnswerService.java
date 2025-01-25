package com.insy2s.quizz.service;

import com.insy2s.quizz.domain.Answer;
import com.insy2s.quizz.dto.answer.AnswerValueDto;
import com.insy2s.quizz.exception.AnswerAlreadyExistException;
import com.insy2s.quizz.exception.AnswerNotFoundException;
import com.insy2s.quizz.repository.IAnswerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final IAnswerRepository answerRepository;

    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    public List<AnswerValueDto> getAnswersValues() {
        List<AnswerValueDto> values = new ArrayList<>();
        for (Answer answer : answerRepository.findAll()) {
            values.add(new AnswerValueDto(answer.getValue()));
        }
        return values;
    }

    private Answer getById(UUID answer) {
        Optional<Answer> answerOptional = answerRepository.findById(answer);
        if (answerOptional.isPresent()) {
            return answerOptional.get();
        }
        throw new AnswerNotFoundException("Answer not found.");
    }

    public void answerCreate(List<AnswerValueDto> answerValueDtoList) {
        for (AnswerValueDto answerValueDto : answerValueDtoList) {
            if (!answerRepository.existsByValue(answerValueDto.getValue())) {
                Answer answer = new Answer();
                answer.setValue(answerValueDto.getValue());
                this.createAnswer(answer);
            }
        }
    }

    private void createAnswer(@Valid Answer answer) {
        Optional<Answer> answerOptional = answerRepository.findByValueIgnoreCase(answer.getValue());
        answerOptional.ifPresentOrElse(
                exist -> {throw new AnswerAlreadyExistException("Answer already exist.");},
                () -> answerRepository.save(answer)
        );
    }

    public void updateAnswer(UUID answer, AnswerValueDto answerValueDto) {
        Answer answerToUpdate = this.getById(answer);
        try {
            answerToUpdate.setValue(answerValueDto.getValue());
            answerRepository.save(answerToUpdate);
        } catch (Exception e) {
            throw new AnswerAlreadyExistException("Answer already exist.");
        }
    }

    public void deleteAnswer(UUID answer) {
        answerRepository.delete(this.getById(answer));
    }
}
