package greta.cda.bakeryproject.dao.impl;

import greta.cda.bakeryproject.dao.IPersonDao;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PersonDaoInDb implements IPersonDao {
    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Optional<Person> findById(UUID id) {
        return personRepository.findById(id);
    }

    @Override
    public Optional<Person> findByLogin(String login) {
        return personRepository.findPersonByLogin(login);
    }

    @Override
    public void deleteById(UUID id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }
}
