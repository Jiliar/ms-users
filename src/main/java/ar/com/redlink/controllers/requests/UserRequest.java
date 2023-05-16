package ar.com.redlink.controllers.requests;

import javax.validation.constraints.Pattern;
import java.util.Date;

import com.github.damianwajser.validator.annotation.global.Email;
import com.github.damianwajser.validator.annotation.global.NotNull;
import com.github.damianwajser.validator.annotation.global.NotEmpty;
import com.github.damianwajser.validator.annotation.global.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="Version 1 User", description="DTO for User Request")

public class UserRequest {

    @NotNull(message="{validation.user.type_id.not_null.desc}",  businessCode = "{validation.user.type_id.not_null.code}")
    private Integer typeId;

    @NotEmpty(message="The identification field has unconscious information.",  businessCode = "01.01.01")
    @Size(message="A problem has occurred in the field identification, the size is not allowed",
            businessCode = "01.01.01", max = 20)
    @Schema(description = "User's identification", required=true, example = "123456789")
    private String identification;

    @NotEmpty(message="The name1 field has unconscious information.",  businessCode = "01.01.01")
    @Size(message="A problem has occurred in the field name1, the size is not allowed",
            businessCode = "01.01.01", max = 100)
    @Schema(description = "User's first name", required=true, example = "John")
    private String name1;

    @Size(message="A problem has occurred in the field name2, the size is not allowed",
            businessCode = "01.01.01", max = 100)
    @Schema(description = "User's second name",  example = "Joseph")
    private String name2;

    @NotEmpty(message="The lastname1 field has unconscious information.",  businessCode = "01.01.01")
    @Size(message="A problem has occurred in the field lastname1, the size is not allowed",
            businessCode = "01.01.01", max = 100)
    @Schema(description = "User's first lastname", required=true, example = "Doe")
    private String lastname1;

    @Size(message="A problem has occurred in the field lastname2, the size is not allowed",
            businessCode = "01.01.01", max = 100)
    @Schema(description = "User's second lastname", example = "Bush")
    private String lastname2;

    @Email(businessCode = "01.02.28", message = "The email does not have a valid format")
    @NotEmpty(message="The email field has unconscious information.",  businessCode = "01.01.01")
    @Size(message="A problem has occurred in the field email, the size is not allowed",
            businessCode = "01.01.01", max = 150)
    @Schema(description = "User's email", required=true, example = "abc@redlink.com.ar")
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})")
    @Size(message="A problem has occurred in the field phone, the size is not allowed",
            businessCode = "01.01.01", max = 10)
    @Schema(description = "User's phone", example = "+57 555 555 5555")
    private String phone;

    @Size(message="A problem has occurred in the field address, the size is not allowed",
            businessCode = "01.01.01", max = 255)
    @Schema(description = "User's address", example = "Springfield - Alive Always Avenue #123")
    private String address;

    @NotEmpty(message="The city field has unconscious information.",  businessCode = "01.01.01")
    @Schema(description = "User's city", example = "1")
    private Long city;

    @Size(message="A problem has occurred in the field postalCode, the size is not allowed",
            businessCode = "01.01.01", min = 8 , max = 10)
    @Schema(description = "User's postal code", example = "130008")
    private String postalCode;

    @NotNull(message="The gender field cannot be null",  businessCode = "01.01.01")
    @NotEmpty(message="The gender field has unconscious information.",  businessCode = "01.01.01")
    @Schema(description = "User's gender", example = "999")
    private Integer gender;

    @NotNull(message="The company field cannot be null",  businessCode = "01.01.01")
    @NotEmpty(message="The company field has unconscious information.",  businessCode = "01.01.01")
    @Schema(description = "User's company", example = "999")
    private Integer company;

    @Schema(description = "User's birthday", example = "1890-01-01")
    private Date birthday_date;

    @Schema(description = "User's picture")
    private String picture;
}
