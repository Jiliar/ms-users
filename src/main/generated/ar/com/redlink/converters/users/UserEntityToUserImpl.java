package ar.com.redlink.converters.users;

import ar.com.redlink.domain.User;
import ar.com.redlink.services.impl.entities.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T21:35:47-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
public class UserEntityToUserImpl implements UserEntityToUser {

    @Override
    public User userEntityToUser(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User user = new User();

        user.setCompany( entity.getCompany_id() );
        user.setCity( entity.getCity_id() );
        user.setId( entity.getId() );
        user.setIdentification( entity.getIdentification() );
        user.setName1( entity.getName1() );
        user.setName2( entity.getName2() );
        user.setLastname1( entity.getLastname1() );
        user.setLastname2( entity.getLastname2() );
        user.setEmail( entity.getEmail() );
        user.setPhone( entity.getPhone() );
        user.setAddress( entity.getAddress() );
        user.setPostalCode( entity.getPostalCode() );
        user.setPicture( entity.getPicture() );

        return user;
    }
}
