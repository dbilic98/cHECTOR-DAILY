package com.cHectorBusinessResultsApp.cHECTORDAILY.exception;

import com.cHectorBusinessResultsApp.cHECTORDAILY.exception.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
<<<<<<< HEAD
    @ExceptionHandler({TaskNotFoundException.class, TaskCategoryNotFoundException.class})
=======
    @ExceptionHandler({UserNotFoundException.class})
>>>>>>> origin/login
    public ResponseEntity<Object> handleNotFoundException(Exception e, WebRequest request) {
        ErrorResponse body = new ErrorResponse(e.getMessage());
        return handleExceptionInternal(e, body,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            String defaultMessage = fieldError.getDefaultMessage();
            errors.add(defaultMessage);
        }
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
