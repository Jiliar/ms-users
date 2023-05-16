package ar.com.redlink.converters.users;

import ar.com.redlink.controllers.requests.UserRequest;
import ar.com.redlink.services.impl.entities.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T21:35:47-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
public class UserRequestToUserEntityImpl implements UserRequestToUserEntity {

    @Override
    public UserEntity userRequestToUserEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setTypeId( request.getTypeId() );
        userEntity.setIdentification( request.getIdentification() );
        userEntity.setCity_id( request.getCity() );
        userEntity.setGender_id( request.getGender() );
        userEntity.setCompany_id( request.getCompany() );
        userEntity.setName1( request.getName1() );
        userEntity.setName2( request.getName2() );
        userEntity.setLastname1( request.getLastname1() );
        userEntity.setLastname2( request.getLastname2() );
        userEntity.setEmail( request.getEmail() );
        userEntity.setPhone( request.getPhone() );
        userEntity.setAddress( request.getAddress() );
        userEntity.setPostalCode( request.getPostalCode() );
        userEntity.setBirthday_date( request.getBirthday_date() );
        userEntity.setPicture( request.getPicture() );

        return userEntity;
    }
}
