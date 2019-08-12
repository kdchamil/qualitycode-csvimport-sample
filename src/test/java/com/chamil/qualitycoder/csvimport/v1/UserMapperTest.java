package com.chamil.qualitycoder.csvimport.v1;

import com.chamil.qualitycoder.csvimport.v0.repository.User;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class UserMapperTest {

    @Test
    public void should_MapToUser_when_CorrectRecordIsGiven(){
        int id = 0;
        Map<Object, String> map = new HashMap<>();
        map.put(0, "ABC");
        map.put(1, "XYZ");
        map.put(2, "35");

        Record r = new Record(id, map);

        UserMapper mapper = new UserMapper();
        User user = mapper.map(r);

        User expecteUser = new User("ABC", "XYZ", 35);
        assertThat(EqualsBuilder.reflectionEquals(user, expecteUser), is(true));
    }
}
