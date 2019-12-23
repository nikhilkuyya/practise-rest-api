package practise.myproman.api.controller;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import practise.myproman.api.model.SignupUserRequest;
import practise.myproman.api.model.SignupUserResponse;
import practise.myproman.api.service.business.SignupRequestBusinessService;
import practise.myproman.api.service.entity.UserEntity;

@RestController
@RequestMapping("/")
public class SignupUserController {

    @Autowired
    private SignupRequestBusinessService userBusinessService;

    @RequestMapping(method = RequestMethod.POST, path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignupUserResponse> signup(final SignupUserRequest signupUserRequest) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setUuid(UUID.randomUUID().toString());
        userEntity.setFirstName(signupUserRequest.getFirstName());
        userEntity.setLastName(signupUserRequest.getLastName());
        userEntity.setEmail(signupUserRequest.getEmailAddress());
        userEntity.setPassword(signupUserRequest.getPassword());
        userEntity.setStatus(4);
        userEntity.setSalt("salt");
        userEntity.setMobilePhone(signupUserRequest.getMobileNumber());
        userEntity.setCreatedAt(ZonedDateTime.now());
        userEntity.setCreatedBy("api-backend");
        final UserEntity createdUserEntity = userBusinessService.signup(userEntity);
        SignupUserResponse signupUserResponse = new SignupUserResponse().id(createdUserEntity.getUuid())
                .status("REGISTERED");
        return new ResponseEntity<SignupUserResponse>(signupUserResponse, HttpStatus.CREATED);
    }

}