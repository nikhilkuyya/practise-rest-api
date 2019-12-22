package practise.myproman.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import practise.myproman.api.model.SignupUserRequest;
import practise.myproman.api.model.SignupUserResponse;

@RestController
@RequestMapping("/")
public class SignupUserController {

    @RequestMapping(method = RequestMethod.POST, path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignupUserResponse> signup(final SignupUserRequest SignupUserRequest) {
        return new ResponseEntity(HttpStatus.OK);
    }

}