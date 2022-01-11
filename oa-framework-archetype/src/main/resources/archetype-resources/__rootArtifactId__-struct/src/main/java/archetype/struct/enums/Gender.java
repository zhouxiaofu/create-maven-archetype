#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.archetype.struct.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gender {

    NONE(0),
    MAN(1),
    WOMAN(2),
    ;

    private int code;

    public static Gender valueOf(int code) {
        for (Gender gender : Gender.values()) {
            if (code == gender.code) {
                return gender;
            }
        }
        return NONE;
    }
}
