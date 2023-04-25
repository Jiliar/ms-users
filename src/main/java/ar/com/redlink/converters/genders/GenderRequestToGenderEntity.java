package ar.com.redlink.converters.genders;

import ar.com.redlink.controllers.requests.GenderRequest;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenderRequestToGenderEntity {

    GenderRequestToGenderEntity INSTANCE = Mappers.getMapper(GenderRequestToGenderEntity.class);
    GenderEntity genderRequestToGenderEntity(GenderRequest genderRequest);
}
