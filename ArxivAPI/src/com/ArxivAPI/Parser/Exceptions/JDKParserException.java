package com.ArxivAPI.Parser.Exceptions;

public class JDKParserException extends Exception {
    public JDKParserException(Exception ex) {
        super("Error while create Java parser", ex);
    }
}
