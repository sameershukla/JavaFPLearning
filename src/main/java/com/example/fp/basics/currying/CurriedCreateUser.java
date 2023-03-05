package com.example.fp.basics.currying;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.function.Function;

/**
 * This examples Demonstrates how to construct a Result Generically using Currying. A User class has 3 attributes firstName, lastName and email.
 * And Using createUser curried function we create User Object.
 */
public class CurriedCreateUser {

    @Setter
    @Getter
    @AllArgsConstructor
    @ToString
    static
    class User {
        private String firstName;
        private String lastName;
        private String email;
    }

    private static Function<String, Function<String, Function<String, User>>> createUser =
            first ->
                    last ->
                            email -> new User(first, last, email);


    public static void main(String[] args) {
        User user = createUser
                .apply("Brian")
                .apply("Lara")
                .apply("blara@gmail.com");
        System.out.println(user);
    }
}
