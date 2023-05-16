package ar.com.redlink.domain;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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
