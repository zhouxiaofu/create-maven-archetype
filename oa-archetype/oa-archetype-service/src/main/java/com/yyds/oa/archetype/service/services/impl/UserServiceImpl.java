package com.yyds.oa.archetype.service.services.impl;

import com.yyds.oa.archetype.dao.mapper.UserMapper;
import com.yyds.oa.archetype.service.services.UserService;
import com.yyds.oa.archetype.struct.enums.Gender;
import com.yyds.oa.archetype.struct.model.dto.user.request.UpdateUserRequest;
import com.yyds.oa.archetype.struct.model.dto.user.response.UserResponse;
import com.yyds.oa.archetype.struct.model.po.User;
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
