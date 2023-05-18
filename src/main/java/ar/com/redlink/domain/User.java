package ar.com.redlink.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

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
