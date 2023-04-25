package ar.com.redlink.controllers;

import ar.com.redlink.controllers.responses.Response;
import ar.com.redlink.converters.genders.GenderEntityToGender;
import ar.com.redlink.converters.users.UserEntityToUser;
import ar.com.redlink.models.Gender;
import ar.com.redlink.models.User;
import ar.com.redlink.services.IGenderService;
import ar.com.redlink.services.impl.entities.GenderEntity;
import ar.com.redlink.services.impl.entities.UserEntity;
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
@RequestMapping("/genders")
public class GenderController {

    private String path = "/genders";
    @Autowired
    private IGenderService service;

    @GetMapping("/")
    public  ResponseEntity<?> list(){

        List<Gender> details =  service.listAll()
                    .stream()
                    .map(GenderEntityToGender.INSTANCE::genderEntityToGender)
                    .collect(Collectors.toList());

        Response response = new Response(details, path, TimeUtils.currentTimestamp());

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getGenderById(@PathVariable Integer id){

        Optional<GenderEntity> optionalGender =  service.findById(id);
        return optionalGender.map(genderEntityResult -> {
            List<Gender> details = new ArrayList<>();
            Gender gender = GenderEntityToGender.INSTANCE.genderEntityToGender(genderEntityResult);
            details.add(gender);
            Response response = new Response(details, path, TimeUtils.currentTimestamp());
            return ResponseEntity.ok()
                    .body(response);
        }).orElseGet(() -> ResponseEntity.notFound()
                .build());

    }

}
