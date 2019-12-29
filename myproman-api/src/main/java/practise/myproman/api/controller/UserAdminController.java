package practise.myproman.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import practise.myproman.api.model.UserDetailsResponse;
import practise.myproman.api.model.UserStatusType;
import practise.myproman.api.service.business.UserAdminBusinessService;
import practise.myproman.api.service.entity.UserEntity;
import practise.myproman.api.service.exception.ResourceNotFoundException;
import practise.myproman.api.type.UserStatus;

@RestController
@RequestMapping("/")
public class UserAdminController {

    @Autowired
    private UserAdminBusinessService userAdminBusinessService;

    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDetailsResponse> getUser(@PathVariable("id") final String id)
            throws ResourceNotFoundException {
        final UserEntity userEntity = userAdminBusinessService.getUser(id);

        final UserDetailsResponse userDetailsResponse = new UserDetailsResponse().firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName()).emailAddress(userEntity.getEmail())
                .mobileNumber(userEntity.getMobilePhone()).id(userEntity.getUuid())
                .status(UserStatusType.valueOf(UserStatus.getEnum(userEntity.getStatus()).name()));

        return new ResponseEntity<UserDetailsResponse>(userDetailsResponse, HttpStatus.OK);
    }
}