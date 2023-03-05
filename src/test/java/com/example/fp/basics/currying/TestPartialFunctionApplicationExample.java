package com.example.fp.basics.currying;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPartialFunctionApplicationExample {

    @Test
    public void testCreateCustomer(){
        PartialFunctionApplicationExample.Customer customer = PartialFunctionApplicationExample.createCustomer
                                                                    .apply("sameer")
                                                                    .apply("sameer.shukla@gmail.com")
                                                                    .apply("1", "29292");
        assertEquals("sameer", customer.getName());
    }

    @Test
    public void testCreateCustomerWithEmail(){
        PartialFunctionApplicationExample.Email email = PartialFunctionApplicationExample.getEmail.apply("sameer.shukla@gmail.com");
        PartialFunctionApplicationExample.Customer customer = PartialFunctionApplicationExample.createCustomerWithEmail
                .apply("sameer")
                .apply(email)
                .apply("1", "22222");
        assertEquals("sameer.shukla@gmail.com", customer.getEmail().getEmail());
    }

    @Test
    public void testCreateCustomerWithEmailAndPhone(){
        PartialFunctionApplicationExample.Email email = PartialFunctionApplicationExample.getEmail.apply("sameer.shukla@gmail.com");
        PartialFunctionApplicationExample.PhoneNumber phoneNumber = PartialFunctionApplicationExample.getPhone.apply("1", "123");
        PartialFunctionApplicationExample.Customer customer = PartialFunctionApplicationExample.createCustomerWithEmailAndPhone
                .apply("sameer")
                .apply(email)
                        .apply(phoneNumber);

        assertEquals("1", customer.getPhoneNumber().getCc());
        assertEquals("123", customer.getPhoneNumber().getPhone());
    }

}
