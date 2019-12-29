package practise.myproman.api.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import practise.myproman.api.model.AuthorizedUserResponse;
import practise.myproman.api.service.business.AuthenticationBusinessService;
import practise.myproman.api.service.exception.AuthenticationFailedException;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    private AuthenticationBusinessService authenticationService;

    @RequestMapping(method = RequestMethod.POST, path = "auth/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AuthorizedUserResponse> login(@RequestHeader("authorization") final String authorization)
            throws AuthenticationFailedException {
        String decodeInput = authorization.split("Basic ")[1];
        byte[] decodeOutput = Base64.getDecoder().decode(decodeInput);
        String[] decodeDetails = new String(decodeOutput).split(":");
        authenticationService.login(decodeDetails[0], decodeDetails[1]);
        return null;
    }
}