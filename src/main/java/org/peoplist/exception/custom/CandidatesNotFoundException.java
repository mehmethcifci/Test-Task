package org.peoplist.exception.custom;

public class CandidatesNotFoundException extends RuntimeException{

    public CandidatesNotFoundException(String message) {
        super(message);
    }
}