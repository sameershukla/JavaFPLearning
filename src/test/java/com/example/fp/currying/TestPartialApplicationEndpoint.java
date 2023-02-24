package com.example.fp.currying;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPartialApplicationEndpoint {

    @Test
    public void testCreateUser(){
        List<PartialApplicationEndpoint.User> users = PartialApplicationEndpoint.createUser();
        assertTrue(users.size() == 3);
    }
}
