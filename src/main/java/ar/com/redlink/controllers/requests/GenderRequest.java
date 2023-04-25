package ar.com.redlink.controllers.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GenderRequest {

    @Null
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String name;

    @Size(max = 255)
    private String description;
}
