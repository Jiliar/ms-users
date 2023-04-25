package ar.com.redlink.controllers;

import ar.com.redlink.controllers.requests.UserRequest;
import ar.com.redlink.controllers.responses.Response;
import ar.com.redlink.converters.genders.GenderEntityToGender;
import ar.com.redlink.converters.user_types_ids.UserTypeIdEntityToUserTypeId;
import ar.com.redlink.converters.users.UserEntityToUser;
import ar.com.redlink.converters.users.UserRequestToUserEntity;
import ar.com.redlink.exceptions.MessageException;
import ar.com.redlink.models.Gender;
import ar.com.redlink.models.User;
import ar.com.redlink.models.UserTypeId;
import ar.com.redlink.services.IGenderService;
import ar.com.redlink.services.IUserService;
import ar.com.redlink.services.IUserTypeIdService;
import ar.com.redlink.services.impl.entities.GenderEntity;
import ar.com.redlink.services.impl.entities.UserEntity;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import ar.com.redlink.utils.ErrorHandler;
import ar.com.redlink.utils.TimeUtils;
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
public class UserController {

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

            Response response = new Response(details, path, TimeUtils.currentTimestamp());

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){

        Optional<UserEntity> optionalUser =  service.findById(id);
        return optionalUser.map(userEntityResult -> {
            Response response = UserDetails(userEntityResult, path);
            return ResponseEntity.ok()
                                 .body(response);
        }).orElseGet(() -> ResponseEntity.notFound()
                .build());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserRequest user, BindingResult result){
        Response response = null;
        try {
            if (result.hasErrors()) {
                return ErrorHandler.validate(result, path);
            }
            if (service.findByIdentification(user.getIdentification()).isPresent()) {
                List<String> details = new ArrayList();
                details.add("There is already a user with that ID");
                response = new Response(details, path, TimeUtils.currentTimestamp());
                return ResponseEntity
                        .badRequest()
                        .body(response);
            }
            UserEntity userEntity = UserRequestToUserEntity.INSTANCE.userRequestToUserEntity(user);
            userEntity.setStatus(1);
            userEntity.setRegistration_user(1);
            userEntity.setRegistration_date(LocalDateTime.now());
            UserEntity userEntityResult = service.save(userEntity);
            response = UserDetails(userEntityResult, path);
            return ResponseEntity.ok()
                    .body(response);
        }catch (MessageException e){
            List<MessageException> details = new ArrayList();
            details.add(e);
            response = new Response(details, path, TimeUtils.currentTimestamp());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
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
   public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody UserRequest user, BindingResult result){
       Response response = null;
        if(result.hasErrors()){
            return ErrorHandler.validate(result, path);
        }

        Optional<UserEntity> optionalUser =  service.findById(id);
        if(optionalUser.isPresent()){
            UserEntity userEntity = optionalUser.get();
            if( user.getEmail().equalsIgnoreCase(userEntity.getEmail())
                && !user.getEmail().isEmpty()){

                List<String> details = new ArrayList();
                details.add("There is already a user with that Email");
                response = new Response(details, path, TimeUtils.currentTimestamp());
                return ResponseEntity
                        .badRequest()
                        .body(response);

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
            response = UserDetails(userEntityResult, path);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }else{
            return ResponseEntity.notFound()
                    .build();
        }
    }

    public Response UserDetails(UserEntity userEntityResult, String path){

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

        List<User> details = new ArrayList();
        details.add(userResult);

        return new Response(details, path, TimeUtils.currentTimestamp());
    }

}
