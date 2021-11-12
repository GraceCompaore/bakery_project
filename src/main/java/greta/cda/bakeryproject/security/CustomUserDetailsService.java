package greta.cda.bakeryproject.security;

import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // 1/ chercher notre Person via son login
        Person person = personRepository.findPersonByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Person with login=%s not found", login)));

        // 2/ transforme notre Person en UserDetails
        return User.builder()
                .username(person.getLogin())
                .password(person.getPassword())
                .authorities(person.getRole())
                .build();
    }
}
