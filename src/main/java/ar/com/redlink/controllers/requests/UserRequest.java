package ar.com.redlink.controllers.requests;

import javax.validation.constraints.Null;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserRequest {

    private Integer id;

    @NotNull
    private Integer typeId;

    @NotNull
    @Size(max = 20)
    private String identification;

    @NotNull
    @Size(max = 100)
    private String name1;

    @Size(max = 100)
    private String name2;

    @NotNull
    @Size(max = 100)
    private String lastname1;

    @Size(max = 100)
    private String lastname2;

    @Email
    @NotNull
    @Size(max = 150)
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})")
    @Size(max = 10)
    private String phone;

    @Size(max = 255)
    private String address;

    @NotNull
    private Integer city;

    @Size(max = 10)
    private String postalCode;

    @NotNull
    private Integer gender;

    @NotNull
    private Integer company;

    private Date birthday_date;

    private String picture;
}
