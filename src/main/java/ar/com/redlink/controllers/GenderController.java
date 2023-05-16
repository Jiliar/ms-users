package ar.com.redlink.controllers;

import ar.com.redlink.controllers.interfaces.IGenderController;
import ar.com.redlink.converters.genders.GenderEntityToGender;
import ar.com.redlink.domain.Gender;
import ar.com.redlink.services.IGenderService;
import ar.com.redlink.services.impl.entities.GenderEntity;
import com.github.damianwajser.exceptions.RestException;
import com.github.damianwajser.exceptions.impl.badrequest.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ar.com.redlink.utils.ErrorCodes.GENDER_NOT_FOUND;
import static ar.com.redlink.utils.ErrorCodes.USER_NOT_FOUND;

@RestController
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws RestException {
        Optional<GenderEntity> optionalGender =  service.findById(id);
        return optionalGender.map(genderEntityResult -> {
            return ResponseEntity.ok()
                    .body(genderEntityResult);
        }).orElseThrow(() -> new NotFoundException(GENDER_NOT_FOUND.getCode(), GENDER_NOT_FOUND.getMessage()));

    }

}
