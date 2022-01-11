#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.struct.model.dto.user.request;

import ${package}.struct.enums.Gender;
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
