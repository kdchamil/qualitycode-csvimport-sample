package com.chamil.qualitycoder.csvimport.v1;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CSVDataSource implements DataSource {

    private final CSVReader reader;
    private final Iterator<String[]> iterator;
    private int lineNo = 1;
    private String[] current;

    public CSVDataSource(InputStream stream) {
        reader = new CSVReader(new InputStreamReader(stream));
        iterator = reader.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Record next() {
        String[] row = iterator.next();

        Map<Object, String> map = new HashMap<>();
        for(int i = 0; i < row.length; i++){
            map.put(i, row[i]);
        }

        return new Record(lineNo++, map);

    }
}
