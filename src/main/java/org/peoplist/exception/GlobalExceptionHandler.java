package org.peoplist.exception;

import org.peoplist.exception.custom.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.peoplist.exception.ExceptionType.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseBody
    @ExceptionHandler(CandidatesNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCandidatesNotFoundException(CandidatesNotFoundException exception) {
        log.warn("Candidates are not found. {}", exception.getMessage());
        return createExceptionInfoResponse(CANDIDATES_NOT_FOUND);
    }
    @ResponseBody
    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCandidateNotFoundException(CandidateNotFoundException exception) {
        log.warn("Candidate is not found. {}", exception.getMessage());
        return createExceptionInfoResponse(CANDIDATE_NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(InteractionNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlePreviousInteractionNotFoundException(InteractionNotFoundException exception) {
        log.warn("Previous interaction is not found. {}", exception.getMessage());
        return createExceptionInfoResponse(PREVIOUS_INTERACTION_NOT_FOUND);
    }

    private ResponseEntity<ExceptionResponse> createExceptionInfoResponse(ExceptionType exceptionType) {
        return new ResponseEntity<>(ExceptionResponse.builder()
                .exceptionCode(exceptionType.getCode())
                .customMessage(exceptionType.getMessage())
                .httpStatus(exceptionType.getHttpStatus().value())
                .build(), exceptionType.getHttpStatus());
    }
}
