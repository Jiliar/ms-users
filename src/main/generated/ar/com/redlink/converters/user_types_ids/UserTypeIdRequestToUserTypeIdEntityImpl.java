package ar.com.redlink.converters.user_types_ids;

import ar.com.redlink.controllers.requests.UserTypeIdRequest;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T21:35:47-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
public class UserTypeIdRequestToUserTypeIdEntityImpl implements UserTypeIdRequestToUserTypeIdEntity {

    @Override
    public UserTypeIdEntity userTypeIdRequestToUserTypeIdEntity(UserTypeIdRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserTypeIdEntity userTypeIdEntity = new UserTypeIdEntity();

        userTypeIdEntity.setName( userRequest.getName() );
        userTypeIdEntity.setDescription( userRequest.getDescription() );

        return userTypeIdEntity;
    }
}
