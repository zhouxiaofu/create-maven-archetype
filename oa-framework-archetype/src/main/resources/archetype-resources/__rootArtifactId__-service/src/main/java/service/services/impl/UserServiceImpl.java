#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.services.impl;

import ${package}.dao.mapper.UserMapper;
import ${package}.service.services.UserService;
import ${package}.struct.enums.Gender;
import ${package}.struct.model.dto.user.request.UpdateUserRequest;
import ${package}.struct.model.dto.user.response.UserResponse;
import ${package}.struct.model.po.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponse getUser(Long id) {

        User user = userMapper.getUser(id);

        return getUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest) {
        UserResponse userResponse = new UserResponse();
        {
            BeanUtils.copyProperties(updateUserRequest,userResponse);
            userResponse.setId(id);
        }
        return userResponse;
    }

    private UserResponse getUserResponse(User user){
        if(user == null){
            return null;
        }
        UserResponse userResponse = new UserResponse();
        {
            BeanUtils.copyProperties(user,userResponse);
            userResponse.setGender(Gender.valueOf(user.getGender()));
        }
        return userResponse;
    }
}
