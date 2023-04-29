package ar.com.redlink.exceptions.models;

import lombok.Getter;

@Getter
public enum ErrorCodes {
    
    API_NOT_FOUND("USR-01","User Not Found");

    private final String code;
    private final String message;

    ErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String toString() {
        return code + ": " + message;
    }


}
