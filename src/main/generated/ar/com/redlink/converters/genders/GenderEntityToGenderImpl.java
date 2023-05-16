package ar.com.redlink.converters.genders;

import ar.com.redlink.domain.Gender;
import ar.com.redlink.services.impl.entities.GenderEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T21:35:47-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
public class GenderEntityToGenderImpl implements GenderEntityToGender {

    @Override
    public Gender genderEntityToGender(GenderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Gender gender = new Gender();

        gender.setName( entity.getName() );
        gender.setDescription( entity.getDescription() );

        return gender;
    }
}
