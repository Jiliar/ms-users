package ar.com.redlink.controllers.requests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GenderRequestTest {

    private GenderRequest gender1;
    private GenderRequest gender2;

    @BeforeEach
    public void setup(){
        gender1 = new GenderRequest();
        gender1.setName("MASCULINO");
        gender1.setDescription("Example");
    }
    @Test
    public void testUser(){
        gender2 = new GenderRequest();
        gender2.setName(gender1.getName());
        gender2.setDescription(gender1.getDescription());
        Assertions.assertEquals(gender1.toString(), gender2.toString());
    }
}