package ar.com.redlink.controllers;

import ar.com.redlink.controllers.interfaces.IUsertTypeIdController;
import ar.com.redlink.converters.user_types_ids.UserTypeIdEntityToUserTypeId;
import ar.com.redlink.models.UserTypeId;
import ar.com.redlink.services.IUserTypeIdService;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user-types-id")
@Slf4j
public class UserTypeIdController implements IUsertTypeIdController {

    private String path = "/user-types-id";

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

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<UserTypeIdEntity> optionalUserTypeId =  service.findById(id);
        return optionalUserTypeId.map(userTypeIdEntityResult -> {
            UserTypeId userTypeId = UserTypeIdEntityToUserTypeId.INSTANCE.userTypeIdEntityToUserTypeId(userTypeIdEntityResult);
            return ResponseEntity.ok()
                    .body(userTypeId);
        }).orElseGet(() -> ResponseEntity.notFound()
                .build());

    }
}
