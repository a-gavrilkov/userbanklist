package com.example.userbanklist.exception;

public class IdNotFoundException extends RuntimeException {
    private Long id;
    private Class type;

    public IdNotFoundException(Long id, Class type) {
        this.id = id;
        this.type = type;
    }

    public IdNotFoundException(Throwable cause, Long id, Class type) {
        super(cause);
        this.id = id;
        this.type = type;
    }

    @Override
    public String getMessage() {
        return String.format("Class: %s, ID: %d\n%s", type, id, super.getMessage());
    }
}
