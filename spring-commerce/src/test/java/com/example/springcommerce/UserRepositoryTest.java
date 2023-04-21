package com.example.springcommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.springcommerce.model.User;
import com.example.springcommerce.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;

    @Test
    public void testFindUserByUsername() {
        String username = "testUser";
        User user = new User();
        user.setId(1);
        user.setUsername(username);
        when(userRepository.findUserByUsername(username)).thenReturn(Optional.of(user));

        Optional<User> result = userRepository.findUserByUsername(username);

        assertEquals(result.isPresent(), true);
        assertEquals(result.get().getId(), user.getId());
        assertEquals(result.get().getUsername(), user.getUsername());
    }
}

