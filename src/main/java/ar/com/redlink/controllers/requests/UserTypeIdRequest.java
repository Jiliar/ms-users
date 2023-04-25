package ar.com.redlink.controllers.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserTypeIdRequest {

    @Null
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String name;

    @Size(max = 255)
    private String description;
}
