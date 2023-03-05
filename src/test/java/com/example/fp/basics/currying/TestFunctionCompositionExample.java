package com.example.fp.basics.currying;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFunctionCompositionExample {

    @Test
    public void testCreateCustomer(){
        FunctionalCompositionExample.Customer customer = FunctionalCompositionExample.createCustomer
                                                                    .apply("sameer")
                                                                    .apply("sameer.shukla@gmail.com")
                                                                    .apply("1", "29292");
        assertEquals("sameer", customer.getName());
    }

    @Test
    public void testCreateCustomerWithEmail(){
        FunctionalCompositionExample.Email email = FunctionalCompositionExample.getEmail.apply("sameer.shukla@gmail.com");
        FunctionalCompositionExample.Customer customer = FunctionalCompositionExample.createCustomerWithEmail
                .apply("sameer")
                .apply(email)
                .apply("1", "22222");
        assertEquals("sameer.shukla@gmail.com", customer.getEmail().getEmail());
    }

    @Test
    public void testCreateCustomerWithEmailAndPhone(){
        FunctionalCompositionExample.Email email = FunctionalCompositionExample.getEmail.apply("sameer.shukla@gmail.com");
        FunctionalCompositionExample.PhoneNumber phoneNumber = FunctionalCompositionExample.getPhone.apply("1", "123");
        FunctionalCompositionExample.Customer customer = FunctionalCompositionExample.createCustomerWithEmailAndPhone
                .apply("sameer")
                .apply(email)
                        .apply(phoneNumber);

        assertEquals("1", customer.getPhoneNumber().getCc());
        assertEquals("123", customer.getPhoneNumber().getPhone());
    }

}
