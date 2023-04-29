package ar.com.redlink.converters.user_types_ids;

import ar.com.redlink.controllers.requests.UserTypeIdDTO;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserTypeIdDTOToUserTypeIdEntity {

    UserTypeIdDTOToUserTypeIdEntity INSTANCE = Mappers.getMapper(UserTypeIdDTOToUserTypeIdEntity.class);
    UserTypeIdEntity userTypeIdDTOToUserTypeIdEntity(UserTypeIdDTO userRequest);
}
