package ar.com.redlink.converters.genders;

import ar.com.redlink.controllers.requests.GenderDTO;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenderDTOToGenderEntity {

    GenderDTOToGenderEntity INSTANCE = Mappers.getMapper(GenderDTOToGenderEntity.class);
    GenderEntity genderDTOToGenderEntity(GenderDTO genderDTO);
}
