package de.vermietet.vvecrm.infrastructure.exception;

public class CounterAlreadyExistException extends RuntimeException {
    private long id;

    public CounterAlreadyExistException(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Counter with id = %d has already been registered", this.id);
    }
}
