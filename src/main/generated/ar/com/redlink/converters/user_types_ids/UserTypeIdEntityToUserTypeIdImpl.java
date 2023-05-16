package ar.com.redlink.converters.user_types_ids;

import ar.com.redlink.domain.UserTypeId;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T21:35:47-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
public class UserTypeIdEntityToUserTypeIdImpl implements UserTypeIdEntityToUserTypeId {

    @Override
    public UserTypeId userTypeIdEntityToUserTypeId(UserTypeIdEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserTypeId userTypeId = new UserTypeId();

        userTypeId.setId( entity.getId() );
        userTypeId.setName( entity.getName() );
        userTypeId.setDescription( entity.getDescription() );

        return userTypeId;
    }
}
