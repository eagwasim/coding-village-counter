package de.vermietet.vvecrm.infrastructure.exception;

public class IllegalDurationPatternException extends RuntimeException {
    private String duration;

    public IllegalDurationPatternException(String duration) {
        this.duration = duration;
    }

    @Override
    public String getMessage() {
        return String.format("%s is not a valid duration pattern", duration);
    }
}
