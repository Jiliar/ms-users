package ar.com.redlink.services.impl;

import ar.com.redlink.repository.IGenericRepository;
import ar.com.redlink.services.ICRUD;

import java.util.List;
import java.util.Optional;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {
    protected abstract IGenericRepository<T, ID> getRepository();
    public List<T> listAll(){
        return getRepository().findAll();
    }
    public Optional<T> findById(ID id){
        return getRepository().findById(id);
    }
    public T save(T t){
        return getRepository().save(t);
    }
    public void delete(ID id){
        getRepository().deleteById(id);
    }
}
