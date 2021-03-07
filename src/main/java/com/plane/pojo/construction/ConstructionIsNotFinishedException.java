package com.plane.pojo.construction;

public class ConstructionIsNotFinishedException extends RuntimeException{

    public ConstructionIsNotFinishedException(String message) {
        super(message);
    }
}
