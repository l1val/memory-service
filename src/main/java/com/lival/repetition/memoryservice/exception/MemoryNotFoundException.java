package com.lival.repetition.memoryservice.exception;

public class MemoryNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Memory with id=[%s] not found";

    public MemoryNotFoundException(Long messageId) {
        super(String.format(MESSAGE, messageId));
    }
}