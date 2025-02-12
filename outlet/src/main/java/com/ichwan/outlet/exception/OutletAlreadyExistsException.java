package com.ichwan.outlet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Outlet already exists")
public class OutletAlreadyExistsException extends RuntimeException {

    public OutletAlreadyExistsException(String message) {
        super(message);
    }
}
