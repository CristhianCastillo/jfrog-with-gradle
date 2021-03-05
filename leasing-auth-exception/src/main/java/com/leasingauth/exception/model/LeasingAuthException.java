package com.leasingauth.exception.model;

public class LeasingAuthException extends Exception {

    private ExceptionCode error;
    private String message;

    public LeasingAuthException(ExceptionCode error, String message, Throwable cause) {
        super(message, cause);
        this.error = error;
    }

    public LeasingAuthException(ExceptionCode error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    public LeasingAuthException(Throwable cause) {
        super(cause);
    }

    public LeasingAuthException(String message) {
        super(message);
        this.message = message;
    }

    public ExceptionCode getError() {
        return error;
    }

    public void setError(ExceptionCode error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
