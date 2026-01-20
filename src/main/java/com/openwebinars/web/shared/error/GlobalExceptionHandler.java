package com.openwebinars.web.shared.error;

import com.openwebinars.web.exception.EmptyTaskListException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Captura las excepcionesde tipo EmptyTaskListException
    @ExceptionHandler(EmptyTaskListException.class)
    public String emptyTaskList(EmptyTaskListException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("emptyListError", true);
        return "redirect:/";
    }
}
