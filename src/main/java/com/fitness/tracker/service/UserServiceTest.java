package com.fitness.tracker.service;

import com.fitness.tracker.model.User;
import com.fitness.tracker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setAge(30);
        user.setWeight(70);
        user.setHeight(175);

        when(userRepository.save(user)).thenReturn(user);

        User registeredUser = userService.registerUser(user);

        assertEquals(user.getEmail(), registeredUser.getEmail());
        assertEquals(user.getName(), registeredUser.getName());
    }
}
