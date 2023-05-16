package ar.com.redlink.controllers.requests;

import com.github.damianwajser.validator.annotation.global.NotEmpty;
import com.github.damianwajser.validator.annotation.global.NotNull;
import com.github.damianwajser.validator.annotation.global.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Schema(name="Version 1 User Types Ids", description="DTO for User Types Ids Request")
public class UserTypeIdRequest {

    @NotNull(message="The name field cannot be null",  businessCode = "01.01.01")
    @NotEmpty(message="The name field cannot be blank",  businessCode = "01.01.01")
    @Size(message="A problem has occurred in the field name, the size is not allowed",
            businessCode = "01.01.01", max = 100)
    @Schema(description = "Field name of user type Id", example="DNI / Passport", required = true)
    private String name;

    @Size(message="A problem has occurred in the field name, the size is not allowed",
            businessCode = "01.01.01", max = 255)
    @Schema(description = "Field description of user type Id", example="Description")
    private String description;
}
