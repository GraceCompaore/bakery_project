package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.IPersonDao;
import greta.cda.bakeryproject.dto.LoginDto;
import greta.cda.bakeryproject.dto.SignUp;
import greta.cda.bakeryproject.entity.Person;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final IPersonDao personDao;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void signUp(SignUp signUp) {
        Person person = Person.builder()
                .id(UUID.randomUUID())
                .login(signUp.getLogin())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();

        personDao.add(person);
        logger.info("New subscription : login={}", person.getLogin());
    }

    public void deleteById(UUID id) {
        personDao.deleteById(id);
    }

    public void update(UUID id, LoginDto person) {
        Person personFounded = findById(id);

        if (personFounded != null) {
            personFounded.setLogin(person.getLogin());
            personFounded.setPassword(person.getPassword());
            personDao.update(personFounded);
        }
    }

    public Person findById(UUID id) {
        return personDao.findById(id);
    }
}
