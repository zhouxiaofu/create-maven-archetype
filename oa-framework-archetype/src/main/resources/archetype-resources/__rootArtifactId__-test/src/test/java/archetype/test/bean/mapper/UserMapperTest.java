#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.archetype.test.bean.mapper;

import ${package}.archetype.dao.mapper.UserMapper;
import ${package}.archetype.test.ApplicationTests;
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
