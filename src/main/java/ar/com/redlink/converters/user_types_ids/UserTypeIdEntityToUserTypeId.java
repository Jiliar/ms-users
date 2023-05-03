package ar.com.redlink.converters.user_types_ids;

import ar.com.redlink.domain.UserTypeId;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserTypeIdEntityToUserTypeId {

    UserTypeIdEntityToUserTypeId INSTANCE = Mappers.getMapper(UserTypeIdEntityToUserTypeId.class);
    UserTypeId userTypeIdEntityToUserTypeId(UserTypeIdEntity entity);

}
