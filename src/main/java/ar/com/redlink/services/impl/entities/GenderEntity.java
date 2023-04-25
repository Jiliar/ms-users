package ar.com.redlink.services.impl.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
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
public class GenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

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
