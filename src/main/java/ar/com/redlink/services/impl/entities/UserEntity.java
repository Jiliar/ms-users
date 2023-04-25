package ar.com.redlink.services.impl.entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "USERS")

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQUENCE")
    @SequenceGenerator(name="USERS_SEQUENCE", sequenceName ="USERS_SEQ",  allocationSize = 1, schema="BO_USERS")
    @Column(name = "ID")
    private Integer id;

    @NotNull(message = "The field type_id cannot be null")
    @Column(name = "TYPE_ID")
    private Integer typeId;

    @NotBlank(message = "The field identification cannot be empty")
    @NotNull(message = "The field identification cannot be null")
    @Column(name = "IDENTIFICATION")
    private String identification;

    @NotBlank(message = "The field name cannot be empty")
    @NotNull(message = "The field name cannot be null")
    @Column(name = "NAME1")
    private String name1;

    @Column(name = "NAME2")
    private String name2;

    @NotBlank(message = "The field lastname1 cannot be empty")
    @NotNull(message = "The field lastname1 cannot be null")
    @Column(name = "LASTNAME1")
    private String lastname1;

    @Column(name = "LASTNAME2")
    private String lastname2;

    @NotBlank(message = "The field email cannot be empty")
    @NotNull(message = "The field email cannot be null")
    @Column(name = "EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @Column(name="ADDRESS")
    private String address;

    @NotNull(message = "The field city_id cannot be null")
    @Column(name="CITY_ID")
    private Integer city_id;

    @Column(name="POSTAL_CODE")
    private String postalCode;

    @NotNull(message = "The field gender cannot be null")
    @Column(name="GENDER_ID")
    private Integer gender_id;

    @Column(name="BIRTHDAY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday_date;

    @NotNull(message = "The field company_id cannot be null")
    @Column(name="COMPANY_ID")
    private Integer company_id;

    @Column(name="PICTURE")
    private String picture;

    @Column(name="STATUS")
    private Integer status;

    @NotNull(message = "There was a problem with the registration date of the entity")
    @Column(name="registration_date")
    private LocalDateTime registration_date;

    @NotNull(message = "There was a problem with the registration user of the entity")
    @Column(name="registration_user")
    private Integer registration_user;

    @Column(name="update_date")
    private LocalDateTime update_date;

    @Column(name="update_user")
    private Integer update_user;

    @Column(name="disable_date")
    private LocalDateTime disable_date;

    @Column(name="disable_user")
    private Integer disable_user;

}
