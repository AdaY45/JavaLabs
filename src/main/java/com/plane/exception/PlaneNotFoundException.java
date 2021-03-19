package com.plane.exception;

import java.util.NoSuchElementException;

public class PlaneNotFoundException extends NoSuchElementException {
    public PlaneNotFoundException() {
        super("There is no such plane or planes.");
    }
}
