package marcos.restspringbootandjava.exception.handler;

import marcos.restspringbootandjava.exception.ExceptionResponse;
import marcos.restspringbootandjava.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                                                .details(request.getDescription(false))
                                                .message(ex.getMessage())
                                                .timestamp(new Date())
                                            .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                                                .details(request.getDescription(false))
                                                .message(ex.getMessage())
                                                .timestamp(new Date())
                                            .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}

/**
 * - Herdando da classe ResponseEntityExceptionHandler a classe filha conseguirá criar exceções expecíficas apartir de métodos.
 */