package com.ArxivAPI.Parser.Exceptions;

public class ParseException extends RuntimeException {
    public ParseException(String message, Exception ex) {
        super(message, ex);
    }
    public ParseException(String message) {
        super(message);
    }
}
