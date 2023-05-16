package ar.com.redlink.services.impl.entities;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Entity
@Table(name = "GENDERS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class GenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENDERS_SEQUENCE")
    @SequenceGenerator(name="GENDERS_SEQUENCE", sequenceName ="GENDERS_SEQ",  allocationSize = 1, schema="BO_USERS")
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "The name of the identification type for user cannot be empty")
    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull(message = "the status field cannot be null")
    @Column(name = "STATUS")
    private Integer status;

    @NotNull(message = "There was a problem with the registration date of the entity")
    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registration_date;

    @NotNull(message = "There was a problem with the registration user of the entity")
    @Column(name="REGISTRATION_USER")
    private Integer registration_user;

    @Null
    @Column(name="UPDATE_DATE")
    private LocalDateTime update_date;

    @Null
    @Column(name="UPDATE_USER")
    private Integer update_user;

    @Null
    @Column(name="DISABLE_DATE")
    private LocalDateTime disable_date;

    @Null
    @Column(name="DISABLE_USER")
    private Integer disable_user;
}
