package ar.com.redlink.services.impl.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "USERS_TYPES_ID")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserTypeIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_TYPES_ID_SEQUENCE")
    @SequenceGenerator(name="USERS_TYPES_ID_SEQUENCE", sequenceName ="USERS_TYPES_ID_SEQ",  allocationSize = 1, schema="BO_USERS")
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "The name of the identification type for user cannot be empty")
    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull(message = "the status field cannot be null")
    @Column(name = "STATUS")
    private String status;

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
