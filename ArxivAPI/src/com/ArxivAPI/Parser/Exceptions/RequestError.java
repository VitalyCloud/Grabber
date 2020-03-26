package com.ArxivAPI.Parser.Exceptions;

public class RequestError extends Exception {
    public RequestError(String msg) {
        super("Error in request:\n" + msg);
    }
}
