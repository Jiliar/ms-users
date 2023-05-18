package ar.com.redlink.controllers;

import ar.com.redlink.controllers.requests.UserRequest;
import ar.com.redlink.controllers.interfaces.IUserController;
import ar.com.redlink.converters.users.UserRequestToUserEntity;
import ar.com.redlink.converters.genders.GenderEntityToGender;
import ar.com.redlink.converters.user_types_ids.UserTypeIdEntityToUserTypeId;
import ar.com.redlink.converters.users.UserEntityToUser;
import ar.com.redlink.domain.Gender;
import ar.com.redlink.domain.User;
import ar.com.redlink.domain.UserTypeId;
import ar.com.redlink.services.IGenderService;
import ar.com.redlink.services.IUserService;
import ar.com.redlink.services.IUserTypeIdService;
import ar.com.redlink.services.impl.entities.GenderEntity;
import ar.com.redlink.services.impl.entities.UserEntity;
import ar.com.redlink.services.impl.entities.UserTypeIdEntity;
import ar.com.redlink.utils.ErrorCodes;
import com.github.damianwajser.exceptions.RestException;
import com.github.damianwajser.exceptions.impl.badrequest.BadRequestException;
import com.github.damianwajser.exceptions.impl.badrequest.ConflictException;
import com.github.damianwajser.exceptions.impl.badrequest.NotFoundException;
import com.github.damianwajser.exceptions.impl.servererror.InternalServerErrorException;
import com.github.damianwajser.exceptions.model.ExceptionDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

import static ar.com.redlink.utils.ErrorCodes.USER_EXISTS;
import static ar.com.redlink.utils.ErrorCodes.USER_NOT_FOUND;

@RestController
@Slf4j
public class UserController implements IUserController {

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable @Valid Long id) throws RestException {
        Optional<UserEntity> optionalUser =  service.findById(id);
        return optionalUser.map(userEntityResult -> {
            return ResponseEntity.ok()
                                 .body(userEntityResult);
        }).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMessage()));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Validated UserRequest user) throws ConflictException, InternalServerErrorException {

            if (service.findByIdentification(user.getIdentification()).isPresent()) {
                throw new ConflictException(USER_EXISTS.code, USER_EXISTS.getMessage());
            }

            UserEntity userEntity = UserRequestToUserEntity.INSTANCE.userRequestToUserEntity(user);
            userEntity.setStatus(1);
            userEntity.setRegistration_user(1);
            userEntity.setRegistration_date(LocalDateTime.now());
            UserEntity userEntityResult = service.save(userEntity);
            log.info(this.getClass().getSimpleName()+".create() : "+userEntityResult.toString());
            return ResponseEntity
                    .ok()
                    .body(userEntityResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable  @Valid Long id) throws RestException{
        Optional<UserEntity> optionalUser =  service.findById(id);
        if(optionalUser.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }else{
            throw new NotFoundException(USER_NOT_FOUND.code, USER_NOT_FOUND.getMessage());
        }
    }

   @PutMapping("/{id}")
   public ResponseEntity<?> update(@PathVariable  @Valid Long id, @RequestBody @Validated UserRequest user) throws RestException{

        Optional<UserEntity> optionalUser =  service.findById(id);
        if(optionalUser.isPresent()){
            UserEntity userEntity = optionalUser.get();
            if( user.getEmail().equalsIgnoreCase(userEntity.getEmail())
                && !user.getEmail().isEmpty()){
                throw new BadRequestException(USER_EXISTS.code, USER_EXISTS.getMessage());
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
            User userResult = UserDetails(userEntityResult);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userResult);
        }else{
            throw new NotFoundException(USER_NOT_FOUND.getCode(), USER_NOT_FOUND.getMessage());
        }
    }

    public User UserDetails(UserEntity userEntityResult){

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
