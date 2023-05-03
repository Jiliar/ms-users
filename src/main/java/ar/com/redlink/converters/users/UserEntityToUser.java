package ar.com.redlink.converters.users;

import ar.com.redlink.domain.User;
import ar.com.redlink.services.impl.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityToUser {

    UserEntityToUser INSTANCE = Mappers.getMapper(UserEntityToUser.class);
    @Mapping(target = "typeId", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "birthday_date", ignore = true)
    @Mapping(target="company", source="entity.company_id")
    @Mapping(target="city", source="entity.city_id")
    User userEntityToUser(UserEntity entity);

}
