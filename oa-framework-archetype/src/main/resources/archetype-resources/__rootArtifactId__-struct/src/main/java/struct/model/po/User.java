#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.struct.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long id;

    private String name;

    private Integer gender;

    private Date createTime;
}
