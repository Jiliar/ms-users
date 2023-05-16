package ar.com.redlink.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTypeIdTest {

    private UserTypeId userTypeId1;
    private UserTypeId userTypeId2;
    @Test
    public void testGender(){
        userTypeId1 = new UserTypeId("DNI Test", "DNI Desc Test");
        userTypeId2 = new UserTypeId();
        userTypeId2.setName(userTypeId1.getName());
        userTypeId2.setDescription(userTypeId1.getDescription());
        Assertions.assertEquals(userTypeId1.toString(), userTypeId1.toString());
    }
}