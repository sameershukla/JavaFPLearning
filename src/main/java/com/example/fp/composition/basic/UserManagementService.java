package com.example.fp.composition.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.function.Function;

/**
 * This class demonstrates the SpringBoot sort of example. Generally Controller --> Service --> Repository
 * The Service class performs certain operations like validations, conversion of dto to entity then call repository
 */
public class UserManagementService {

        @Setter
        @Getter
        @ToString
        static
        class UserDTO {
            private String firstName;
            private String lastName;
            private String email;
        }

        @Setter
        @Getter
        @AllArgsConstructor
        static
        class User {
            private String firstName;
            private String lastName;
            private String email;
        }

        /**
         * Save to DB.
         *
         */
        class Repository {
            public static User save(User user) {
                //Invoke DB
                return user;
            }
        }

        /**
         * replica of
         * Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
         *         if (!violations.isEmpty()) {
         *             throw new ConstraintViolationException(violations);
         *         }
         * @param user
         * @return
         */
        private static UserDTO validateUser(UserDTO user){
            if(user.getFirstName() != null && user.getLastName() != null){
                return user;
            }
            throw new IllegalArgumentException("User FirstName & LastName is mandatory");
        }

        /**
         * Create Entity from DTO
         * @param userDto
         * @return
         */
        private static User createUserFromDto(UserDTO userDto){
            return new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        }

        /**
         * Create User in Database
         * @param userDTO
         * @return
         */
        public static User createUser(UserDTO userDTO){
            Function<UserDTO, UserDTO> pipeline = UserManagementService:: validateUser;
            return pipeline
                    .andThen(UserManagementService:: createUserFromDto)
                    .andThen(user -> Repository.save(user))
                    .apply(userDTO);
        }
    }
