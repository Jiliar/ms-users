package ar.com.redlink.services;

import ar.com.redlink.models.User;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T, ID> {
    List<T> listAll();
    Optional<T> findById(ID id);
    T save(T user);
    void delete(ID id);
}
