package io.acordi.msclients.interfaces.exception;

import io.acordi.msclients.application.dto.ExceptionResponseDTO;
import io.acordi.msclients.application.exception.InvalidClientException;
import io.acordi.msclients.application.exception.InvalidStructureException;
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

    @ExceptionHandler(InvalidStructureException.class)
    public ResponseEntity<ExceptionResponseDTO> handleException(InvalidStructureException ex) {
        ExceptionResponseDTO exception = new ExceptionResponseDTO.Builder()
                .message( ex.getMessage() )
                .errorCode("INVALID_STRUCTURE")
                .timestamp( LocalDateTime.now() )
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

    @ExceptionHandler(InvalidClientException.class)
    public ResponseEntity<ExceptionResponseDTO> handleException(InvalidClientException ex) {
        ExceptionResponseDTO exception = new ExceptionResponseDTO.Builder()
                .message( ex.getMessage() )
                .errorCode("INVALID_CLIENT")
                .timestamp( LocalDateTime.now() )
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

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
