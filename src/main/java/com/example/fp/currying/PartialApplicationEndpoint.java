package com.example.fp.currying;

import com.example.fp.types.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.function.Function;

/**
 * Example demonstrates pragmatic example of saving the data to the DB by consolidating responses from 3 different REST services
 */
public class PartialApplicationEndpoint {

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

    class Repository {
        public static List<User> save(List<User> user) {
            return user;
        }
    }

    /**
     * Function takes No Input and Return User as Unit is no value and returned Hard-coded User Object.
     */
    private static Function<Unit, User> serviceOne = f -> new User("John", "Doe", "jdoe@gmail.com");

    /**
     * Function takes No Input and Return User as Unit is no value and returned Hard-coded User Object.
     */
    private static Function<Unit, User> serviceTwo = f -> new User("David", "Priest", "dbp@gmail.com");

    /**
     * Function takes No Input and Return User as Unit is no value and returned Hard-coded User Object.
     */
    private static Function<Unit, User> serviceThree = f -> new User("Mick", "Fitzpatrick", "mick@gmail.com");

    private static Function<Unit, Function<Unit, Function<Unit, List<User>>>> getUsers =
            one -> two -> three -> List.of(serviceOne.apply(one), serviceTwo.apply(one), serviceThree.apply(one));

    public static List<User> createUser() {
        return Repository.save(getUsers.apply(Unit.unit()).apply(Unit.unit()).apply(Unit.unit()));
    }
}
