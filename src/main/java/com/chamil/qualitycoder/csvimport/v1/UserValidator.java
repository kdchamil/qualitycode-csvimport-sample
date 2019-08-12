package com.chamil.qualitycoder.csvimport.v1;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator implements Validator {

    @Override
    public List<String> validate(Record r) {
        List<String> errors = new ArrayList<>();

        if(r.size() != 3){
            errors.add("Expected 3 columns, found = " + r.size());
        }else {
            if (r.get(0).length() == 0) {
                errors.add("Name cannot be empty.");
            }
            if(!NumberUtils.isDigits(r.get(2))){
                errors.add("Age must be a number.");
            }
        }

        return errors;
    }
}
