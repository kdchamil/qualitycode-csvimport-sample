package com.chamil.qualitycoder.csvimport.v1;

public interface Mapper<T> {
    T map(Record r);
}
