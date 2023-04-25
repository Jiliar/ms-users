package ar.com.redlink.services.impl;

import ar.com.redlink.repository.IGenderRepository;
import ar.com.redlink.repository.IGenericRepository;
import ar.com.redlink.services.IGenderService;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl extends CRUDImpl<GenderEntity, Integer> implements IGenderService {
    @Autowired
    private IGenderRepository repository;
    protected IGenericRepository getRepository(){
        return repository;
    }
}
