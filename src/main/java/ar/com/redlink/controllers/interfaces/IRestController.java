package ar.com.redlink.controllers.interfaces;

import ar.com.redlink.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;

public interface IRestController {

    ResponseEntity<?> list();
    ResponseEntity<?> getById(Integer id) throws NotFoundException;
}
