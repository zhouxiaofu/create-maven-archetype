#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.archetype.test.bean.services;

import ${package}.archetype.service.services.UserService;
import ${package}.archetype.test.ApplicationTests;
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
