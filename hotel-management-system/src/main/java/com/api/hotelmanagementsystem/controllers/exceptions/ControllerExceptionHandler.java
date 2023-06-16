package com.api.hotelmanagementsystem.controllers.exceptions;

import com.api.hotelmanagementsystem.services.exceptions.InvalidRoomIdException;
import com.api.hotelmanagementsystem.services.exceptions.RoomOccupiedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerExceptionHandler {

    private ResponseEntity<StandardError> generateStandardError(String error,
                                                                RuntimeException e,
                                                                HttpServletRequest request,
                                                                HttpStatus status) {
        Instant timestamp = Instant.now();
        String message = e.getMessage();
        String path = request.getRequestURI();
        StandardError err = new StandardError(timestamp, status.value(), error, message, path);
        return ResponseEntity.status(err.getStatus()).body(err);
    }

    @ExceptionHandler(RoomOccupiedException.class)
    public ResponseEntity<StandardError> roomOccupied(RoomOccupiedException e, HttpServletRequest request) {
        return generateStandardError("Room already occupied", e, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRoomIdException.class)
    public ResponseEntity<StandardError> invalidRoomId(InvalidRoomIdException e, HttpServletRequest request) {
        return generateStandardError("No such room id.", e, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> elementNotFound(NoSuchElementException e, HttpServletRequest request) {
        return generateStandardError("Invalid id value.", e, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> employeeActive(IllegalArgumentException e, HttpServletRequest request) {
        return generateStandardError("Employee is already active.", e, request, HttpStatus.BAD_REQUEST);
    }
}
