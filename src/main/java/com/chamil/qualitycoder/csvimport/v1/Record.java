package com.chamil.qualitycoder.csvimport.v1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Record {

    private final int id;
    private final Map<Object, String> entries = new ConcurrentHashMap<>();

    public Record(int id, Map<Object, String> entries){
        this.id = id;
        this.entries.putAll(entries);
    }

    public int getId(){
        return id;
    }

    public String get(Object key){
        return entries.get(key);
    }

    public int size() {
        return entries.size();
    }
}
