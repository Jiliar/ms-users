package ar.com.redlink.converters.user_types_ids;

import ar.com.redlink.controllers.requests.UserTypeIdRequest;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserTypeIdRequestToUserTypeIdEntity {

    UserTypeIdRequestToUserTypeIdEntity INSTANCE = Mappers.getMapper(UserTypeIdRequestToUserTypeIdEntity.class);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "registration_date", ignore = true)
    @Mapping(target = "registration_user", ignore = true)
    @Mapping(target = "update_date", ignore = true)
    @Mapping(target = "update_user", ignore = true)
    @Mapping(target = "disable_date", ignore = true)
    @Mapping(target = "disable_user", ignore = true)
    UserTypeIdEntity userTypeIdRequestToUserTypeIdEntity(UserTypeIdRequest userRequest);
}
