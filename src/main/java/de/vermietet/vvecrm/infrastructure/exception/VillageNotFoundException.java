package de.vermietet.vvecrm.infrastructure.exception;

public class VillageNotFoundException extends RuntimeException {
    private long id;

    public VillageNotFoundException(long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Village with id = %d has not been registered", this.id);
    }
}
