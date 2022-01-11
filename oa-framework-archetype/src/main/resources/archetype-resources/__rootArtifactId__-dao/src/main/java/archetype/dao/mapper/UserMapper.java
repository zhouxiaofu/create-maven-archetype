#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.archetype.dao.mapper;

import ${package}.archetype.struct.model.po.User;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 模拟DB操作
 */
@Component
public class UserMapper {
    public User getUser(Long id) {
        User user = new User();
        {
            user.setId(id);
            user.setName("user:" + id);
            user.setGender(Long.valueOf(id % 3).intValue());
            user.setCreateTime(new Date());
        }
        return user;
    }
}
