package ar.com.redlink.converters.genders;

import ar.com.redlink.controllers.requests.GenderRequest;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenderRequestToGenderEntity {

    GenderRequestToGenderEntity INSTANCE = Mappers.getMapper(GenderRequestToGenderEntity.class);

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "registration_date", ignore = true)
    @Mapping(target = "registration_user", ignore = true)
    @Mapping(target = "update_date", ignore = true)
    @Mapping(target = "update_user", ignore = true)
    @Mapping(target = "disable_date", ignore = true)
    @Mapping(target = "disable_user", ignore = true)
    @Mapping(target = "id", ignore = true)
    GenderEntity genderRequestToGenderEntity(GenderRequest genderRequest);
}
