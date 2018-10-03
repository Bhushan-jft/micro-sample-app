package com.myapp.userservice.service;

import com.myapp.userservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> find(int id);

    List<User> list();
}
