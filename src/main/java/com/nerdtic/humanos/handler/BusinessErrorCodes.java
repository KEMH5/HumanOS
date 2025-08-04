package com.nerdtic.humanos.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum BusinessErrorCodes {
    NO_CODE(0, NOT_IMPLEMENTED, "No code"),

    ACCOUNT_LOCKED(302, FORBIDDEN, "User account is locked"),

    ACCOUNT_DISABLED(303, FORBIDDEN, "User account is disabled"),

    INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "User password is incorrect"),

    NEW_PASSWORD_DOES_NOT_MATCH(300, BAD_REQUEST, "User password is incorrect"),

    BAD_CREDENTIALS(302, FORBIDDEN, "Login and / or password is incorrect")
    ;

    private final int code;

    private final String description;

    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
