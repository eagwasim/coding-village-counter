package de.vermietet.vvecrm.infrastructure.exception;

public class VillageAlreadyExistException extends RuntimeException {
    private long id;

    public VillageAlreadyExistException(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Village with id = %d has already been registered", this.id);
    }
}
