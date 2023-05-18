package ar.com.redlink.controllers.requests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

class UserRequestTest {


    private UserRequest user1;
    private UserRequest user2;

    @BeforeEach
    public void setup(){
        user1 = new UserRequest();
        user1.setTypeId(1);
        user1.setIdentification("DNI");
        user1.setName1("NAME1");
        user1.setName2("NAME2");
        user1.setLastname1("LASTNAME1");
        user1.setLastname2("LASTNAME2");
        user1.setEmail("abc@redlink.com.ar");
        user1.setPhone("5555555");
        user1.setAddress("CARTAGENA");
        user1.setCity(1L);
        user1.setPostalCode("130008");
        user1.setGender(1);
        user1.setCompany(1);
        user1.setBirthday_date(new Date());
        user1.setPicture(null);
    }

    @Test
    public void testUser(){

        user2 = new UserRequest();
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