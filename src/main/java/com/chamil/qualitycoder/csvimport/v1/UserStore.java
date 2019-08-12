package com.chamil.qualitycoder.csvimport.v1;

import com.chamil.qualitycoder.csvimport.v0.repository.User;
import com.chamil.qualitycoder.csvimport.v0.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserStore implements Store<User> {

    private UserRepository repository;

    public UserStore(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
