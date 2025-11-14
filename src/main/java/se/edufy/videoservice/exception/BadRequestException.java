package se.edufy.videoservice.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) { super(message); }
}