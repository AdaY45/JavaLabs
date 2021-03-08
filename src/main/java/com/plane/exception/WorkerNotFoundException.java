package com.plane.exception;

import java.util.NoSuchElementException;

public class WorkerNotFoundException extends NoSuchElementException {

    public WorkerNotFoundException() {
        super("There is no such worker");
    }
}
