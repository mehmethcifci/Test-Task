package org.peoplist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionType {
    UNEXPECTED_ERROR(1000, "Unexpected Error! Please submit a report.", INTERNAL_SERVER_ERROR),
    CANDIDATES_NOT_FOUND(1001, "Candidates are not found", NOT_FOUND),
    CANDIDATE_NOT_FOUND(1002, "Candidate is not found", NOT_FOUND),
    PREVIOUS_INTERACTION_NOT_FOUND(1003, "Previous interaction is not found", NOT_FOUND);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
