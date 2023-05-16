package ar.com.redlink.repositories;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenderRepository extends IGenericRepository<GenderEntity, Long>{
}
