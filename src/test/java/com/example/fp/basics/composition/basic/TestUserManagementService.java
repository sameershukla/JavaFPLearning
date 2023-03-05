package com.example.fp.basics.composition.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserManagementService {

    @Test
    public void testCreateUser() {
        UserManagementService.UserDTO userDTO = new UserManagementService.UserDTO();
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setEmail("john.doe@example.com");

        UserManagementService.User user = UserManagementService.createUser(userDTO);
        assertNotNull(user);
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void testCreateUserFailed(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            UserManagementService.UserDTO userDTO = new UserManagementService.UserDTO();
            userDTO.setFirstName(null);
            userDTO.setLastName("Doe");
            UserManagementService.createUser(userDTO);
        });
        assertTrue(exception.getMessage().contains("User FirstName & LastName is mandatory"));
    }
}
