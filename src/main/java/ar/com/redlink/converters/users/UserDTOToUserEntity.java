package ar.com.redlink.converters.users;

import ar.com.redlink.controllers.requests.UserDTO;
import ar.com.redlink.services.impl.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDTOToUserEntity {
    UserDTOToUserEntity INSTANCE = Mappers.getMapper(UserDTOToUserEntity.class);
    @Mapping(target="typeId", source="request.typeId")
    @Mapping(target="identification", source="request.identification")
    @Mapping(target="city_id", source="request.city")
    @Mapping(target="gender_id", source="request.gender")
    @Mapping(target="company_id", source="request.company")
    UserEntity userDTOToUserEntity(UserDTO request);

}
