package com.myapp.userservice.api;

import com.myapp.userservice.domain.User;
import com.myapp.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RequestMapping(value = "user")
@RestController
public class UserApi {

    Logger log = Logger.getLogger(UserApi.class.getName());

    private UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> get(@PathVariable Integer userId) {
        Optional<User> user = userService.find(userId);
        if (!user.isPresent()) {
            log.warning(String.format("User not found with userId %s", userId));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(userService.list());
    }
}
