package ar.com.redlink.services.impl.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class UserTypeIdEntityTest {

    private UserTypeIdEntity userTypeIdEntity1;
    private UserTypeIdEntity userTypeIdEntity2;
    @Test
    public void testGender(){
        userTypeIdEntity1 = new UserTypeIdEntity(1L,"MASCULINO Test", "Masculino Test",1, LocalDateTime.now(), 1,
                LocalDateTime.now(), 1, LocalDateTime.now(), 1);
        userTypeIdEntity2 = new UserTypeIdEntity();
        userTypeIdEntity2.setName(userTypeIdEntity1.getName());
        userTypeIdEntity2.setDescription(userTypeIdEntity1.getDescription());
        userTypeIdEntity2.setId(userTypeIdEntity1.getId());
        userTypeIdEntity2.setStatus(userTypeIdEntity1.getStatus());
        userTypeIdEntity2.setRegistration_date(userTypeIdEntity1.getRegistration_date());
        userTypeIdEntity2.setRegistration_user(userTypeIdEntity1.getRegistration_user());
        userTypeIdEntity2.setUpdate_date(userTypeIdEntity1.getUpdate_date());
        userTypeIdEntity2.setUpdate_user(userTypeIdEntity1.getUpdate_user());
        userTypeIdEntity2.setDisable_date(userTypeIdEntity1.getDisable_date());
        userTypeIdEntity2.setDisable_user(userTypeIdEntity1.getDisable_user());
        Assertions.assertEquals(userTypeIdEntity1.toString(), userTypeIdEntity2.toString());
    }

}