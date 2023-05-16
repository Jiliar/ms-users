package ar.com.redlink.controllers.interfaces;
import com.github.damianwajser.exceptions.RestException;
import com.github.damianwajser.exceptions.impl.badrequest.NotFoundException;
import org.springframework.http.ResponseEntity;

public interface IRestController {

    ResponseEntity<?> list();
    ResponseEntity<?> getById(Long id) throws RestException;
}
