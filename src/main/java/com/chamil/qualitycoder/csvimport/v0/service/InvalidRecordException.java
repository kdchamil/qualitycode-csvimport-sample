package com.chamil.qualitycoder.csvimport.v0.service;

public class InvalidRecordException extends DataImportException {
    public InvalidRecordException(String message) {
        super(message);
    }
}
