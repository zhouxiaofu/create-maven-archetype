#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.archetype.service.services;

import ${package}.archetype.struct.model.dto.user.request.UpdateUserRequest;
import ${package}.archetype.struct.model.dto.user.response.UserResponse;

public interface UserService {
    UserResponse getUser(Long id);

    UserResponse updateUser(Long id, UpdateUserRequest updateUserRequest);
}
