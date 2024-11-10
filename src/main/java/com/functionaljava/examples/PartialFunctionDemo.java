package com.functionaljava.examples;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Demonstrates function currying and Partial Application of Functions (PAF) by creating Customer objects.
 * Uses separate functions for creating Email, PhoneNumber, and Customer to illustrate flexible parameter handling.
 */
public class PartialFunctionDemo {

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
        private String cc;     // Country code
        private String phone;  // Phone number
    }

    @Getter
    @AllArgsConstructor
    @ToString
    static class Customer {
        private String name;
        private Email email;
        private PhoneNumber phoneNumber;
    }

    // Function to create an Email object
    public static Function<String, Email> getEmail = email -> new Email(email);

    // BiFunction to create a PhoneNumber object
    public static BiFunction<String, String, PhoneNumber> getPhone = (cc, number) -> new PhoneNumber(cc, number);

    /**
     * Fully Curried Function to create a Customer.
     * Takes the name, email, country code, and phone number, and returns a new Customer object.
     */
    public static Function<String, Function<String, BiFunction<String, String, Customer>>> createCustomer =
            name -> email -> (cc, phoneNumber) -> new Customer(name, getEmail.apply(email), getPhone.apply(cc, phoneNumber));

    /**
     * Partially Applied Function (PAF) to create a Customer with a preset Email object.
     * Takes the name and an Email object, then returns a function that takes country code and phone number.
     */
    public static Function<String, Function<Email, BiFunction<String, String, Customer>>> createCustomerWithEmail =
            name -> email -> (cc, phoneNumber) -> new Customer(name, email, getPhone.apply(cc, phoneNumber));

    /**
     * Partially Applied Function (PAF) that accepts name, Email, and PhoneNumber.
     * Demonstrates currying and PAF by applying parameters step-by-step to create a Customer.
     */
    public static Function<String, Function<Email, Function<PhoneNumber, Customer>>> createCustomerWithEmailAndPhone =
            name -> email -> phoneNumber -> new Customer(name, email, phoneNumber);

    public static void main(String[] args) {
        // Fully Curried Customer Creation
        Customer fullyCurriedCustomer = createCustomer
                .apply("Alice")                  // Name
                .apply("alice@example.com")      // Email
                .apply("1", "1234567890");       // Country code and phone number
        System.out.println("Fully Curried Customer: " + fullyCurriedCustomer);

        // Partially Applied Customer Creation with Email
        Email email = new Email("bob@example.com");
        Customer partialCustomerWithEmail = createCustomerWithEmail
                .apply("Bob")                    // Name
                .apply(email)                    // Predefined Email object
                .apply("44", "0987654321");      // Country code and phone number
        System.out.println("Partial Customer with Email: " + partialCustomerWithEmail);

        // Partially Applied Customer Creation with Email and PhoneNumber
        PhoneNumber phoneNumber = new PhoneNumber("91", "9876543210");
        Customer partialCustomerWithEmailAndPhone = createCustomerWithEmailAndPhone
                .apply("Charlie")                // Name
                .apply(email)                    // Predefined Email object
                .apply(phoneNumber);             // Predefined PhoneNumber object
        System.out.println("Partial Customer with Email and Phone: " + partialCustomerWithEmailAndPhone);
    }
}
