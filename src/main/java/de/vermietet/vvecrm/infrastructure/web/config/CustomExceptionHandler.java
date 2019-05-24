package de.vermietet.vvecrm.infrastructure.web.config;

import de.vermietet.vvecrm.infrastructure.exception.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlatformErrorResponse {
        String message;
    }

    @ResponseBody
    @ExceptionHandler(CounterAlreadyExistException.class)
    public ResponseEntity<?> handlePlatformException(CounterAlreadyExistException e) {
        return new ResponseEntity<>(new PlatformErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
    }


    @ResponseBody
    @ExceptionHandler(IllegalDurationPatternException.class)
    public ResponseEntity<?> handlePlatformException(IllegalDurationPatternException e) {
        return new ResponseEntity<>(new PlatformErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(CounterNotFoundException.class)
    public ResponseEntity<?> handlePlatformException(CounterNotFoundException e) {
        return new ResponseEntity<>(new PlatformErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(VillageAlreadyExistException.class)
    public ResponseEntity<?> handlePlatformException(VillageAlreadyExistException e) {
        return new ResponseEntity<>(new PlatformErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(VillageNotFoundException.class)
    public ResponseEntity<?> handlePlatformException(VillageNotFoundException e) {
        return new ResponseEntity<>(new PlatformErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlePlatformException(Exception e) {
        return new ResponseEntity<>(new PlatformErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
