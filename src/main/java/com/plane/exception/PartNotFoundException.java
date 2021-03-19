package com.plane.exception;

import java.util.NoSuchElementException;

public class PartNotFoundException extends NoSuchElementException {
    public PartNotFoundException() {
        super("There is no such plane part or parts.");
    }
}
