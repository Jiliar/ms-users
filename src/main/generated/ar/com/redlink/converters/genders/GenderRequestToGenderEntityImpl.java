package ar.com.redlink.converters.genders;

import ar.com.redlink.controllers.requests.GenderRequest;
import ar.com.redlink.services.impl.entities.GenderEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T21:35:47-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
public class GenderRequestToGenderEntityImpl implements GenderRequestToGenderEntity {

    @Override
    public GenderEntity genderRequestToGenderEntity(GenderRequest genderRequest) {
        if ( genderRequest == null ) {
            return null;
        }

        GenderEntity genderEntity = new GenderEntity();

        genderEntity.setName( genderRequest.getName() );
        genderEntity.setDescription( genderRequest.getDescription() );

        return genderEntity;
    }
}
