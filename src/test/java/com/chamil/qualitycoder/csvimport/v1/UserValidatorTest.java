package com.chamil.qualitycoder.csvimport.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class UserValidatorTest {

    @Test
    public void should_ReturnError_when_NoOfColumnsAreNotEqualsTo3(){

        UserValidator validator = new UserValidator();
        int id = 0;
        Map<Object, String> map = new HashMap<>();

        Record r = new Record(id, map);

        List<String> errors = validator.validate(r);
        assertThat(errors, hasSize(1));
        assertThat(errors.get(0), is("Expected 3 columns, found = 0"));
    }

    @Test
    public void should_ReturnError_when_NameIsEmpty(){

        UserValidator validator = new UserValidator();
        int id = 0;
        Map<Object, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "xyz address");
        map.put(2, "53");

        Record r = new Record(id, map);

        List<String> errors = validator.validate(r);
        assertThat(errors, hasSize(1));
        assertThat(errors.get(0), is("Name cannot be empty."));
    }

    @Test
    public void should_ReturnError_when_AgeIsNonNumeric(){

        UserValidator validator = new UserValidator();
        int id = 0;
        Map<Object, String> map = new HashMap<>();
        map.put(0, "xyz");
        map.put(1, "xyz address");
        map.put(2, "nonDigit");

        Record r = new Record(id, map);

        List<String> errors = validator.validate(r);
        assertThat(errors, hasSize(1));
        assertThat(errors.get(0), is("Age must be a number."));
    }
}
