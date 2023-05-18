package ar.com.redlink.services;

import com.github.damianwajser.exceptions.impl.servererror.InternalServerErrorException;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T, ID> {
    List<T> listAll();
    Optional<T> findById(ID id);
    T save(T user) throws InternalServerErrorException;
    void delete(ID id);
}
