package greta.cda.bakeryproject.controller;

import greta.cda.bakeryproject.dto.SignUp;
import greta.cda.bakeryproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class SignUpController {
    private final PersonService personService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody SignUp signUp) {
        personService.signUp(signUp, "ROLE_CUSTOMER");
    }

    @PostMapping("/admin/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void signUpAdmin(@RequestBody SignUp signUp) {
        personService.signUp(signUp, "ROLE_ADMIN");
    }

}
