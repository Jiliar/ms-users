package ar.com.redlink.controllers;

import ar.com.redlink.controllers.responses.Response;
import ar.com.redlink.converters.genders.GenderEntityToGender;
import ar.com.redlink.converters.user_types_ids.UserTypeIdEntityToUserTypeId;
import ar.com.redlink.models.Gender;
import ar.com.redlink.models.UserTypeId;
import ar.com.redlink.services.IUserTypeIdService;
import ar.com.redlink.services.impl.entities.GenderEntity;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import ar.com.redlink.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user-types-id")
public class UserTypeIdController {

    private String path = "/user-types-id";

    @Autowired
    private IUserTypeIdService service;

    @GetMapping("/")
    public  ResponseEntity<?> list(){

        List<UserTypeId> details =  service.listAll()
                .stream()
                .map(UserTypeIdEntityToUserTypeId.INSTANCE::userTypeIdEntityToUserTypeId)
                .collect(Collectors.toList());

        Response response = new Response(details, path, TimeUtils.currentTimestamp());

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserTypeIdById(@PathVariable Integer id){
        Optional<UserTypeIdEntity> optionalUserTypeId =  service.findById(id);
        return optionalUserTypeId.map(userTypeIdEntityResult -> {
            List<UserTypeId> details = new ArrayList<>();
            UserTypeId userTypeId = UserTypeIdEntityToUserTypeId.INSTANCE.userTypeIdEntityToUserTypeId(userTypeIdEntityResult);
            details.add(userTypeId);
            Response response = new Response(details, path, TimeUtils.currentTimestamp());
            return ResponseEntity.ok()
                    .body(response);
        }).orElseGet(() -> ResponseEntity.notFound()
                .build());

    }
}
