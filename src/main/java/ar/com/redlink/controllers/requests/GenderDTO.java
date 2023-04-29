package ar.com.redlink.controllers.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.github.damianwajser.validator.annotation.strings.UUID;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Schema(name="Version 1 Gender", description="DTO for Gender management")
public class GenderDTO {

    @UUID(message = "Bad Format", businessCode = "ERROR_12")
    private String id;

    @NotNull
    @Size(max = 100)
    @Schema(description = "Field gender's name", example="Male / Female", required = true)
    private String name;

    @Size(max = 255)
    @Schema(description = "Field gender's description", example="Description")
    private String description;
}
