package ar.com.redlink.services.impl;

import ar.com.redlink.repositories.IGenderRepository;
import ar.com.redlink.repositories.IGenericRepository;
import ar.com.redlink.services.IGenderService;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl extends CRUDImpl<GenderEntity, Long> implements IGenderService {
    @Autowired
    private IGenderRepository repository;
    protected IGenericRepository getRepository(){
        return repository;
    }
}
