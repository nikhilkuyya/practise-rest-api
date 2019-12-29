package practise.myproman.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import practise.myproman.api.model.ErrorResponse;
import practise.myproman.api.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resouceNotFoundException(ResourceNotFoundException resourceNotFoundException,
            WebRequest webRequest) {
        return new ResponseEntity<>(new ErrorResponse().code(resourceNotFoundException.getCode())
                .message(resourceNotFoundException.getMessage()), HttpStatus.NOT_FOUND);

    }
}