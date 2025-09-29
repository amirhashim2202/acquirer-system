package com.example.acquirersystem.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        // Log the error for internal tracking
        // You can use a logger like log.error("Unexpected error", ex);
        model.addAttribute("message", "An unexpected error occurred.");
        return "error"; // This maps to error.html
    }
}
