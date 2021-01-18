package br.com.andriuscastro.firstapp.share.exceptions;

public class ServiceResourceNotFoundException extends RuntimeException{
    public ServiceResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
