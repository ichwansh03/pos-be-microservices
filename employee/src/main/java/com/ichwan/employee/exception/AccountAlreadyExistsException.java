package com.ichwan.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Account already exists")
public class AccountAlreadyExistsException extends RuntimeException{

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
