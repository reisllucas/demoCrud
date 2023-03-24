package br.com.demo.crud.crudbackend.domain.exceptions;


/**
 * Business exception used to check business conditions
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }

}
