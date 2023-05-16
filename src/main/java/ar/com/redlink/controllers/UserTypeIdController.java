package ar.com.redlink.controllers;

import ar.com.redlink.controllers.interfaces.IUserTypeIdController;
import ar.com.redlink.converters.user_types_ids.UserTypeIdEntityToUserTypeId;
import ar.com.redlink.domain.UserTypeId;
import ar.com.redlink.services.IUserTypeIdService;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import com.github.damianwajser.exceptions.impl.badrequest.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ar.com.redlink.utils.ErrorCodes.USER_TYPE_ID_NOT_FOUND;

@RestController
@Slf4j
@Validated
public class UserTypeIdController implements IUserTypeIdController {

    @Autowired
    private IUserTypeIdService service;

    @GetMapping("/")
    public  ResponseEntity<?> list(){

        List<UserTypeId> details =  service.listAll()
                .stream()
                .map(UserTypeIdEntityToUserTypeId.INSTANCE::userTypeIdEntityToUserTypeId)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(details);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws NotFoundException {
        Optional<UserTypeIdEntity> optionalUserTypeId =  service.findById(id);
        return optionalUserTypeId.map(userTypeIdEntityResult -> {
            return ResponseEntity.ok()
                    .body(userTypeIdEntityResult);
        }).orElseThrow(() -> new NotFoundException(USER_TYPE_ID_NOT_FOUND.getCode(), USER_TYPE_ID_NOT_FOUND.getMessage()));

    }
}
