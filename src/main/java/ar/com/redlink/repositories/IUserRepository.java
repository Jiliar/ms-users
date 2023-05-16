package ar.com.redlink.repositories;
import ar.com.redlink.services.impl.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends IGenericRepository<UserEntity, Long>{

    @Query("SELECT u FROM UserEntity u WHERE u.identification =:identification ")
    UserEntity findByIdentification(@Param("identification") String identification);
    @Query("SELECT u FROM UserEntity u WHERE u.lastname1 = :lastname1")
    List<UserEntity> findByLastName1(@Param("lastname1") String lastname1);
}
