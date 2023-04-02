package org.peoplist.exception.custom;

public class CandidateNotFoundException extends RuntimeException{

    public CandidateNotFoundException(String message) {
        super(message);
    }
}
