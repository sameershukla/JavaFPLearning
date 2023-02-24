package com.example.fp.currying;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.function.Function;

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

    public static Function<String, Function<String, Function<String, User>>> createUser =
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
