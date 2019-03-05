package org.praveenmk.microservice.learn.userdetails.exception;

public class UserServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public UserServiceException() {
        super();
    }

    public UserServiceException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public UserServiceException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
