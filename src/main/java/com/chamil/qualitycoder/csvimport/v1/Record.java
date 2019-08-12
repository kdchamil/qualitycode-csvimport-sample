package com.chamil.qualitycoder.csvimport.v1;

import java.util.HashMap;
import java.util.Map;

public class Record {

    private int id;
    private Map<Object, String> entries = new HashMap<>();

    public Record(int id, Map<Object, String> entries){
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
