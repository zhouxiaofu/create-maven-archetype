package com.yyds.oa.archetype.test.bean.services;

import com.yyds.oa.archetype.service.services.UserService;
import com.yyds.oa.archetype.test.ApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApplicationTests.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        for (long i = 1; i < 10; i++) {
            System.out.println(userService.getUser(i));
        }
    }
}
