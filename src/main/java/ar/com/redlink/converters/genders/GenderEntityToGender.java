package ar.com.redlink.converters.genders;

import ar.com.redlink.models.Gender;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenderEntityToGender {

    GenderEntityToGender INSTANCE = Mappers.getMapper(GenderEntityToGender.class);
    Gender genderEntityToGender(GenderEntity entity);
}
