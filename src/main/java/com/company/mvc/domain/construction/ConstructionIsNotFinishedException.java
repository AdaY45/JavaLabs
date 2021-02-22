package com.company.mvc.domain.construction;

public class ConstructionIsNotFinishedException extends RuntimeException{

    public ConstructionIsNotFinishedException(String message) {
        super(message);
    }
}
