package com.Network.Parser;

public class ParserException   {
    public static class RequestError extends Exception {
        RequestError(String message) {
            super(message);
        }
    }
}
