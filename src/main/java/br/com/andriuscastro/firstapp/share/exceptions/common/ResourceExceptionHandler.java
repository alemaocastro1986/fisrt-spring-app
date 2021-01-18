package br.com.andriuscastro.firstapp.share.exceptions.common;

import br.com.andriuscastro.firstapp.share.exceptions.DataBaseException;
import br.com.andriuscastro.firstapp.share.exceptions.ServiceResourceNotFoundException;
import br.com.andriuscastro.firstapp.share.exceptions.common.ResourceStandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ServiceResourceNotFoundException.class )
    public ResponseEntity<ResourceStandardError> resourceNotFound(ServiceResourceNotFoundException sr,
                                                                  HttpServletRequest request){

        String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ResourceStandardError standardError = new ResourceStandardError(
                Instant.now(), status.value(), error, sr.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DataBaseException.class )
    public ResponseEntity<ResourceStandardError> database(DataBaseException dbe,
                                                                  HttpServletRequest request){

        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ResourceStandardError standardError = new ResourceStandardError(
                Instant.now(), status.value(), error, dbe.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }
}
