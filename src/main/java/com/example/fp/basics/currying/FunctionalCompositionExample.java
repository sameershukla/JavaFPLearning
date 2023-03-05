package com.example.fp.basics.currying;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * The Function Curring and Partial Function example. Customer is created with Email and PhoneNumber.
 */
public class FunctionalCompositionExample {

    @Getter
    @AllArgsConstructor
    @ToString
    static class Email {
        private String email;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    static class PhoneNumber {
        private String cc;
        private String phone;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    static
    class Customer {
        private String name;
        private Email email;
        private PhoneNumber phoneNumber;
    }

    /**
     * Suppose that we have an email service that returns an email object, and we want to use a function currying approach
     * to create a Customer class that stores a name, email, and phone number.
     */
    public static Function<String, Email> getEmail = (email) -> new Email(email);

    /**
     * Suppose that we have an PhoneNumber service that returns an PhoneNumber object, and we want to use a function currying approach
     * to create a Customer class that stores a name, email, and phone number.
     */
    public static BiFunction<String, String, PhoneNumber> getPhone = (cc, number) -> new PhoneNumber(cc, number);


    /**
     * We can create a curried function to generate a Customer object by applying a set of functions that extract the customer's name, email, and phone number.
     * Once all the required functions have been applied, the curried function will return a new Customer object with the specified properties.
     */
    public static Function<String, Function<String, BiFunction<String, String, Customer>>> createCustomer =
            name ->
                    email ->
                            (cc, phoneNumber) -> new Customer(name,
                                    getEmail.apply(email),
                                    getPhone.apply(cc, phoneNumber));


    /**
     * PAF example where Email Object is supplied with Customer Name and Phone Number (Country Code and a Number)
     */
    public static Function<String, Function<Email, BiFunction<String, String, Customer>>> createCustomerWithEmail =
            name ->
                    email
                            -> (cc, phoneNumber) -> new Customer(name, email, getPhone.apply(cc, phoneNumber));


    /**
     * Suppose that we want to create a Customer object using a function currying approach in a PAF (Partial Application of Functions) example.
     * The curried function takes the customer's name as input and returns a new function that takes an email object and a phone number object as inputs.
     * Once the email and phone number objects have been supplied, the curried function will return a new Customer object with the specified properties.
     */
    public static Function<String, Function<Email, Function<PhoneNumber, Customer>>> createCustomerWithEmailAndPhone =
            name ->
                    email
                            -> phoneNumber -> new Customer(name, email, phoneNumber);


}
