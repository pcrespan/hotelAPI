package com.api.hotelmanagementsystem.controllers.exceptions;

import com.api.hotelmanagementsystem.services.exceptions.InvalidRoomIdException;
import com.api.hotelmanagementsystem.services.exceptions.RoomOccupiedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RoomOccupiedException.class)
    public ResponseEntity<StandardError> roomOccupied(RoomOccupiedException e, HttpServletRequest request) {
        String error = "Room already occupied.";
        Instant timestamp = Instant.now();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = e.getMessage();
        String path = request.getRequestURI();
        StandardError err = new StandardError(timestamp, status.value(), error, message, path);
        return ResponseEntity.status(err.getStatus()).body(err);
    }

    @ExceptionHandler(InvalidRoomIdException.class)
    public ResponseEntity<StandardError> invalidRoomId(InvalidRoomIdException e, HttpServletRequest request) {
        String error = "No such room id.";
        Instant timestamp = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = e.getMessage();
        String path = request.getRequestURI();
        StandardError err = new StandardError(timestamp, status.value(), error, message, path);
        return ResponseEntity.status(status).body(err);
    }
}
