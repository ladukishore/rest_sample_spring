package com.lkd.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ldash
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid parameter")
public class BadRequestException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 211L;

    public BadRequestException(String msg) {
        super(msg);
    }
}