package ar.com.redlink.services.impl;

import ar.com.redlink.repository.IGenericRepository;
import ar.com.redlink.repository.IUserTypeIdRepository;
import ar.com.redlink.services.IUserTypeIdService;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeIdServiceImpl extends CRUDImpl<UserTypeIdEntity, Integer> implements IUserTypeIdService {

    @Autowired
    private IUserTypeIdRepository repository;
    protected IGenericRepository getRepository(){
        return repository;
    }

}
