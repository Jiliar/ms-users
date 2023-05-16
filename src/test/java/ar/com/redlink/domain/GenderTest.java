package ar.com.redlink.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenderTest {
    private Gender gender1;
    private Gender gender2;
    @Test
    public void testGender(){
        gender1 = new Gender("MASCULINO Test", "Masculino Test");
        gender2 = new Gender();
        gender2.setName(gender1.getName());
        gender2.setDescription(gender1.getDescription());
        Assertions.assertEquals(gender1.toString(), gender2.toString());
    }
}