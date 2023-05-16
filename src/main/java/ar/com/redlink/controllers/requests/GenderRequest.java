package ar.com.redlink.controllers.requests;



import com.github.damianwajser.validator.annotation.global.NotEmpty;
import com.github.damianwajser.validator.annotation.global.NotNull;
import com.github.damianwajser.validator.annotation.global.Size;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Schema(name="Version 1 Gender", description="DTO for Gender Request")
public class GenderRequest {


    @Schema(description = "Field gender's name", example="Male / Female", required = true)
    @NotNull(message="The name field cannot be null",  businessCode = "01.01.01")
    @NotEmpty(message="The name field cannot be blank",  businessCode = "01.01.01")
    @Size(message="A problem has occurred in the field name, the size is not allowed",
            businessCode = "01.01.01", max = 100)
    private String name;

    @Size(message="A problem has occurred in the field name, the size is not allowed",
            businessCode = "01.01.01", max = 255)
    @Schema(description = "Field gender's description", example="Description")
    private String description;
}
