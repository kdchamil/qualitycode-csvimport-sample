package com.chamil.qualitycoder.csvimport.v1;

import java.util.List;

public interface Validator {
    List<String> validate(Record r);
}
