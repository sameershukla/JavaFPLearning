package com.example.fp.currying;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Let's make it more complex, add some unreasonable params
 */
@RestController
@RequestMapping("/api")
public class CurriedRestController {

    class User {
        private long id;
        private String name;
        private String phone;

        private String email;

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        // Return all users
        return new ArrayList<>();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        // Return user with the given ID
        return new User();
    }

    private Function<Long, User> getUserById = id -> new User();

    @GetMapping("/users/name/{name}")
    public List<User> getUsersByName(@PathVariable("name") String name) {
        // Return all users with the given nam
        return new ArrayList<>();
    }

    private Function<String, List<User>> getUsersByName = name -> new ArrayList<>();

    @GetMapping("/users/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        // Return user with the given email
        return new User();
    }

    private Function<String, User> getUserByEmail = email -> new User();

    @GetMapping("/users/phone/{phone}")
    public User getUserByPhone(@PathVariable("phone") String phone) {
        // Return user with the given phone
        return new User();
    }

    private Function<String, User> getUserByPhone = phone -> new User();

    @GetMapping("/users/{id}/name")
    public String getUserName(@PathVariable("id") Long id) {
        return getUserById.apply(id).getName();
    }

    @GetMapping("/users/{id}/email")
    public String getUserEmail(@PathVariable("id") Long id) {
        return getUserById.apply(id).getEmail();
    }

    @GetMapping("/users/{id}/phone")
    public String getUserPhone(@PathVariable("id") Long id) {
        return getUserById.apply(id).getPhone();
    }
}
