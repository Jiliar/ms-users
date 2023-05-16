package ar.com.redlink.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user1;
    private User user2;

    @Test
    public void testUser(){
        UserTypeId userTypeId1 = new UserTypeId("DNI Test", "DNI Desc Test");
        Gender gender1 = new Gender("MASCULINO Test", "Masculino Test");
        user1 = new User(userTypeId1, "DNI", "NAME1", "NAME2",
                        "LASTNAME1", "LASTNAME2", "abc@redlink.com.ar",
                        "5555555", "CARTAGENA", 1, 1, "130008",
                        gender1, "1988-01-01", null);
        user2 = new User();
        user2.setTypeId(user1.getTypeId());
        user2.setIdentification(user1.getIdentification());
        user2.setName1(user1.getName1());
        user2.setName2(user1.getName2());
        user2.setLastname1(user1.getLastname1());
        user2.setLastname2(user1.getLastname2());
        user2.setEmail(user1.getEmail());
        user2.setPhone(user1.getPhone());
        user2.setAddress(user1.getAddress());
        user2.setCity(user1.getCity());
        user2.setCompany(user1.getCompany());
        user2.setPostalCode(user1.getPostalCode());
        user2.setGender(user1.getGender());
        user2.setBirthday_date(user1.getBirthday_date());
        user2.setPicture(user1.getPicture());
        Assertions.assertEquals(user1.toString(), user2.toString());

    }
}