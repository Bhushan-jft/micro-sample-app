package com.myapp.userservice.service;

import com.myapp.userservice.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    @PostConstruct
    protected void init() {
            users = new ArrayList<>();
            users.add(new User(1, "Bhushan", "Uniyal"));
            users.add(new User(2, "Pankaj", "Kala"));
            users.add(new User(3, "Varun", "Sharma"));
    }

    @Override
    public Optional<User> find(int id) {
        return users
                .stream()
                .filter(user -> user.getId() == 1)
                .findFirst();
    }

    @Override
    public  List<User> list() {
        return users;
    }
}
