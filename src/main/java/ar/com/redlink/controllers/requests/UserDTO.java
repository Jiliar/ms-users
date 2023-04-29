package ar.com.redlink.controllers.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.util.Date;

import com.github.damianwajser.validator.annotation.global.Email;
import com.github.damianwajser.validator.annotation.strings.UUID;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Schema(name="Version 1 User", description="DTO for User management")
public class UserDTO {

    @UUID(message = "Bad Format", businessCode = "ERROR_12")
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

    @Email(businessCode = "01.02.28", message = "The email does not have a valid format")
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
