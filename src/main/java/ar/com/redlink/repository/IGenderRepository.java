package ar.com.redlink.repository;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenderRepository extends IGenericRepository<GenderEntity, Long>{
}
