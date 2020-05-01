package com.ArxivAPI.Parser.XMLObjectExceptions;

public class NodeInitException extends XMLObjectException {
    public NodeInitException() {
        super("Node is not ELEMENT_NODE");
    }
}
