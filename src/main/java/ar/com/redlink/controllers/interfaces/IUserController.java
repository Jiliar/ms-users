package ar.com.redlink.controllers.interfaces;

import ar.com.redlink.controllers.requests.UserDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@Tag(name="User's Controller", description = "Controller to manage requests and responses from Users.")
public interface IUserController extends IRestController{
    ResponseEntity<?> create(UserDTO user, BindingResult result);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> update(Integer id, UserDTO user, BindingResult result);
}
