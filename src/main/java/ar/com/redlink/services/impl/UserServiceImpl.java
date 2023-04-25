package ar.com.redlink.services.impl;

import ar.com.redlink.repository.IUserRepository;
import ar.com.redlink.repository.IGenericRepository;
import ar.com.redlink.services.IUserService;
import ar.com.redlink.services.impl.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends CRUDImpl<UserEntity, Integer> implements IUserService {

    @Autowired
    private IUserRepository repository;
    protected IGenericRepository getRepository(){
        return repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findByIdentification(String identification) {
        UserEntity userEntity = repository.findByIdentification(identification);
        if(userEntity != null)
            return Optional.of(userEntity);
        else
            return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findByLastname(String lastname) {
        return repository.findByLastName1(lastname);
    }
}
