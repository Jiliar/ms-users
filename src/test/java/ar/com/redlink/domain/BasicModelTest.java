package ar.com.redlink.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class BasicModelTest {

    private BasicModel basicModel1;
    private BasicModel basicModel2;

    @Test
    public void testBasicModel(){
        basicModel1 = new BasicModel(1,1, LocalDateTime.now(), 1,
                LocalDateTime.now(), 1, LocalDateTime.now(), 1);
        basicModel2 = new BasicModel();
        basicModel2.setId(basicModel1.getId());
        basicModel2.setStatus(basicModel1.getStatus());
        basicModel2.setRegistration_date(basicModel1.getRegistration_date());
        basicModel2.setRegistration_user(basicModel1.getRegistration_user());
        basicModel2.setUpdate_date(basicModel1.getUpdate_date());
        basicModel2.setUpdate_user(basicModel1.getUpdate_user());
        basicModel2.setDisable_date(basicModel1.getDisable_date());
        basicModel2.setDisable_user(basicModel1.getDisable_user());
        Assertions.assertEquals(basicModel1.toString(), basicModel2.toString());
    }
}