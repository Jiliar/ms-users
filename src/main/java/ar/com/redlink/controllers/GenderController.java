package ar.com.redlink.controllers;

import ar.com.redlink.controllers.interfaces.IGenderController;
import ar.com.redlink.converters.genders.GenderEntityToGender;
import ar.com.redlink.domain.Gender;
import ar.com.redlink.services.IGenderService;
import ar.com.redlink.services.impl.entities.GenderEntity;
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
@RequestMapping("/genders")
@Slf4j
public class GenderController implements IGenderController {

    @Autowired
    private IGenderService service;

    @GetMapping("/")
    public  ResponseEntity<?> list(){

        List<Gender> details =  service.listAll()
                    .stream()
                    .map(GenderEntityToGender.INSTANCE::genderEntityToGender)
                    .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(details);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {

        Optional<GenderEntity> optionalGender =  service.findById(id);
        return optionalGender.map(genderEntityResult -> {
            Gender gender = GenderEntityToGender.INSTANCE.genderEntityToGender(genderEntityResult);
            return ResponseEntity.ok()
                    .body(gender);
        }).orElseGet(() -> ResponseEntity.notFound()
                .build());

    }

}
