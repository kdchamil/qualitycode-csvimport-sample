package com.chamil.qualitycoder.csvimport.v0.service;

import java.io.IOException;

public class DataImportException extends RuntimeException {

    public DataImportException(String message){
        super(message);
    }

    public DataImportException(String message, IOException e) {
        super(message, e);
    }

}
