package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.IPersonDao;
import greta.cda.bakeryproject.dto.SignUp;
import greta.cda.bakeryproject.dto.UpdatePersonDto;
import greta.cda.bakeryproject.entity.Person;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final IPersonDao personDao;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void signUp(SignUp signUp, String role) {
        Person person = Person.builder()
                .id(UUID.randomUUID())
                .login(signUp.getLogin())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(role)
                .build();

        personDao.add(person);
        logger.info("New subscription : login={}", person.getLogin());
    }

    public void deleteById(String id) {
        personDao.deleteById(UUID.fromString(id));
    }

    @Transactional
    public Person update(String id, UpdatePersonDto person) {
        Person personFounded = personDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id=%s not found", id)));

        personFounded.setLogin(person.getLogin());
        personFounded.setEmail(person.getEmail());
        personFounded.setPassword(person.getPassword());

        return personDao.update(personFounded);
    }

    public Person findById(String id) {
        return personDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id=%s not found", id)));
    }
}
