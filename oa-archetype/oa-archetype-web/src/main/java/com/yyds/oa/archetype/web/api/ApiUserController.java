package com.yyds.oa.archetype.web.api;

import com.yyds.oa.archetype.service.services.UserService;
import com.yyds.oa.archetype.struct.model.dto.user.request.UpdateUserRequest;
import com.yyds.oa.archetype.struct.model.dto.user.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/archetype/user")
public class ApiUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}/update")
    public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
        return userService.updateUser(id, updateUserRequest);
    }

}
