package com.yyds.oa.archetype.struct.model.dto.user.request;

import com.yyds.oa.archetype.struct.enums.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateUserRequest {

    @NotNull
    @NotBlank
    @Size(max = 32)
    private String name;

    @NotNull
    private Gender gender;
}
