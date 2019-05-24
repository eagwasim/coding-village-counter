package de.vermietet.vvecrm.infrastructure.exception;

public class CounterNotFoundException extends RuntimeException {
    private long id;

    public CounterNotFoundException(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Counter with id = %d has not been registered", this.id);
    }
}
