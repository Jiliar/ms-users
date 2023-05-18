package ar.com.redlink.services.impl;

import ar.com.redlink.repositories.IGenericRepository;
import ar.com.redlink.services.ICRUD;
import ar.com.redlink.utils.ErrorCodes;
import com.github.damianwajser.exceptions.RestException;
import com.github.damianwajser.exceptions.impl.servererror.InternalServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static ar.com.redlink.utils.ErrorCodes.USER_NOT_FOUND;
@Slf4j
public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {
    protected abstract IGenericRepository<T, ID> getRepository();
    public List<T> listAll(){
        return getRepository().findAll();
    }
    public Optional<T> findById(ID id){
        return getRepository().findById(id);
    }
    public T save(T t) throws InternalServerErrorException {
        try {
            return getRepository().save(t);
        }catch (DataIntegrityViolationException | ConstraintViolationException e){
            log.error(t.getClass().getSimpleName()+".save() "+e.getMessage());
            throw new InternalServerErrorException(USER_NOT_FOUND.code, USER_NOT_FOUND.getMessage());
        }
    }
    public void delete(ID id){
        getRepository().deleteById(id);
    }
}
