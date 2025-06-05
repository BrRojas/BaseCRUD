package com.base.basecrud.service;

import com.base.basecrud.model.Order;
import com.base.basecrud.model.User;
import com.base.basecrud.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userServiceImp;



    @Test
    void createUser() {
        User user = new User(null,"Braian","1234",null);
        User savedUser = new User(1L,"Braian","1234",null);

        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userServiceImp.createUser(user);

        assertEquals(1L,result.getId());
        assertEquals("Braian",result.getMail());
        assertEquals("1234",result.getPassword());
        verify(userRepository).save(user);


    }

    @Test
    void findByID() {
    }

    @Test
    void upDateUser() {
    }

    @Test
    void findAllUsers() {
    }

    @Test
    void deleteUserById() {
    }
}