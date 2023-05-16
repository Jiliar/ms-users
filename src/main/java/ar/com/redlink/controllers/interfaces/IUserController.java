package ar.com.redlink.controllers.interfaces;

import ar.com.redlink.controllers.requests.UserRequest;
import com.github.damianwajser.exceptions.RestException;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;


@Api( tags="User's Controller",
        description = "Controller to manage requests and responses about Users.")

@RequestMapping("/api/v1/user")
public interface IUserController extends IRestController {
    ResponseEntity<?> create(UserRequest user) throws RestException;
    ResponseEntity<?> delete(Long id) throws RestException;
    ResponseEntity<?> update(Long id, UserRequest user) throws RestException;
}
