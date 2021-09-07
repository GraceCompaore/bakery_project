package greta.cda.bakeryproject.service;


import greta.cda.bakeryproject.dto.SignUp;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.repository.PersonRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void signUp(SignUp signUp) {
        Person person = Person.builder()
                .id (signUp.getId())
                .login(signUp.getLogin())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role("USER")
                .build();
        personRepository.save(person);
        logger.info("New subscription : login={}", person.getLogin());
    }
}
