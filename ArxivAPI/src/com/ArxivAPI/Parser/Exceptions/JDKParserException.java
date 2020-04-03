package com.ArxivAPI.Parser.Exceptions;

public class JDKParserException extends ParseException {
    public JDKParserException(Exception ex) {
        super("Error while create Java parser", ex);
    }
}
