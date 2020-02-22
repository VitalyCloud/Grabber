package com.FileSystem;

public class FileManagerExceptions {
    public static class FileExist extends Exception {
        public FileExist(String message) {
            super(message);
        }
    }

}
