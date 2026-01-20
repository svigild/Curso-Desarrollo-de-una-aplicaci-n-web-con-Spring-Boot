package com.openwebinars.web.exception;

/**
 * Gestionar error cuando no hay tareas.
 */
public class EmptyTaskListException extends RuntimeException {

    public EmptyTaskListException() {
        super();
    }
}
