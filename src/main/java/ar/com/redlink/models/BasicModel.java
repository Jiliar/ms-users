package ar.com.redlink.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BasicModel {

    private Integer id;
    private Integer status;
    private LocalDateTime registration_date;
    private Integer registration_user;
    private LocalDateTime update_date;
    private Integer update_user;
    private LocalDateTime disable_date;
    private Integer disable_user;

}
