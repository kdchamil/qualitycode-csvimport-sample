package com.chamil.qualitycoder.csvimport.v1;


import com.chamil.qualitycoder.csvimport.v0.repository.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User> {
    @Override
    public User map(Record r) {

        return new User(r.get(0), r.get(1), Integer.parseInt(r.get(2)));
    }

}
