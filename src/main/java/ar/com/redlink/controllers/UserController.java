package ar.com.redlink.controllers;

import ar.com.redlink.controllers.requests.UserDTO;
import ar.com.redlink.controllers.interfaces.IUserController;
import ar.com.redlink.converters.users.UserDTOToUserEntity;
import ar.com.redlink.exceptions.models.ApiException;
import ar.com.redlink.converters.genders.GenderEntityToGender;
import ar.com.redlink.converters.user_types_ids.UserTypeIdEntityToUserTypeId;
import ar.com.redlink.converters.users.UserEntityToUser;
import ar.com.redlink.exceptions.NotFoundException;
import ar.com.redlink.models.Gender;
import ar.com.redlink.models.User;
import ar.com.redlink.models.UserTypeId;
import ar.com.redlink.services.IGenderService;
import ar.com.redlink.services.IUserService;
import ar.com.redlink.services.IUserTypeIdService;
import ar.com.redlink.services.impl.entities.GenderEntity;
import ar.com.redlink.services.impl.entities.UserEntity;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import ar.com.redlink.exceptions.ErrorValidationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController implements IUserController {

    private String path = "/users";
    @Autowired
    private IUserService service;

    @Autowired
    private IGenderService genderService;

    @Autowired
    private IUserTypeIdService userTypeIdService;

    @GetMapping("/")
    public ResponseEntity<?> list(){
        List<User> details = service.listAll()
            .stream()
            .map(userEntityResult -> {

                User userResult = UserEntityToUser.INSTANCE.userEntityToUser(userEntityResult);

                GenderEntity genderEntity = genderService.findById(userEntityResult.getGender_id()).get();
                Gender gender = GenderEntityToGender.INSTANCE.genderEntityToGender(genderEntity);
                userResult.setGender(gender);

                UserTypeIdEntity userTypeIdEntity = userTypeIdService.findById(userEntityResult.getTypeId()).get();
                UserTypeId userTypeId = UserTypeIdEntityToUserTypeId.INSTANCE.userTypeIdEntityToUserTypeId(userTypeIdEntity);
                userResult.setTypeId(userTypeId);

                SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formatedDate = newFormat.format(userEntityResult.getBirthday_date());
                userResult.setBirthday_date(formatedDate);

                return userResult;
            })
            .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(details);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) throws NotFoundException {
        Optional<UserEntity> optionalUser =  service.findById(id);
        return optionalUser.map(userEntityResult -> {
            return ResponseEntity.ok()
                                 .body(userEntityResult);
        }).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserDTO user, BindingResult result) {

        ApiException apiException = null;

            if(result.hasErrors()){
                return ErrorValidationHandler.validate(result);
            }

            if (service.findByIdentification(user.getIdentification()).isPresent()) {
                List<String> details = new ArrayList();
                details.add("There is already a user with that ID");
                apiException = new ApiException(details, path);
                return ResponseEntity
                        .badRequest()
                        .body(apiException);
            }
            UserEntity userEntity = UserDTOToUserEntity.INSTANCE.userDTOToUserEntity(user);
            userEntity.setStatus(1);
            userEntity.setRegistration_user(1);
            userEntity.setRegistration_date(LocalDateTime.now());
            UserEntity userEntityResult = service.save(userEntity);

            return ResponseEntity
                    .ok()
                    .body(userEntityResult);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Optional<UserEntity> optionalUser =  service.findById(id);
        if(optionalUser.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound()
                    .build();
        }
    }

   @PutMapping("/id/{id}")
   public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody UserDTO user, BindingResult result){
       ApiException apiException = null;
        if(result.hasErrors()){
            return ErrorValidationHandler.validate(result);
        }

        Optional<UserEntity> optionalUser =  service.findById(id);
        if(optionalUser.isPresent()){
            UserEntity userEntity = optionalUser.get();
            if( user.getEmail().equalsIgnoreCase(userEntity.getEmail())
                && !user.getEmail().isEmpty()){

                List<String> details = new ArrayList();
                details.add("There is already a user with that Email");
                apiException = new ApiException(details, path);
                return ResponseEntity
                        .badRequest()
                        .body(apiException);

            }

            userEntity.setId( id );
            userEntity.setIdentification( user.getIdentification() );
            userEntity.setName1( user.getName1() );
            userEntity.setName2( user.getName2() );
            userEntity.setLastname1( user.getLastname1() );
            userEntity.setLastname2( user.getLastname2() );
            userEntity.setEmail( user.getEmail() );
            userEntity.setPhone( user.getPhone() );
            userEntity.setAddress( user.getAddress() );
            userEntity.setCompany_id( user.getCompany() );
            userEntity.setCity_id( user.getCity() );
            userEntity.setPostalCode( user.getPostalCode() );
            userEntity.setPicture( user.getPicture() );

            userEntity.setStatus(1);
            userEntity.setUpdate_user(1);
            userEntity.setUpdate_date(LocalDateTime.now());

            UserEntity userEntityResult = service.save(userEntity);
            User userResult = UserDetails(userEntityResult, path);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userResult);
        }else{
            return ResponseEntity.notFound()
                    .build();
        }
    }

    public User UserDetails(UserEntity userEntityResult, String path){

        User userResult = UserEntityToUser.INSTANCE.userEntityToUser(userEntityResult);

        GenderEntity genderEntity = genderService.findById(userEntityResult.getGender_id()).get();
        Gender gender = GenderEntityToGender.INSTANCE.genderEntityToGender(genderEntity);
        userResult.setGender(gender);

        UserTypeIdEntity userTypeIdEntity = userTypeIdService.findById(userEntityResult.getTypeId()).get();
        UserTypeId userTypeId = UserTypeIdEntityToUserTypeId.INSTANCE.userTypeIdEntityToUserTypeId(userTypeIdEntity);
        userResult.setTypeId(userTypeId);

        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatedDate = newFormat.format(userEntityResult.getBirthday_date());
        userResult.setBirthday_date(formatedDate);

        return userResult;
    }

}
