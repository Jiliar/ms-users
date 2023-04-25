package ar.com.redlink.services;

import ar.com.redlink.services.impl.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService extends ICRUD<UserEntity, Integer>{

   Optional<UserEntity> findByIdentification(String identification);
    List<UserEntity> findByLastname(String lastname);

}
