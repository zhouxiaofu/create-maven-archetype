package com.yyds.oa.archetype.test.bean.mapper;

import com.yyds.oa.archetype.dao.mapper.UserMapper;
import com.yyds.oa.archetype.test.ApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApplicationTests.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUser() {
        for (long i = 1; i < 10; i++) {
            System.out.println(userMapper.getUser(i));
        }
    }
}
