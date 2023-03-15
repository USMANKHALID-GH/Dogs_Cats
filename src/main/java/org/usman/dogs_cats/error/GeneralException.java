package org.usman.dogs_cats.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralException {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> GeneralExeption(MethodArgumentNotValidException ex){
        Map<String ,String> map= new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> map.put(fieldError.getField(),fieldError.getDefaultMessage()));

        return map;
 }

    @ResponseStatus(value = HttpStatus.NOT_FOUND,code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IdOrNameNotFound.class)
    public Map<String, String> notFound(IdOrNameNotFound ex){
        Map<String ,String> map= new HashMap<>();
        map.put("Error",ex.getMessage());

        return map;

    }
}
