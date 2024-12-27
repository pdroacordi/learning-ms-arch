package io.acordi.mscards.application.dto;

import java.time.LocalDateTime;

public class ExceptionResponseDTO {

    private String message;
    private String errorCode;
    private LocalDateTime timestamp;

    public ExceptionResponseDTO(Builder builder) {
        this.message = builder.message;
        this.errorCode = builder.errorCode;
        this.timestamp = builder.timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static class Builder {

        private String message;
        private String errorCode;
        private LocalDateTime timestamp;

        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }
        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }
        public ExceptionResponseDTO build() {
            return new ExceptionResponseDTO(this);
        }
    }
}
