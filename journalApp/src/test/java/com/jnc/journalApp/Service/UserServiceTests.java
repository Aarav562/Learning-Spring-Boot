package com.jnc.journalApp.Service;

import com.jnc.journalApp.Entity.User;
import com.jnc.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "Messi",
            "Vipul",
            "Ram"
    })
    public void testFindByUsername(String user){
        assertNotNull(userRepository.findByUsername(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,10",
            "3,3,9"
    })
    public void testing(int a, int b, int expected){
        assertEquals(expected,a+b);
    }
}
