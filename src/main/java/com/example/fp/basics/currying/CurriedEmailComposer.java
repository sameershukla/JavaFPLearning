package com.example.fp.basics.currying;

import java.util.Optional;
import java.util.function.Function;

public class CurriedEmailComposer {

    private static Function<String, Function<String, String>> composeEmail() {
        return username -> domain -> username + "@" + domain + ".com";
    }

    private static Function<String, String> composeEmailForExample(String username) {
        return composeEmail().apply(username);
    }

    public static Optional<String> email(String username, String domain) {
        if (username == null || domain == null) {
            return Optional.empty();
        }
        return Optional.of(composeEmailForExample(username)
                .apply(domain));
    }

}
