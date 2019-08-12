package com.chamil.qualitycoder.csvimport.v1;

import java.util.Iterator;

public interface DataSource extends Iterator<Record>, Iterable<Record> {

    default Iterator<Record> iterator() {
        return this;
    }
}
