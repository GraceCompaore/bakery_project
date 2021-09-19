package greta.cda.bakeryproject.dao.impl;

import greta.cda.bakeryproject.dao.IPersonDao;
import greta.cda.bakeryproject.entity.Person;
import greta.cda.bakeryproject.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonDaoInDb implements IPersonDao {
    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person findByLogin(String login) {
        return personRepository.findPersonByLogin(login).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }
}
