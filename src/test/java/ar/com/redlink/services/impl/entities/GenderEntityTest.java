package ar.com.redlink.services.impl.entities;

import ar.com.redlink.domain.BasicModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class GenderEntityTest {

    private GenderEntity gender1;
    private GenderEntity gender2;
    @Test
    public void testGender(){
        gender1 = new GenderEntity(1L,"MASCULINO Test", "Masculino Test",1, LocalDateTime.now(), 1,
                LocalDateTime.now(), 1, LocalDateTime.now(), 1);
        gender2 = new GenderEntity();
        gender2.setName(gender1.getName());
        gender2.setDescription(gender1.getDescription());
        gender2.setId(gender1.getId());
        gender2.setStatus(gender1.getStatus());
        gender2.setRegistration_date(gender1.getRegistration_date());
        gender2.setRegistration_user(gender1.getRegistration_user());
        gender2.setUpdate_date(gender1.getUpdate_date());
        gender2.setUpdate_user(gender1.getUpdate_user());
        gender2.setDisable_date(gender1.getDisable_date());
        gender2.setDisable_user(gender1.getDisable_user());
        Assertions.assertEquals(gender1.toString(), gender2.toString());
    }

}