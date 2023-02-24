package com.example.fp.currying;

import java.util.function.Function;
public class CurriedEmailComposer {

    private static Function<String, Function<String, String>> composeEmail(){
        return username -> domain -> username + "@" + domain + ".com";
    }

    private static Function<String, String> composeEmailForExample(String username){
        return composeEmail().apply(username);
    }

    public static String email(String username, String domain){
        if(username == null || domain == null){
            throw new IllegalArgumentException("Input cannot be null");
        }
        return composeEmailForExample(username)
                .apply(domain);
    }

}
