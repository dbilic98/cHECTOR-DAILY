package com.cHectorBusinessResultsApp.cHECTORDAILY.exception;

import com.cHectorBusinessResultsApp.cHECTORDAILY.exception.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({TaskNotFoundException.class, TaskCategoryNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception e, WebRequest request) {
        ErrorResponse body = new ErrorResponse(e.getMessage());
        return handleExceptionInternal(e, body,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
