package com.chamil.qualitycoder.csvimport.v1;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CSVDataSource implements DataSource {

    private final Iterator<String[]> iterator;
    private int lineNo = 1;

    public CSVDataSource(InputStream stream) {
        CSVReader reader = new CSVReader(new InputStreamReader(stream));
        iterator = reader.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Record next() {
        String[] row = iterator.next();

        Map<Object, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < row.length; i++) {
            map.put(i, row[i]);
        }

        return new Record(lineNo++, map);

    }
}
