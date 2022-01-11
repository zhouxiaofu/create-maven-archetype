package com.yyds.oa.archetype.service.services;

import com.yyds.oa.archetype.struct.model.dto.user.request.UpdateUserRequest;
import com.yyds.oa.archetype.struct.model.dto.user.response.UserResponse;

public interface UserService {
    UserResponse getUser(Long id);

    UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest);
}
