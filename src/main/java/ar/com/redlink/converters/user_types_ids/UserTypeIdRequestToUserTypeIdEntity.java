package ar.com.redlink.converters.user_types_ids;

import ar.com.redlink.controllers.requests.UserTypeIdRequest;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserTypeIdRequestToUserTypeIdEntity {

    UserTypeIdRequestToUserTypeIdEntity INSTANCE = Mappers.getMapper(UserTypeIdRequestToUserTypeIdEntity.class);
    UserTypeIdEntity userTypeIdRequestToUserTypeIdEntity(UserTypeIdRequest userRequest);
}
