package ar.com.redlink.services.impl;

import ar.com.redlink.repositories.IGenericRepository;
import ar.com.redlink.repositories.IUserTypeIdRepository;
import ar.com.redlink.services.IUserTypeIdService;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeIdServiceImpl extends CRUDImpl<UserTypeIdEntity, Long> implements IUserTypeIdService {

    @Autowired
    private IUserTypeIdRepository repository;
    protected IGenericRepository getRepository(){
        return repository;
    }

}
