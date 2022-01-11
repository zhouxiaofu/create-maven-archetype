package com.yyds.oa.archetype.struct.model.dto.user.response;

import com.yyds.oa.archetype.struct.enums.Gender;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;

    private String name;

    private Gender gender;
}
