package br.com.andriuscastro.firstapp.share.exceptions;

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

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ResourceStandardError standardError = new ResourceStandardError(
                Instant.now(), status.value(), error, sr.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }
}
