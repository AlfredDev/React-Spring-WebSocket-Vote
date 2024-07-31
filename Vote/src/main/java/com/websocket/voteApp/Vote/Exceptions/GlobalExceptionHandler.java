package com.websocket.voteApp.Vote.Exceptions;

import com.websocket.voteApp.Vote.Config.Security.DTO.ErrorResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*==========================================   BAD REQUEST   ==========================================*/
    @ExceptionHandler({BadRequestException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception ex, WebRequest webRequest) {
        String message;
        if (ex instanceof BadRequestException) {
            message = ex.getMessage();
        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) ex;
            message = validException.getBindingResult().getFieldError().getDefaultMessage();
        } else {
            message = "Bad Request Exception";
        }
        ErrorResponse response = ErrorResponse
                .builder()
                .dateTime(LocalDateTime.now())
                .message(message)
                .url(webRequest.getDescription(false).replace("uri=", ""))
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
