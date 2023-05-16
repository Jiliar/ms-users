package ar.com.redlink.repositories;

import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTypeIdRepository extends IGenericRepository<UserTypeIdEntity, Long>{
}
