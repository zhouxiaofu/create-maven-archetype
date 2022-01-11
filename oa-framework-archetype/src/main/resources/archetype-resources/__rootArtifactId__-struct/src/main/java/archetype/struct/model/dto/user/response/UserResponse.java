#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.archetype.struct.model.dto.user.response;

import ${package}.archetype.struct.enums.Gender;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;

    private String name;

    private Gender gender;
}
