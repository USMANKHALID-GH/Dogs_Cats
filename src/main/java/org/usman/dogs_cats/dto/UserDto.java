package org.usman.dogs_cats.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.usman.dogs_cats.model.Address;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements   BaseDto{

    private String firstName;
    private String secondName;
    private  String password;
    private String userEmail;
    private int userAge;
    private Integer userNumber;
    private Address address;
//    private Set<Role> role;
}
