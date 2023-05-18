package ar.com.redlink.controllers.requests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTypeIdRequestTest {
    private UserTypeIdRequest userTypeId1;
    private UserTypeIdRequest userTypeId2;

    @BeforeEach
    public void setup(){
        userTypeId1 = new UserTypeIdRequest();
        userTypeId1.setName("DNI");
        userTypeId1.setDescription("Example");
    }
    @Test
    public void testUser(){
        userTypeId2 = new UserTypeIdRequest();
        userTypeId2.setName(userTypeId1.getName());
        userTypeId2.setDescription(userTypeId1.getDescription());
        Assertions.assertEquals(userTypeId1.toString(), userTypeId2.toString());
    }
}