#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.services;

import ${package}.struct.model.dto.user.request.UpdateUserRequest;
import ${package}.struct.model.dto.user.response.UserResponse;

public interface UserService {
    UserResponse getUser(Long id);

    UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest);
}
