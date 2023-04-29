package ar.com.redlink.controllers.requests;






import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.github.damianwajser.validator.annotation.strings.UUID;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Schema(name="Version 1 User Types Ids", description="DTO for User Types Ids management")
public class UserTypeIdDTO {

    @UUID(message = "Bad Format", businessCode = "ERROR_12")
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Schema(description = "Field name of user type Id", example="DNI / Pasaporte", required = true)
    private String name;

    @Size(max = 255)
    @Schema(description = "Field description of user type Id", example="Description")
    private String description;
}
