package io.acordi.mscards.interfaces.exception;

import io.acordi.mscards.application.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // ---------
    //
    // Handling Custom Exceptions
    //
    // --------




    // ---------
    //
    // Handling Standard Exceptions
    //
    // --------

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResponseDTO> handleException(MissingServletRequestParameterException ex) {
        ExceptionResponseDTO exception = new ExceptionResponseDTO.Builder()
                .message( ex.getMessage() )
                .errorCode("INVALID_PARAMETER")
                .timestamp( LocalDateTime.now() )
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

}
