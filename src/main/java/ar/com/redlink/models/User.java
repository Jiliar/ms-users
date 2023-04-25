package ar.com.redlink.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {

    private Integer id;
    private UserTypeId typeId;
    private String identification;
    private String name1;
    private String name2;
    private String lastname1;
    private String lastname2;
    private String email;
    private String phone;
    private String address;
    private Integer city;
    private Integer company;
    private String postalCode;
    private Gender gender;
    private String birthday_date;
    private String picture;

}
