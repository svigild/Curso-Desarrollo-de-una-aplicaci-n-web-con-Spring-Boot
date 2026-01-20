package com.openwebinars.web.exception;

import jakarta.persistence.EntityNotFoundException;

public class TaskNotFoundException extends EntityNotFoundException {

    // Tarea no encontrada.
    public TaskNotFoundException(String message) {
        super(message);
    }

    // Tarea no encontrada dado un ID.
    public TaskNotFoundException(Long id) {
        super("Task with ID: %d not found.".formatted(id));
    }
}
