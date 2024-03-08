package marcos.restspringbootandjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {

    }
    public ResourceNotFoundException(String ex) {
        super(ex);
    }
}

/**
 * - Sempre que houver uma UnsupportedMathOperationException, retornará um status code 400.
 * -
 */